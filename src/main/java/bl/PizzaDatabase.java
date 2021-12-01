package bl;

import data.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PizzaDatabase {

    private static PizzaDatabase theInstance;
    private List<Pizza> pizzaList;


    public PizzaDatabase(){
        CSVHandler z = new CSVHandler();
        pizzaList = new ArrayList<>();

        pizzaList = z.readCSV("../res/data.csv");

    }




    public synchronized static PizzaDatabase getTheInstance(){
        if (theInstance == null){
            theInstance = new PizzaDatabase();
        }
        return theInstance;
    }


    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

}
