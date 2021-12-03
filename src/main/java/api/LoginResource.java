package api;

import bl.UserDatabase;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import data.LoginData;
import data.User;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.NoSuchElementException;

@Path("/login")
public class LoginResource {

    public static String JWT_SECRET = "my-jwt-secret-is-not-long-enough";

    public String createJWT(User u) throws JOSEException {

        JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256), new Payload(u.getEmail() + u.getPassword()));
        jwsObject.sign(new MACSigner(JWT_SECRET.getBytes()));

        return jwsObject.serialize();
    }

    @POST
    public Response login(LoginData loginData) {

        try {

            User u = UserDatabase.getInstance().getUserbyEmailandPassword(loginData.getEmail(), loginData.getPassword());

            return Response.ok().header("Authorization", createJWT(u)).entity(u).build();

        } catch (NoSuchElementException nsex) {

            return Response.status(Response.Status.UNAUTHORIZED).build();

        } catch (JOSEException je) {

            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

}
