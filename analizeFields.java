import java.io.*;
import java.lang.reflect.*;

public class analizeFields extends Inspector
{		
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
