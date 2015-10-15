import java.io.*;
import java.lang.reflect.*;

public class methodAnalysis extends Inspector
{		
	public void analizeMethods(Method[] a)
	{	
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
}
