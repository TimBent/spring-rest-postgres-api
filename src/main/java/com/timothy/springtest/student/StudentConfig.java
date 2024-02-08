package com.timothy.springtest.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student jeanine = new Student(
                    "Jeanine Bent",
                    "jeanine_bent@hotmail.co.uk",
                    LocalDate.of(1987, APRIL, 14));

            Student timothy = new Student(
                    "Timothy Bent",
                    "tim-bent@hotmail.co.uk",
                    LocalDate.of(1996, JUNE, 7));

            repository.saveAll(
                    List.of(jeanine, timothy)
            );
        };
    }
}
