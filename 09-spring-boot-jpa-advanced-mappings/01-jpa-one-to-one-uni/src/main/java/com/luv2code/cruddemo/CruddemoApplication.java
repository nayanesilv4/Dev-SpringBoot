package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner ->{
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
		/*Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Music!");
*/
		Instructor tempInstructor = new Instructor("Lilly", "Bloom", "blossombloom@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.blossoms.com/youtube", "Flowers!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");

	}
}
