
public class MotorVehicle implements Vehicle {

	int fuel ;
	@Override
	public void run() {
	System.out.println("vehicle is moving");

	}

	@Override
	public int getFuel() {
		
		return 0;
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
 
 
 // interface (also called SRS)
 
 /* java supports multiple inheritance through interfaces.(one class can implements multiple interfaces)
  * 
  * interface doesn't have constructor
  * 
  * java 8 onwards interfaces can have Default and static methods.
  * 
  */
  