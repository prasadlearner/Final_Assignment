class Sample
{
	public void printEvenNum()
	{
		synchronized(this)
		{
			System.out.println("even numbers between 1 to 10 :: ");
			for(int i=1; i<=10; i++)
			{
				if(i%2 == 0)
				{
					System.out.println(i);
				}
			}
			
			this.notify();
		}
		
	}
	public void printOddNum()
	{
		synchronized(this)
		{
			System.out.println("odd numbers between 1 to 10 :: ");
			for(int i=1; i<=10; i++)
			{
				if(i%2 == 1)
				{
					System.out.println( i);
				}
			}
			this.notify();
		}
		
	}
}
public class Test
{
	public static void main(String[] args) {
		
		Sample d = new Sample();
		
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

