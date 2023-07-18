class Demo
{
	public void printEvenNum()
	{
		for(int i=1; i<=10; i++)
		{
			if(i%2 == 0)
			{
				System.out.println(i);
			}
		}
	}
	public void printOddNum()
	{
		for(int i=1; i<=10; i++)
		{
			if(i%2 == 1)
			{
				System.out.println(i);
			}
		}
	}
}
public class Main
{
	public static void main(String[] args) {
		
		Demo d = new Demo();
		
		Thread t1 = new Thread(new Runnable()
				{

					@Override
					public void run() {
					
						d.printEvenNum();
						
					}
			
				});
		
		Thread t2 = new Thread(new Runnable()
		{

			@Override
			public void run() {
			
				d.printOddNum();
				
			}
	
		});
		
		t1.start();
		t2.start();
	}
}