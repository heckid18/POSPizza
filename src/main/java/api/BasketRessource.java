package api;

import bl.BasketDatabase;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/basket")
public class BasketRessource {

    @Context
    private UriInfo uriInfo;

        @POST
        @Produces("application/json")
        public Response generateBasket(){
            try{

                BasketDatabase.getTheInstance();


                return Response.created(uriInfo.getAbsolutePathBuilder().build()).build();

            }catch (Exception e){
                e.printStackTrace();
            }
            return Response.status(Response.Status.CONFLICT).build();
        }

}
