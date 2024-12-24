package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner ->{

			//createCourseAndStudents(appDAO);

			//findCourseAndStudents(appDAO);

			//findStudentAndCourses(appDAO);
			
			//addMoreCoursesForStudent(appDAO);

			//deleteCourse(appDAO);
			
			deleteStudent(appDAO);

		};
	}

	private void deleteStudent(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deletando estudante: " + theId);

		appDAO.deleteStudentById(theId);

		System.out.println("Estudante deletado!");

	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int theId =2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		Course tempCourse1 = new Course("Sociologia do turismo");
		Course tempCourse2 = new Course("Marketing");

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Atualizando estudantes: " + tempStudent);
		System.out.println("Cursos associados: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Aluno atualizado!");

	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int theId=1;

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println("Carregando estudante: " + tempStudent);
		System.out.println("Cursos: " + tempStudent.getCourses());

		System.out.println("Feito!");

	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int theId=10;
		Course tempCourse = appDAO.findCourseAndStudentByCourseId(theId);

		System.out.println("Carregando curso: " + tempCourse);
		System.out.println("Estudantes: " + tempCourse.getStudents());

		System.out.println("Feito!");

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// criar o curso

		Course tempCourse = new Course("Introdução ao turismo");

		//criar os estudantes

		Student tempStudent1 = new Student("Powder", "Harmor", "PowJinx@gmail.com");
		Student tempStudent2 = new Student("Violet", "Harmor", "IvVi@gmail.com");

		// adicionar os estudantes a um curso

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// salvar o curso e os estudantes associados

		System.out.println("Salvando o curso: " + tempCourse);
		System.out.println("Estudantes associados: " + tempCourse.getStudents());

		appDAO.save(tempCourse);

		System.out.println("Salvo!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deletando curso de id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Curso deletado!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println(tempCourse);

		System.out.println(tempCourse.getReviews());

		System.out.println("Feito!");

	}

	private void createCourseAndReviews(AppDAO appDAO) {

		//criar o curso
		Course tempCourse = new Course("Inglês Aplicado ao Turismo");

		// add comentarios
		tempCourse.addReview(new Review("Cool Course"));
		tempCourse.addReview(new Review("Great course...loved it!"));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot"));

		//salvar no bd
		System.out.println("Salvando o curso");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Curso salvo!");

	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deletando curso de Id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Curso deletado!");

	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Procurando curso de id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Atualizando curso de id: " + theId);
		tempCourse.setTitle("How to grow flowers");

		appDAO.update(tempCourse);

		System.out.println("Curso atualizado!");
	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		//find the instructor
		System.out.println("Procurando instrutor de id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("atualizando instrutor de id: " + theId);
		tempInstructor.setLastName("Corrigan");

		appDAO.update(tempInstructor);

		System.out.println("Instrutor atualizado!");

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Instrutor: " + tempInstructor);
		System.out.println("Cursos associados: " + tempInstructor.getCourses());

		System.out.println("Feito!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Procurando instrutor de Id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Instrutor encontrado: " + tempInstructor);

		System.out.println("Procurando cursos pelo id do instrutor: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);

		System.out.println("Cursos associados: " + tempInstructor.getCourses());

		System.out.println("Finalizado!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Procurando instrutor de Id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Instrutor encontrado: " + tempInstructor);
		System.out.println("Cursos Associados: " + tempInstructor.getCourses());

		System.out.println("Finalizado!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Lilly", "Bloom", "blossoms@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.blossoms.com/youtube", "Flowers!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("The Flower's Power");
		Course tempCourse2 = new Course("Medicinal Plants");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Salvando Instrutor..." + tempInstructor);
		System.out.println("Os cursos: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId=3;
		System.out.println("Deletando instrutor: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");

	}

	private void findInstructorDetail(AppDAO appDAO) {

		int theId=2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		System.out.println("the associate instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done!");

	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId=1;
		System.out.println("Deletando instrutor de id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");

	}

	private void findInstructor(AppDAO appDAO){

		int theId=2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());

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
