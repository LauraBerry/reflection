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
		output(superClassName);
		System.out.println("");
		
		//method the class declares
		Method[] methodArray=className.getDeclaredMethods();
		methodAnalysis meth= new methodAnalysis();
		meth.analizeMethods(methodArray);
		
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
