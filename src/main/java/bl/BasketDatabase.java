package bl;

import data.Basket;
import data.Pizza;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class BasketDatabase {
    private Basket basket;
    public static BasketDatabase instance;

    public synchronized static BasketDatabase getTheInstance() {
        if(instance == null) {
            instance = new BasketDatabase();
        }
        return instance;
    }

    public Basket getBasket() {
        return basket;
    }


    public Optional<Pizza> deletePizza(int id) throws NoSuchElementException {
        Optional<Pizza> deletedPizza = basket.getProducts().stream().filter(p -> p.getId() == id).findFirst();

        if(deletedPizza.isPresent()) {
            basket.getProducts().remove(deletedPizza);
            return deletedPizza;
        }
        else {
            throw new NoSuchElementException();
        }
    }

}
