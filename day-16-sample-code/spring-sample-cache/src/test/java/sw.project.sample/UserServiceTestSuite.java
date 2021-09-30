package sw.project.sample;

import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sw.project.sample.model.User;
import sw.project.sample.services.UserService;

import java.util.Random;

public class UserServiceTestSuite extends ServiceTestBase {

    @Autowired
    UserService userService;

    @Test
    public void testListUserObject() {
        for (int i = 0 ;i < 10 ; i++ ) {
            userService.listUserObject();
        }
    }

    @Test
    public void testSingleCacheForList() {
        for ( int i = 0 ; i < 10  ; i++ ) {
            if (i % 5 == 0 ) {
                userService.createUserObject(new User().setUsername("abc"+i)
                                                        .setPassword("123456")
                                                        .setEmail("abc@test.com.hk")
                                                        .setRemark("remark")
                                                        .setRole("customer service."));
            } else if (i == 7) {
                userService.clearUserObject();
            }
            System.out.println(new Gson().toJson(userService.listUserObject()));
        }
    }

    @Test
    public void testCacheByKey() {

        for ( int i = 0 ; i < 13  ; i++ ) {
            if (i % 4 == 0) {
                System.out.println(new Gson().toJson(userService.getUserObjectByUserName("weisting")));
            } else {
                System.out.println(new Gson().toJson(userService.getUserObjectByUserName("show")));
            }

        }
    }

    @Test
    public void testCacheByObjectField() {
        Random random = new Random();
        for ( int i = 0 ; i < 20  ; i++ ) {
            int rand = random.nextInt(500)*100;
            User user = new User();
            if (i % 5 == 0) {
                user.setId(rand).setUsername("cache")
                        .setPassword("3383838")
                        .setRole("sale")
                        .setRemark("cache is get")
                        .setEmail("test"+ i+(rand % 3 == 0 ? '@' : "") + "abbbb.com");
            } else {
                user.setId(rand).setUsername("cache")
                        .setPassword("3383838")
                        .setRole("sale")
                        .setRemark("cache is get")
                        .setEmail("test"+ (rand % 3 == 0 ? '@' : "") + "abbbb.com");

            }

            System.out.println(new Gson().toJson(userService.verifyUserEmail(user)));
        }
    }

    @Test
    public void testLogCacheByLogId() {
        for (int i = 0 ; i < 20 ; i++) {
            User user = new User();
            user.setId(i%5).setUsername("cache")
                    .setPassword("3383838")
                    .setRole("sale")
                    .setRemark("cache is get")
                    .setEmail("test"+ (i%5)+ "@abbbb.com");
            System.out.println(new Gson().toJson(userService.logUserById(user)));
        }
    }

    @Test
    public void testUpdateUserObject() {
        User user = new User()
                .setId(10)
                .setUsername("john2")
                .setRole("admin2")
                .setPassword("654321")
                .setEmail("john2@test.com.tw")
                .setRemark("come from Taipei.");
        System.out.println(new Gson().toJson(userService.listUserObject()));
        userService.updateUserObject(user);
        System.out.println(new Gson().toJson(userService.listUserObject()));
    }

    @Test
    public void testDeleteUserObject() {
        for (int i = 0 ;i < 10 ;i ++) {
            userService.listUserObject();
        }
        userService.clearUserObject();
        userService.listUserObject();
    }

}
