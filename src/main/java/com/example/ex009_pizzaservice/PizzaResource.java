package com.example.ex009_pizzaservice;

import bl.BasketDatabase;
import bl.PizzaDatabase;
import data.Pizza;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/pizza")
public class PizzaResource {

    @GET
    @Produces("application/json")
    public Response getAllPizzas() {
             return Response.ok().entity(PizzaDatabase.getTheInstance().getPizzaList()).build();
     }

    @PUT
    @Produces("application/json")
    public Response addPizza(Pizza p){

        BasketDatabase.getTheInstance().getBasket().getProducts().add(p);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}