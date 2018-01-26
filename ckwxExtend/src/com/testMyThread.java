package com;

public class testMyThread {
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo3 th1, th2, th3;
		th1 = new ThreadDemo3("线程1", (int) (Math.random() * 900));
		th2 = new ThreadDemo3("线程2", (int) (Math.random() * 900));
		th3 = new ThreadDemo3("线程3", (int) (Math.random() * 900));
		th1.start();
		System.out.println(th1.getState());
		th1.run();
		System.out.println(th1.getState());
		th1.sleep(4000);
		System.out.println(th1.getState());
		synchronized("2"){
			
		}
		
		th2.start();
		th3.start();
	}
}