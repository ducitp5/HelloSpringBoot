package org.o7planning.springbootmongodb;

import org.junit.jupiter.api.Test;
import org.o7planning.springbootmongodb.database.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMongoDbApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private DataLoader dataLoader;

    @Test
    void testRun() {
        try {
            dataLoader.run();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("run() threw exception: " + e.getMessage());
        }
    }
}
