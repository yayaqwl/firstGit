package Thread.ThreadPoolExecutor;

import java.io.Serializable;

public class ThreadPoolTask implements Runnable, Serializable {

	private Object attachData;  
	  
    ThreadPoolTask(Object tasks) {  
        this.attachData = tasks;  
    }  
  
    public void run() {  
    	 System.out.println("开始执行任务：" + attachData);  
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("执行任务完成：" + attachData);  
          
        attachData = null;  
    }  
  
    public Object getTask() {  
        return this.attachData;  
    }  

}
