package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者抽象类
 * @author junezh
 *
 */
public abstract class Subject {
	
	private List<IObserver> observerList  = new ArrayList<IObserver>();
	
	public void addObserver(IObserver iObserver){
		if(!observerList.contains(iObserver)){
			observerList.add(iObserver);
		}
	}
	
	public void deleteObserver(IObserver iObserver){
		if(observerList.contains(iObserver)){
			observerList.remove(iObserver);
		}
	}

	public List<IObserver> getObserverList() {
		return observerList;
	}
	
	public abstract void cry();
	
	public abstract void smile();
	
}