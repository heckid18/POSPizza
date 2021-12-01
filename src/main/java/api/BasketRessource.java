package api;

import bl.BasketDatabase;
import data.Pizza;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/basket")
public class BasketRessource {

    @Context
    private UriInfo uriInfo;

    @POST
    @Produces("application/json")
    public Response generateBasket() {
        try {

            BasketDatabase.getTheInstance();


            return Response.created(uriInfo.getAbsolutePathBuilder().build()).build();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.CONFLICT).build();
    }


    @PUT
    @Produces("application/json")
    public Response addPizza(Pizza p) {

        BasketDatabase.getTheInstance().getBasket().getProducts().add(p);

        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
