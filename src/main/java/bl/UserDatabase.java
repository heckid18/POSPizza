package bl;

import data.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserDatabase {

    private static UserDatabase theInstance;

    private List<User> users;

    public UserDatabase() {
        users.add(new User("lanjod18@htl-kaindorf.at", "lanjod18"));
        users.add(new User("heckid18@htl-kaindorf.at", "heckid18"));
        users.add(new User("maxmustermann@htl-kaindorf.at", "maxmustermann"));
    }

    public static synchronized UserDatabase getInstance() {
        if (theInstance == null) {
            theInstance = new UserDatabase();
        }
        return theInstance;
    }


    public List<User> getUsers() throws NoSuchElementException {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUserbyEmailandPassword(String email, String password) {

        Optional<User> user = users.stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst();

        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new NoSuchElementException();
        }
    }
}
