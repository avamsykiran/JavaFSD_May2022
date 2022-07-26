package in.tp.cd.ui;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App3 {

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
		
		ExecutorService exeServ = Executors.newFixedThreadPool(3);
		
		//exeServ.execute(runnable);
		
		Future future1 = exeServ.submit(task);
		Future future2 = exeServ.submit(task);
		Future future3 = exeServ.submit(task);
		Future future4 = exeServ.submit(task);
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
			System.out.println(future3.get());
			System.out.println(future4.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
