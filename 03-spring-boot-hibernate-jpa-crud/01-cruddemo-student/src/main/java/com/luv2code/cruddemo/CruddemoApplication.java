package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudent(studentDAO);

			// readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		System.out.println("Criando 3 estudantes...");
		Student tempStudent = new Student("Pedro", "Souza", "jp@luv2code.com");
		Student tempStudent02 = new Student("Nayane", "Costa", "naya@luv2code.com");
		Student tempStudent03 = new Student("Mariane", "Oliveira", "mariliveir@luv2code.com");

		System.out.println("Salvando 3 estudantes...");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent02);
		studentDAO.save(tempStudent03);

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Excluindo todos os estudantes...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Linhas deletadas: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 1;
		System.out.println("Excluindo estudante de Id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Encontrar estudante pelo id(Primary Key)
		int studentId = 2;
		System.out.println("Encontrando estudante com o Id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// mudar o sobrenome para "Oliveira"
		System.out.println("Atualizando Estudante...");
		myStudent.setLastName("Oliveira");

		// atualizar estudante
		studentDAO.update(myStudent);

		//Mostrar o aluno atualizado
		System.out.println("Estudante Atualizado: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Souza");
		for (Student tempStudent01 : theStudents){
			System.out.println(tempStudent01);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		// Ler uma lista de estudantes
		List<Student> theStudents = studentDAO.findAll();

		// Mostrar essa lista

		for (Student tempStudent01 : theStudents) {
			System.out.println(tempStudent01);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// Criando um novo objeto
		System.out.println("Criando um novo estudante...");
		Student tempStudent1 = new Student("Agatha", "Souza", "agnes@gmail.com");

		// Salvando um novo objeto
		System.out.println("Salvando no BD...");
		studentDAO.save(tempStudent1);

		//Gerando o Id
		int theId = tempStudent1.getId();
		System.out.println("Estudante criado. Id gerado: " + theId);

		//Encontrando o estudante pelo id

		System.out.println("Procurando o estudante com o id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// Mostrar estudante

		System.out.println("Estudante encontrado: " + myStudent);

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
