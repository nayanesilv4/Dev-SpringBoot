package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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

			//createInstructor(appDAO);

			//findInstructor(appDAO);

			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);

			//deleteInstructorDetail(appDAO);

			//createInstructorWithCourses(appDAO);

			//findInstructorWithCourses(appDAO);

			//findCoursesForInstructor(appDAO);

			//findInstructorWithCoursesJoinFetch(appDAO);

			//updateInstructor(appDAO);

			//updateCourse(appDAO);

			//deleteInstructor(appDAO);

			deleteCourse(appDAO);
		};
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
