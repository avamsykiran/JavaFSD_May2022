package in.tp.cd.ui;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class App1 {

	public static void main(String[] args) {
		Runnable task1 = () -> {
			Thread t = Thread.currentThread();
			Random r = new Random();
			for(int i=1;i<=5;i++) {				
				System.out.println(t.getName() + ">> "+r.nextInt(100));
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread t1 = new Thread(task1,"t1");
		Thread t2 = new Thread(task1,"t2");
		Thread t3 = new Thread(task1,"t3");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Bye bye");
	}

}
