package com.example.ex009_pizzaservice;

import bl.PizzaDatabase;
import jakarta.ws.rs.GET;
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
}