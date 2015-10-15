import java.lang.reflect.*;
import java.lang.*;
import java.io.*;
import java.util.*;


public class Inspector 
{
	public static void main(String[] args)
	{
		Object object = null;
		Class classObject=null;
		try
		{
			//load the class dynamically using 1st command-line arg
			classObject= Class.forName (args[0]);
			//create an instance of the class
			object = classObject.newInstance();
			//inspect(object, true); //Laura
		}
		catch (InstantiationException e)
		{
			System.out.println(e);
			return;
		}
		catch (IllegalAccessException e)
		{
			System.out.print(e);
			return;
		}
		catch (ClassNotFoundException e)
		{
			System.out.print(e);
			return;
		}

	}
	public void inspect(Object obj, boolean recursive)
	{
		//name of declaring class
		Class className=obj.getClass();
		//name of immediate superclass
		System.out.print ("Class name: ");
		output(className);
		Class superClassName=className.getSuperclass();
		//method the class declares
		Method[] methodArray=className.getMethods();
		analizeMethods(methodArray);
		//constructors the class declares
			//parameter types
			//modifiers
		//fileds the class declares
			//types
			//modifiers
	}
	
	public void analizeMethods(Method[] a)
	{
		for (int i=0; i<a.length; i++)
		{	
			System.out.print(i);
			System.out.println(") Method name");
			String methodName = a[i].toString();
			System.out.println (methodName);
			//exception thrown
			Class[] exceptions = a[i].getExceptionTypes();
			System.out.print("exceptions thrown: ");
			printArray(exceptions);
			//parameter types
			Class [] params = a[i].getParameterTypes();
			System.out.print("parameter types: ");
			printArray(params);
			//return types
			Class whatIsReturned = a[i].getReturnType();
			System.out.print("Return type: ");
			output(whatIsReturned);
			//modifiers
			int modifiers= a[i].getModifiers();
			//Laura this needs more work
		}
	}
	
	public void printArray (Class[] a)
	{
		System.out.print("( ");
		for(int i=0; i<a.length; i++)
		{
			System.out.print(a[i]);
			System.out.print(", ");
		}
		System.out.println(" )");
		return;
	}
	
	public void output(Class a)
	{
		String output= a.toString();
		System.out.println(output);
		return;
	}
}