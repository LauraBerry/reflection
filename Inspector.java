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
			//inspect(object, true);
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
		Class superClassName=className.getSuperClass();
		//method the class declares
		Method[] methodArray=className.getMethods();
			//exception thrown
			//parameter types
			//return types//modifiers
		//constructors the class declares
			//parameter types
			//modifiers
		//fileds the class declares
			//types
			//modifiers
	}
}