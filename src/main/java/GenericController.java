package main.java;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Esta controller genérico parte do princípio de que as funções getters tenham o formato:
// "get" + FieldName, onde FieldName é o nome do Field atribuído a este getter.
//Os setters tem o formato: "set" + FieldName

public class GenericController {
	
	public Object model;
	
	public GenericController (Object _model)
	{
		model = _model;
	}
	
	public void printFields () throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
	{
		Field[] fields = model.getClass().getDeclaredFields();
		Method[] methods = model.getClass().getMethods();
		
		//Invoca os getters.
		for (Method method:methods)
		{
			if (method.getName().contains("get") && !method.getName().contains("Class"))
				System.out.println(method.getName() + " = " +  method.invoke(model, null));
		}
	}
	
	//Esta função tem assinatura setFunction (String FieldName, String NewValue)
	//Ela seta o campo "FieldName" com o valor String NewValue.
	public void setFunction (String FieldName, String NewValue) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Method[] methods = model.getClass().getMethods();

		//Encontra o setter correspondente.
		
		for (Method method:methods)
		{
			Object[] a = new Object[1];
			a[0] = NewValue;
			
			if (method.getName().contains("set") && method.getName().toUpperCase().contains(FieldName.toUpperCase())   )
				method.invoke(model, a);
		}
	}
	
	
	public Object getFunction (String FieldName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Method[] methods = model.getClass().getMethods();

		//Encontra o setter correspondente.
		
		for (Method method:methods)
		{
			if (method.getName().contains("get") && method.getName().toUpperCase().contains(FieldName.toUpperCase())   )
				return method.invoke(model, null);
		}
		return null;
	}
	
	
	
}
