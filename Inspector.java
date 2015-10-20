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
		
		Class[] interfaces = className.getInterfaces();
		analizeInterfaces(interfaces);
		
		//method the class declares
		Method[] methodArray=className.getDeclaredMethods();
		analizeMethods(methodArray);
		
		//constructors the class declares
		Constructor[] construct = className.getDeclaredConstructors();
		analizeConstructor(construct);

			
		//fileds the class declares
		Field[] fields= className.getDeclaredFields();
		analizeFields(fields, className);
		
		if (superClassName!=null)
		{
			try
			{
				Object obj_inheritance=superClassName.newInstance();
				inspect(obj_inheritance, recursive);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				return;
			}			
		}
			

	}

	public void analizeInterfaces(Class[] a)
	{
		Class[] temp;
		System.out.println("Interfacess");	
		if(a.length==0)
		{
			System.out.println("		none");
		}
		else
		{
			for (int i=0; i<a.length; i++)
			{
				System.out.print(i+1);
				System.out.print(")\n	 Interface name: ");
				String interfaceName = a[i].toString();
				System.out.println (interfaceName);	
			}
		}
		return;
	}
	
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
				temp = a[i].getExceptionTypes();
				System.out.print("		exceptions thrown: ");
				printArray(temp);
				//parameter types
				temp=a[i].getParameterTypes();
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
	
	public void analizeFields(Field[] a, Class b)
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
				//value
				Object value=getvalue(a[i],b);
				//modifiers	
				int mods=a[i].getModifiers();
				//Laura this also needs more work.
			}
		}
		return;
	}
	
	public Object getvalue(Field a, Class b)
	{
		Object result=null;
		try
		{
			Object myObj = b.newInstance();
			result= a.get(myObj);
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return result;
		}
		
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
				temp=a[i].getParameterTypes();
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
