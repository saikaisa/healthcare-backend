package top.saikaisa.healthcarebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.saikaisa.healthcarebackend.mapper")
public class HealthcareBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthcareBackendApplication.class, args);
    }

}
