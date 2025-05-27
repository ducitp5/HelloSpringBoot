package org.o7planning.springbootmongodb;

import org.junit.jupiter.api.Test;
import org.o7planning.springbootmongodb.database.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataLoaderTest {

    @Autowired
    private DataLoader dataLoader;

    @Test
    void testRun() {
        dataLoader.run();
    }
}