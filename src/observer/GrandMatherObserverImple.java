package observer;

public class GrandMatherObserverImple implements IObserver {

	@Override
	public void cryExecute() {
		System.out.println("奶奶聽到孩子哭：趕緊過來哄");
	}

	@Override
	public void smileExecute() {
		System.out.println("奶奶看到孩子笑了：奶奶笑了");
		
	}

}
