public class Driver
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
			Inspector ins= new Inspector();
			ins.inspect(object, true); //Laura
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
}