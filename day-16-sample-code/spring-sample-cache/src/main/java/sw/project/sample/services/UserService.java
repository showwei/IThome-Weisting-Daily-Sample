package sw.project.sample.services;

import sw.project.sample.model.User;

import java.util.List;

public interface UserService {
    List<User> listUserObject();
    User getUserObjectByUserName(String name );
    User createUserObject(User user);
    List<User> updateUserObject(User user);
    boolean clearUserObject();
    User verifyUserEmail(User user);
    User logUserById(User user);
}
