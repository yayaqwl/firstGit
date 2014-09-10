package observer;

public class FatherObserverImple implements IObserver {

	
	@Override
	public void cryExecute() {
		System.out.println("爸爸聽到孩子哭：趕緊給孩子拿來玩具");

	}

	@Override
	public void smileExecute() {
		System.out.println("爸爸看到孩子笑了：爸爸笑了");
		
	}
}
