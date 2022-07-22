package in.tp.jsedemo.ui;

import java.util.function.Consumer;

public class ThreadDemoApp2 {

	public static void main(String[] args) {
		
		Runnable r1 = () -> {
			for(int i=1;i<=10;i++) {
				Thread t = Thread.currentThread();
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(t.getName() + "\t" + i);
			}
		};
		
		Thread t1 = new Thread(r1, "Thread1");
		Thread t2 = new Thread(r1, "Thread2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("OH! all jobs done!");
	}

}
