import java.util.Scanner;


class NegitiveNumberException extends Exception
{
	public NegitiveNumberException(String msg) {
		
		super(msg);
	}
}

class Demo {

	public void verify() throws NegitiveNumberException {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		
		if(i < 0)
		{
		NegitiveNumberException e = new NegitiveNumberException(i + " is negitive number");
		System.out.println(e);
		throw e;
		}
		else 
		{
			System.out.println(i + " is positive number");
		}
		}
		
}

class ExceptionHandlingDemo{
	public static void main(String[] args) {
		Demo demo = new Demo();
		try {
			
			demo.verify();
		}
		catch(NegitiveNumberException e)
		{
			System.out.println("Enter any positive number ");
		}
	}
}
