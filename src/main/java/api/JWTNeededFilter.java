package api;

import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.crypto.MACVerifier;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
@Priority(Priorities.AUTHORIZATION)
@JWTNeeded
public class JWTNeededFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext c) throws IOException {
        String jwtString = c.getHeaderString("Authorization");

        try {
            JWSObject jwsObject = JWSObject.parse(jwtString);

            boolean verified = jwsObject.verify(new MACVerifier(LoginResource.JWT_SECRET));

            if (verified) {
                c.setProperty("user", jwsObject.getPayload().toString());
            }
            else {
                throw new Exception("Verification Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            c.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(e).build());
        }
    }
}
