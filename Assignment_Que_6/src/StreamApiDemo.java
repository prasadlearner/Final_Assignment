import java.util.Arrays;
import java.util.List;

public class StreamApiDemo {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(-52,-9,-3,0,35,2,96,5,99);
		
		list.stream().sorted().forEach(System.out::println);

	}

}
