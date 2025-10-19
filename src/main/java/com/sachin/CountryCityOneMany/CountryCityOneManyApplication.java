package com.sachin.CountryCityOneMany;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// this is optional.
@EnableTransactionManagement
@SpringBootApplication
public class CountryCityOneManyApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(CountryCityOneManyApplication.class, args);
	}
}
