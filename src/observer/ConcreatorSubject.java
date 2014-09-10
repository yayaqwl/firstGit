package observer;
/**
 * 實際的被觀察者
 * @author junezh
 *
 */
public class ConcreatorSubject extends Subject {

	@Override
	public void cry() {
		System.out.println("孩子哭了");
		for(IObserver observer: getObserverList()){
			observer.cryExecute();
		}
	}
	
	
	@Override
	public void smile() {
		System.out.println("孩子笑了");
		for(IObserver observer: getObserverList()){
			observer.smileExecute();
		}
	}
	
	

}
