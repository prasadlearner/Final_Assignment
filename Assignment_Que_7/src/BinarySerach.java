import java.util.Arrays;
import java.util.Scanner;

public class BinarySerach {
	
public static void main(String[] args) {
	
	int[] arr = {9,32,6,2,45,8,11,5};
	
	Arrays.sort(arr);
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter number for Search :: ");
	
	int input = scan.nextInt();
	
	int low = 0; int high = arr.length-1;
	
	while(low <= high)
	{
		int mid = (low+high)/2;
		
	 if(input == arr[mid])
	 {
		 System.out.println("Key is fount at index " + mid);
		 break;
		 
	 }
	 else if(input > arr[mid])
	 {
		 low = mid+1;
	 }
	 else
	 {
		 high = mid-1;
	 }
	}
	
	if(low > high)
	{
		System.out.println("key not found ");
	}	
	
}

}
