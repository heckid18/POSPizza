package api;

import bl.BasketDatabase;
import data.Basket;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

import java.util.NoSuchElementException;

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


        @GET
        @Produces("application/json")

        public Response getBasket() {

            try {
                Basket basket =  BasketDatabase.getTheInstance().getBasket();
                return Response.ok(basket).build();
            }
            catch(NoSuchElementException nsee){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }

}
