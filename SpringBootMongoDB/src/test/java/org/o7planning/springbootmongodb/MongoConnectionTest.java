package org.o7planning.springbootmongodb;

import org.junit.jupiter.api.Test;
import org.o7planning.springbootmongodb.document.Employee;
import org.o7planning.springbootmongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MongoConnectionTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testMongoConnectionAndInsert() {

        System.out.println("Inserted employees into MongoDB.-------");

        Employee emp = new Employee();
        emp.setEmpNo("EMP999");
        emp.setFullName("Test User");
        emp.setHireDate(new Date());

        Employee saved = employeeRepository.save(emp);
        assertThat(saved.getId()).isNotNull();

        employeeRepository.delete(saved); // cleanup
    }
}
