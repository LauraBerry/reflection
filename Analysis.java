import java.io.*;
import java.lang.reflect.*;

public class Analysis
{		
	public void analizeMethods(Method[] a)
	{	
		Class[] temp;
		System.out.println("Methods");	
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
				temp=getTheExceptions(a[i]);
				System.out.print("		exceptions thrown: ");
				printArray(temp);
				//parameter types
				temp=getTheParameters(a[i]);
				System.out.print("		parameter types: ");
				printArray(temp);
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
	public void analizeConstructor(Constructor[] a)
	{
		Class[] temp;
		System.out.println("Constructors");	
		if(a.length==0)
		{
			System.out.println("		none");
		}
		else
		{
			for (int i=0; i<a.length; i++)
			{	
				System.out.print(i+1);
				System.out.print(")\n	 Constructor Name: ");
				String constructorName = a[i].getName();
				System.out.println (constructorName);

				//parameters
				temp=getTheParameters(a[i]);
				System.out.print("		parameter types: ");
				printArray(temp);
	
				//modifiers
				int modifiers= a[i].getModifiers();
				//Laura this needs more work
				//it's currently giving an integer, the int needs to be decoded and analized
			}
		}
		return;
	}
	public Class[] getTheParameters(Constructor a)
	{
		Class [] result = a.getParameterTypes();
		return result;
	}
	public Class[] getTheExceptions(Method a)
	{
		Class[] result = a.getExceptionTypes();
		return result;
	}
	public Class[] getTheParameters(Method a)
	{
		Class [] result = a.getParameterTypes();
		return result;
	}
	public void analizeFields(Field[] a)
	{
		System.out.println("Fields");
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
}
