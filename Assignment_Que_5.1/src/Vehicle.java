
public abstract class Vehicle {
	 int fuel = 5;
	
	public abstract void run();
	
	public int getFuel()
	{
		return fuel;
	}
	
	
}
class MotorVehicle extends Vehicle
{
	
	@Override 
	public void run()
	{
		System.out.println("vehicle is moving...");
	}
}

class Main
{
	 public static void main(String[] args) {
		 MotorVehicle MotorVehicle = new MotorVehicle();
		 System.out.println(MotorVehicle.getFuel());
		 MotorVehicle.run();
		 
	}
}

 
  // In java abstraction is achieved through abstract classes and interfaces


  // Abstract class (incomplete class)

/*
 * An abstract class can extends one class only.
 * 
 * we can't create object of abstract class.
 * 
 * abstract class have abstract methods(abstract methods are methods those can only be declared cant't defines) and we can also crate concrete methods.
 * 
 * in abstract class we can't use abstract keyword for variables.
 * 
 * abstract class have constructor.
 * 
 * in abstract class constructor can't be abstract because by default super() is in first statement in constructor body.
 * 
 */
  
 
 