package listenerModule.complicatedListener;
/**
 * 响应事件的監聽器PageLoadActivityListener(Android頁面類)
 * @author junezh
 *
 */
public class PageLoadActivityListener implements ITaskListener {

	
	public static void main(String[] args){
		DownLoadTask task = new DownLoadTask(); //事件源
		//事件源註冊監聽器
		task.addListener( new PageLoadActivityListener());
		//發起下載事件
		task.run();
		
		
	}

	@Override
	public void onTaskFinish() {
		System.out.println("數據庫下載完以後將數據顯示在頁面上");
		
	}

}
