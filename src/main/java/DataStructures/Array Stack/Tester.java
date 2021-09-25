/**
* @author giuliano ranauro
* Date: 25/09/2021
* Ide: CodeRunner 4 - MacOS
* JDK: 1.8
* @version 1.0
*/

public class Tester {
	public static void main(String[] args) throws Exception{
		Stack stack = new Stack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println("Reading array: \n");
		Integer[] arr = stack.getArray();
		for (Integer numb : arr) {
			if (numb != null) {
				System.out.println(numb);
			}
		}
		
		System.out.print("Testing pop:\n");
		System.out.println(stack.pop());
		
		
		System.out.println("Remaining elements");
		arr = stack.getArray();
		for (Integer numb : arr) {
			if (numb != null) {
				System.out.println(numb);
			}
		}
	}
}