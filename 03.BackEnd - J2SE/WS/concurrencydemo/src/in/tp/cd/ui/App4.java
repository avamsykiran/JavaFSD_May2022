package in.tp.cd.ui;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App4 {

	public static void main(String[] args) {
		
		Callable<Integer> task = () -> {
			Thread t = Thread.currentThread();
			int sum =0;
			Random r = new Random();
			for(int i=1;i<=5;i++) {				
				int val = r.nextInt(100);
				sum +=val;
				System.out.println(t.getName() + ">> "+val);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return sum;
		};
		
		//ExecutorService exeServ = Executors.newSingleThreadExecutor();
		
		//ExecutorService exeServ = Executors.newFixedThreadPool(3);
		
		ScheduledExecutorService exeServ = Executors.newScheduledThreadPool(2);
		
		//exeServ.execute(runnable);
		
		Future future1 = exeServ.schedule(task, 5, TimeUnit.SECONDS);
		Future future2 = exeServ.schedule(task, 10, TimeUnit.SECONDS);
		exeServ.shutdown();
		
		try {
			exeServ.awaitTermination(10L, TimeUnit.HOURS);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Bye Bye");
		try {
			System.out.println(future1.get());
			System.out.println(future2.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
