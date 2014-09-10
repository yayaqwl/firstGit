package strategy;

public class Test {
	public static void main(String[] args) {
//		int[] a = {9, 7, 5,4, 1};
//		float[] a = {3.0f,3.5f,3.2f,1.0f,2.0f};
		Cat[] a = {new Cat(5,5), new Cat(3, 1), new Cat(1, 3)};
		//Dog[] a = {new Dog(5), new Dog(3), new Dog(1)};
		//DataSorter.sort(a);
//		java.util.Arrays.sort(a);
//		DataSorter.p(a);
		java.util.Arrays.sort(a, new CatHeightComparator());
		DataSorter.p(a);
		java.util.Arrays.sort(a, new CatWeightComparator());
		DataSorter.p(a);
		
		
		
	}
}
