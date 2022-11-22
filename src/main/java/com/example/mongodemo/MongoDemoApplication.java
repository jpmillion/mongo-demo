package com.example.mongodemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {

            Address address = Address.builder()
                    .city("New Castle")
                    .country("USA")
                    .postCode("16102")
                    .build();

            Student student = Student.builder()
                    .address(address)
                    .email("example@example.com")
                    .gender(Gender.FEMALE)
                    .favouriteSubjects(List.of("Math", "English", "Gym"))
                    .firstName("Mary")
                    .lastName("Million")
                    .created(LocalDateTime.now())
                    .build();

            repository.insert(student);
        };
    }
}
