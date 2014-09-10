package listenerModule.complicatedListener;
/**
 * 事件源
 */
import java.util.ArrayList;
import java.util.List;

public class DownLoadTask extends Task {
	
	
	@Override
	public void run(){
		System.out.println("開始下载数据");
		System.out.println("数据下载完之后主动调用监听器的处理");
		for(ITaskListener listener: listeners){
			listener.onTaskFinish();
		}
		
	}
	

}
