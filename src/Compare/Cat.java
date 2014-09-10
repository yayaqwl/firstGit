package compare;

public class Cat implements Comparable<Cat> {
	
	private int height;
	
	
	Cat(int height){
		this.height = height;
	}
	

	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	@Override
	public int compareTo(Cat o) {
		if(this.getHeight() > o.getHeight()){
			return 1;
		}else if(this.getHeight() < o.getHeight()){
			return -1;
		}else{
			return 0;
		}
		
	}


	@Override
	public String toString() {
		return "Cat [height=" + height + "]";
	}
	
	
	

}
