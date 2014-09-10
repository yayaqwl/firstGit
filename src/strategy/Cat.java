package strategy;

public class Cat implements java.lang.Comparable<Cat> {
	private int height;
	//private Comparator comparator = new CatHeightComparator();
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	
	public Cat(int height, int weight) {
		super();
		this.height = height;
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	private int weight;
	
	@Override
	public String toString() {
		return height + "|" + weight;
	}
	@Override
	public int compareTo(Cat o) {
		if(this.getHeight() > o.getHeight()) {
			return 1;
		}
		else if(this.getHeight() < o.getHeight()){
			 return -1;
		} 
		else{
			return 0;
		}
	}
}
