package observer;

public class MatherObserverImple implements IObserver {

	@Override
	public void cryExecute() {
		System.out.println("媽媽聽到孩子哭：趕緊給孩子喂奶");

	}

	@Override
	public void smileExecute() {
		System.out.println("媽媽看到孩子笑了：媽媽笑了");
		
	}

}
