import java.io.*;
import java.lang.reflect.*;

public class constructorAnalysis extends Inspector
{		
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
				String constructorName = a[i].toString();
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
	public Class[] getTheParameters(Method a)
	{
		Class [] result = a.getParameterTypes();
		return result;
	}
}
