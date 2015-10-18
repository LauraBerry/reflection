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
		Class superClassName=className.getSuperclass();
		System.out.print ("Super Class name: ");
		output(superClassName);//Laura it is not printing the right thing, it says "java.lang.object"
		System.out.println("");
		
		//method the class declares
		Method[] methodArray=className.getDeclaredMethods();
		Analysis forAnalysis= new methodAnalysis();
		forAnalysis.analizeMethods(methodArray);
		
		//constructors the class declares
		Constructor[] construct = className.getDeclaredConstructors();
		forAnalysis.analizeConstructor(construct);

			
		//fileds the class declares
		Field[] fields= className.getDeclaredFields();
		forAnalysis.analizeFields(fields);

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
		if(a==null)
		{
			System.out.println("none");
		}
		else
		{
			String output= a.getName();
			System.out.println(output);
		}
		return;
	}
}
