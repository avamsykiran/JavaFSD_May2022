package in.tp.jsedemo.ui;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemoApp4 {

	public static void main(String[] args) {

		//List<String> list = new Vector<String>();
		List<String> list = new ArrayList<String>();
		
		Runnable r1 = () -> {
			for (int i = 1; i <= 10; i++) {
				list.add(Thread.currentThread().getName());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread t1 = new Thread(r1, "T1");
		Thread t2 = new Thread(r1, "T2");

		System.out.println("Please wait while processing the thread....");

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(list + "\t" + list.size());
	}

}
