package bl;

import data.Basket;

import java.util.List;

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

}
