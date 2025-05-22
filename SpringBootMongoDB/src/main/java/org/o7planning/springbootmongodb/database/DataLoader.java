package org.o7planning.springbootmongodb.database;

import com.github.javafaker.Faker;
import org.o7planning.springbootmongodb.document.Employee;
import org.o7planning.springbootmongodb.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.IntStream;

@Component
public class DataLoader {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private final EmployeeRepository employeeRepository;
    static EmployeeRepository staticemployeeRepository;

    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void run(String... args) {
        Faker faker = new Faker();
        Random random = new Random();

        List<Employee> employees = new ArrayList<>();

        IntStream.rangeClosed(1, 20).forEach(i -> {
            Long id = (long) i;
            String empNo = "EMP" + String.format("%03d", i);
            String fullName = faker.name().fullName();
            Date hireDate = faker.date().between(
                    new GregorianCalendar(2018, Calendar.JANUARY, 1).getTime(),
                    new GregorianCalendar(2024, Calendar.DECEMBER, 31).getTime()
            );

            Employee employee = new Employee();

            employee.setId((id));
//            employee.setId(id);
            employee.setEmpNo(empNo);
            employee.setFullName(fullName);
            employee.setHireDate(hireDate);

            employees.add(employee);
        });

        System.out.println("before insert employees into MongoDB.");
        logger.info("Before inserting employees...");
        employeeRepository.saveAll(employees);
        System.out.println("Inserted " + employees.size() + " employees into MongoDB.");
        logger.info("Inserted {} employees into MongoDB.", employees.size());
    }

    public static void main(String[] args) {
        // manually create EmployeeRepository mock or real instance (not recommended for Mongo)

        DataLoader dataLoader = new DataLoader(staticemployeeRepository);

        System.out.println("Running data loader...-----------");
        dataLoader.run();
    }
}
