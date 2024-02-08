package com.timothy.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;


@SpringBootApplication
@RestController
public class SpringtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtestApplication.class, args);
	}

//	@GetMapping
//	public String hello() {
//		return "Hello World!";
//	}

//new Student( 1L,
//					 "Jeanine Bent",
//					 "jeanine_bent@hotmail.co.uk",
//			 LocalDate.of(1987, Month.APRIL, 14),
//                        35)
}
