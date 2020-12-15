package com.redbyte.platfrom.demomongodb;

import com.redbyte.platfrom.demomongodb.mongodb.AbstractMongoDBService;
import com.redbyte.platfrom.demomongodb.mongodb.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoMongodbApplicationTests {

    @Autowired
    private AbstractMongoDBService mongoDBService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setId("2");
        user.setName("elaine");
        user.setAge("25");
        mongoDBService.save(user, "taskInfo");
    }

    @Test
    void testRemove() {
        mongoDBService.deleteById("2", "taskInfo");
    }

}
