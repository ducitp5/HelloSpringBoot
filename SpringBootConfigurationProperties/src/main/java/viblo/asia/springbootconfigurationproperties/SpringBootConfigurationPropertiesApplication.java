package viblo.asia.springbootconfigurationproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConfigurationPropertiesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigurationPropertiesApplication.class, args);
    }

    @Autowired
    LodaAppProperties lodaAppProperties;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Global variable:");
        System.out.println("\t Email: "+lodaAppProperties.getEmail());
        System.out.println("\t GA ID: "+lodaAppProperties.getGoogleAnalyticsId());
    }
}
