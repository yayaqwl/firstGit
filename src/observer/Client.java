package observer;

public class Client {

	public static void main(String[] args) {
		//創建被觀察者
		Subject subject = new ConcreatorSubject();
		//註冊觀察者
		subject.addObserver( new MatherObserverImple());
		subject.addObserver( new FatherObserverImple());
		subject.addObserver( new GrandMatherObserverImple());
		//被觀察者有一些動作
//		subject.cry();
		
		subject.smile();

	}

}
