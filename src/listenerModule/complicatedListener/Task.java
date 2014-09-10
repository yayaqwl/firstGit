package listenerModule.complicatedListener;

import java.util.ArrayList;
import java.util.List;

abstract class Task {
	
	
	List<ITaskListener> listeners = new ArrayList<ITaskListener>();
	
	public void addListener(ITaskListener iTaskListener){
		if(!listeners.contains(iTaskListener)){
			listeners.add(iTaskListener);
		}
	}
	
	public void deleteListener(ITaskListener iTaskListener){
		if(listeners.contains(iTaskListener)){
			listeners.remove(iTaskListener);
		}
	}
	
	public abstract void run();

}
