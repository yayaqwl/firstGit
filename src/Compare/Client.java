package compare;

import java.util.Arrays;
import java.util.Collections;

public class Client {
	
	public static void main(String[] args){
		Cat[] a = { new Cat(3), new Cat(1), new Cat(2)};
//		Arrays.sort(a);
		Collections.sort(Arrays.asList(a));
		p(a);
	}
	
	public static void p(Object[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}


}
