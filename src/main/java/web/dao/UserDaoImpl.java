package web.dao;

import org.springframework.stereotype.Repository;
import web.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
@Repository
public class UserDaoImpl implements UserDao{


    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, User> users = new HashMap<>();

    static {
        User user1 = new User();
        user1.setId(AUTO_ID.getAndIncrement());
        user1.setName("Ivan");
        user1.setLastname("Ivanov");
        user1.setLogin("IVANUSHKA");
        users.put(user1.getId(), user1);

        User user2 = new User();
        user2.setId(AUTO_ID.getAndIncrement());
        user2.setName("Egor");
        user2.setLastname("Egorov");
        user2.setLogin("EGORUSHKA");
        users.put(user2.getId(), user2);

        User user3 = new User();
        user3.setId(AUTO_ID.getAndIncrement());
        user3.setName("Andrey");
        user3.setLastname("Andreev");
        user3.setLogin("ANDREUSHKA");
        users.put(user3.getId(), user3);

        // + film2, film3, film4, ...
    }
    @Override
    public List<User> allUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void add(User user) {
        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public void edit(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User  getById(int id) {
        return users.get(id);
    }

}
