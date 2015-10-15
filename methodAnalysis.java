import java.io.*;
import java.lang.reflect.*;

public class methodAnalysis extends Inspector
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
}
