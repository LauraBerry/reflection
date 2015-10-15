import java.lang.reflect.*;
import java.lang.*;
import java.io.*;
import java.util.*;


public class Inspector 
{
	public void inspect(Object obj, boolean recursive)
	{
		//name of declaring class
		Class className=obj.getClass();
		System.out.print ("\nClass name: ");
		output(className);
		System.out.println("");
		
		//name of immediate superclass
		Class superClassName=className.getSuperclass(); //Laura problem here: it is returning the class name not the super class name.
		System.out.print ("Super Class name: ");
		output(className);
		System.out.println("");
		
		//method the class declares
		Method[] methodArray=className.getDeclaredMethods();
		System.out.println("Methods");
		analizeMethods(methodArray);
		
		//constructors the class declares
			//parameter types
			//modifiers
			
		//fileds the class declares
		Field[] fields= className.getDeclaredFields();
		System.out.println("Fields");
		analizeFields(fields);

	}
	public void analizeFields(Field[] a)
	{
		if(a.length==0)
		{
			System.out.println("		none");
		}
		else
		{
			for (int i=0; i<a.length; i++)
			{
				System.out.print(i+1);
				System.out.print(")\n 	Field Name: ");
				String fieldName=a[i].toString();
				System.out.println(fieldName);
				//types
				Class fieldType=a[i].getType();
				System.out.print("		Field Type: ");
				output(fieldType);
				//modifiers	
				int mods=a[i].getModifiers();
				//Laura this also needs more work.
			}
		}
		return;
	}
	public void analizeMethods(Method[] a)
	{		
		if(a.length==0)
		{
			System.out.println("		none");
		}
		else
		{
			for (int i=0; i<a.length; i++)
			{	
				System.out.print(i+1);
				System.out.print(")\n	 Method name: ");
				String methodName = a[i].toString();
				System.out.println (methodName);
				//exception thrown
				Class[] exceptions = a[i].getExceptionTypes();
				System.out.print("		exceptions thrown: ");
				printArray(exceptions);
				//parameter types
				Class [] params = a[i].getParameterTypes();
				System.out.print("		parameter types: ");
				printArray(params);
				//return types
				Class whatIsReturned = a[i].getReturnType();
				System.out.print("		Return type: ");
				output(whatIsReturned);
				//modifiers
				int modifiers= a[i].getModifiers();
				//Laura this needs more work
				//it's currently giving an integer, the int needs to be decoded and analized
			}
		}
		return;
	}
	
	public void printArray (Class[] a)
	{
		if(a.length==0)
		{
			System.out.println("none");
		}
		else
		{
			System.out.print("( ");
			for(int i=0; i<a.length; i++)
			{
				System.out.print(a[i]);
				System.out.print(", ");
			}
			System.out.println(" )");
		}
		return;
	}
	
	public void output(Class a)
	{
		String output= a.toString();
		System.out.println(output);
		return;
	}
}