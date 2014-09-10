package listenerModule.simpleListener;
/**
 * 事件源
 */

public class DownLoadTask  {
	
	ITaskListener listener = null;
	

	
	public ITaskListener getListener() {
		return listener;
	}



	public void setListener(ITaskListener listener) {
		this.listener = listener;
	}


	public void run(){
		System.out.println("開始下载数据");
		System.out.println("数据下载完之后主动调用监听器的处理");
		getListener().onTaskFinish();
		
	}
	

}
