package com.springprojects.restful_web_services.socialmedia.model;

import com.springprojects.restful_web_services.socialmedia.exception.UserNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    private static int usersCount = 0;
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(++usersCount, "Morgoth", LocalDate.now().minusYears(9000)));
        userList.add(new User(++usersCount, "Hurin", LocalDate.now().minusYears(77)));
        userList.add(new User(++usersCount, "Fingolfin", LocalDate.now().minusYears(1234)));
    }

    public List<User> findAll() {
        return userList;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        User user = userList.stream().filter(predicate).findFirst().orElse(null);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException("id: " + id);
        }
        return user;
    }

    public User save(User user) {
        user.setId(++usersCount);
        userList.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        userList.removeIf(predicate);
    }
}
