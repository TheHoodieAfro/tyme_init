package co.edu.icesi.ci.thymeval;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import co.edu.icesi.ci.thymeval.model.User;
import co.edu.icesi.ci.thymeval.model.UserGender;
import co.edu.icesi.ci.thymeval.model.UserType;
import co.edu.icesi.ci.thymeval.service.UserServiceImpl;

@SpringBootApplication
public class ThymeleafValidationApplication {

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

	public static void main(String[] args) {
		//SpringApplication.run(ThymeleafValidationApplication.class, args);
		
		ConfigurableApplicationContext c = SpringApplication.run(ThymeleafValidationApplication.class, args);
		
		UserServiceImpl u = c.getBean(UserServiceImpl.class);
		
		User user1 = new User();
		user1.setName("Juan");
		user1.setEmail("jc@gmail.com");
		user1.setType(UserType.doctor);
		user1.setGender(UserGender.masculine);
		user1.setBirthDate(LocalDate.now());
		u.save(user1);
		
		User user2 = new User();
		user2.setName("Ana");
		user2.setEmail("ana@gmail.com");
		user2.setType(UserType.patient);
		user2.setGender(UserGender.femenine);
		user2.setBirthDate(LocalDate.now());
		u.save(user2);


	}

}
