package com.example.fakeStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class FakeStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeStoreApplication.class, args);
	}

}
