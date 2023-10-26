package com.gameloft.mkyong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MkyongApplication implements CommandLineRunner {

	@Autowired
	private DatabaseService ds;
	
	public static void main(String[] args) {
		SpringApplication.run(MkyongApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(ds.getName());
	}

}
