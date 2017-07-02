package test.java;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import main.java.GenericController;
import main.java.Student;

public class Teste {

	@Test
	public void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Student a = retriveStudentFromDatabase();
		
		GenericController GC = new GenericController(a);
		
		assertEquals(GC.getFunction("Name"), "Robert");
		
		GC.setFunction("Name", "John");
		
		assertEquals(GC.getFunction("Name"), "John");
		
		GC.printFields();
		
		GC.setFunction("RollNo", "11");
		
		assertEquals(GC.getFunction("RollNo"), "11");
		
		GC.printFields();
		
	}
	
	private static Student retriveStudentFromDatabase()
	{
		Student student = new Student();
		student.setName("Robert");
		student.setRollNo("10");
		return student;
	}

}
