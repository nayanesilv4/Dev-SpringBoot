package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
		 createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO){

		// criar o objeto "Student"

		System.out.println("Criando um estudante...");
		Student tempStudent = new Student("Pedro", "Souza", "jp@luv2code.com");


		// Salvar o objeto "Student"

		System.out.println("Salvando um estudante...");
		studentDAO.save(tempStudent);


		//mostrar o id do objeto salvo
		System.out.println("Estudante salvo. Id gerado: " + tempStudent.getId());
	}
}
