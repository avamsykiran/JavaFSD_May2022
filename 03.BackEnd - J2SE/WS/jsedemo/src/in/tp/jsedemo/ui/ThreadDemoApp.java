package in.tp.jsedemo.ui;

public class ThreadDemoApp {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName());
		
		System.out.println("I am going to sleep...");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("I jsut worke up");
	}

}
