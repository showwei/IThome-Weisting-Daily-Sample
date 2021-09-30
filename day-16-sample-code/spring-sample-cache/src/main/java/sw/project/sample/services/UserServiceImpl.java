package sw.project.sample.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import sw.project.sample.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> userList = new ArrayList<>();

    private static List<User> logList = new ArrayList<>();
    static {
        userList.add(new User()
                    .setId(10)
                    .setUsername("john")
                    .setRole("admin")
                    .setPassword("123456")
                    .setEmail("john@test.com.tw")
                    .setRemark("come from penghu."));
        userList.add(new User()
                        .setId(20)
                        .setUsername("weisting")
                        .setRole("sales")
                        .setPassword("654321")
                        .setEmail("test@test.com.tw")
                        .setRemark("come from taoyuan"));
        userList.add(new User()
                        .setId(30)
                        .setUsername("show")
                        .setRole("customer")
                        .setPassword("987765")
                        .setEmail("ssss@test.com.tw")
                        .setRemark("come from taipei"));
    }
    @Cacheable(value = "cache1", sync = true)
    @Override
    public List<User> listUserObject() {
        System.out.println("list user Object!");
        return this.userList;
    }

    @Cacheable(value="user", key="#name")
    @Override
    public User getUserObjectByUserName(String name) {
        System.out.println("get user Object by user " + name + "!");
        return this.userList.stream().filter(user -> {
            return user.getUsername().equalsIgnoreCase(name);
        }).findAny().orElse(null);
    }

    @Cacheable(value="userCache", key="#user.email")
    @Override
    public User verifyUserEmail(User user) {
        System.out.println("Verify User Email success.");
        if (user.getEmail().contains("@"))
            return user;
        user.setEmail("N/A");
        return user;
    }

    @Cacheable(value={"userCacheId"}, key="#user.id", condition="#user.id%2==0")
    @Override
    public User logUserById(User user) {
        System.out.println("log user by username: " + user.getId());
        logList.add(user);
        return user;
    }

    @Override
    public User createUserObject(User user) {
        System.out.println("create user Object!");
        this.userList.add(user);
        return user;
    }
    @CachePut("updateCache")
    @Override
    public List<User> updateUserObject(User user) {
        System.out.println("update user Object!");
        this.userList = this.userList.stream().map(userObj -> {
            if (String.valueOf(userObj.getId()).equalsIgnoreCase(String.valueOf(user.getId()))) {
                userObj.setUsername(user.getUsername());
                userObj.setEmail(user.getEmail());
                userObj.setPassword(user.getPassword());
                userObj.setRole(user.getRole());
                userObj.setRemark(user.getRemark());
            }
            return userObj;
        }).collect(Collectors.toList());
        return this.userList;
    }

    @CacheEvict(value="cache1", allEntries=true, beforeInvocation=true)
    @Override
    public boolean clearUserObject() {
        System.out.println("Clear cache finish");
        this.userList.clear();
        return true;
    }
}
