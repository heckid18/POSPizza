package bl;

import data.Pizza;

import java.util.ArrayList;
import java.util.List;

public class BasketDatabase {

    private static BasketDatabase theInstance;
    private List<Pizza> pizzaList;


    public BasketDatabase(){
        pizzaList = new ArrayList<>();

        pizzaList.add(new Pizza("Magaritha", (float) 6.50, "picture"));
        pizzaList.add(new Pizza("Salami", (float) 7.00, "picture1"));
        pizzaList.add(new Pizza("Prosciutto", (float) 7.00, "picture2"));
        pizzaList.add(new Pizza("Rucola", (float) 12.00, "picture3"));
        pizzaList.add(new Pizza("Hawaii", (float) 8.00, "picture4"));

    }




    public synchronized static BasketDatabase getTheInstance(){
        if (theInstance == null){
            theInstance = new BasketDatabase();
        }
        return theInstance;
    }


}
