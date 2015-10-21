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
		
		Class[] interfaces = className.getInterfaces();
		
		//method the class declares
		Method[] methodArray=className.getDeclaredMethods();
		
		//constructors the class declares
		Constructor[] construct = className.getDeclaredConstructors();

			
		//fileds the class declares
		Field[] fields= className.getDeclaredFields();
		
		Analize(interfaces,methodArray, construct, fields, className);
		//traverse the class hierarchy 
		if (recursive==true && (superClassName!=null&&superClassName.getName()!="java.lang.Object"))
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

	public void Analize(Class[] a, Method[] b, Constructor[] d, Field[] c, Class e)
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

		System.out.println("Methods");	
		if(b.length==0)
		{
			System.out.println("		none");
		}
		else
		{
			for (int i=0; i<b.length; i++)
			{	
				System.out.print(i+1);
				System.out.print(")\n	 Method name: ");
				String methodName = b[i].toString();
				System.out.println (methodName);
				//exception thrown
				temp = b[i].getExceptionTypes();
				System.out.print("		exceptions thrown: ");
				printArray(temp);
				//parameter types
				temp=b[i].getParameterTypes();
				System.out.print("		parameter types: ");
				printArray(temp);
				//return types
				Class whatIsReturned = b[i].getReturnType();
				System.out.print("		Return type: ");
				output(whatIsReturned);
				//modifiers
				int modifiers= b[i].getModifiers();
				System.out.print("		Modifier: ");
				String mods = Modifier.toString(modifiers);
				System.out.println(mods);
				//it's currently giving an integer, the int needs to be decoded and analized
			}
		}

		System.out.println("Fields");
		if(c.length==0)
		{
			System.out.println("		none");
		}
		else
		{
			for (int i=0; i<c.length; i++)
			{
				System.out.print(i+1);
				System.out.print(")\n 	Field Name: ");
				String fieldName=c[i].toString();
				System.out.println(fieldName);
				//types
				Class fieldType=c[i].getType();
				System.out.print("		Field Type: ");
				output(fieldType);
				//value
				Object value=getvalue(c[i],e);
				System.out.print("		Field value: ");
				String fieldValName=String.valueOf(value);
				System.out.println(fieldValName);
				//modifiers	
				int modifiers=c[i].getModifiers();
				System.out.print("		Modifier: ");
				String mods = Modifier.toString(modifiers);
				System.out.println(mods);
			}
		}
		System.out.println("Constructors");	
		if(d.length==0)
		{
			System.out.println("		none");
		}
		else
		{
			for (int i=0; i<d.length; i++)
			{	
				System.out.print(i+1);
				System.out.print(")\n	 Constructor Name: ");
				String constructorName = d[i].getName();
				System.out.println (constructorName);

				//parameters
				temp=d[i].getParameterTypes();
				System.out.print("		parameter types: ");
				printArray(temp);
	
				//modifiers
				int modifiers= d[i].getModifiers();
				System.out.print("		Modifier: ");
				String mods = Modifier.toString(modifiers);
				System.out.println(mods);
			}
		}
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
	
	public void analizeConstructor()
	{
		Class[] temp;

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
