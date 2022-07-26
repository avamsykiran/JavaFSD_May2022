package in.tp.cd.ui;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App2 {

	public static void main(String[] args) {
		Runnable task = () -> {
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
		
		//ExecutorService exeServ = Executors.newSingleThreadExecutor();
		
		ExecutorService exeServ = Executors.newFixedThreadPool(3);
		
		Future future1 = exeServ.submit(task);
		Future future2 = exeServ.submit(task);
		Future future3 = exeServ.submit(task);
		Future future4 = exeServ.submit(task);
		
		while(!future1.isDone() || !future2.isDone() || !future3.isDone() || !future4.isDone()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Bye Bye");
		
		exeServ.shutdown();
	}

}
