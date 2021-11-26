package bl;

import data.Pizza;

import java.util.ArrayList;
import java.util.List;

public class BasketDatabase {

    private static BasketDatabase theInstance;
    private List<Pizza> pizzaList;


    public BasketDatabase(){
        CSVHandler z = new CSVHandler();
        pizzaList = new ArrayList<>();

        pizzaList = z.readCSV();

    }




    public synchronized static BasketDatabase getTheInstance(){
        if (theInstance == null){
            theInstance = new BasketDatabase();
        }
        return theInstance;
    }


}
