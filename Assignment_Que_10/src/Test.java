import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("enter no of elements you want :: ");
		int n = scan.nextInt();
		List<Integer> list = new ArrayList();
		
		for(int i=0; i<n; i++)
		{
			list.add(i, scan.nextInt());
		}
		
		Collections.sort(list);
		System.out.println("second largest element in list is :: " + list.get(list.size()-2));
		System.out.println("second smallest element in list is :: " + list.get(1));
	}
}
