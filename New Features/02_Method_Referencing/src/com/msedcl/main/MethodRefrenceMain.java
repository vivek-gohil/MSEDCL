package com.msedcl.main;

public class MethodRefrenceMain {
	public static void main(String[] args) {

		// printMessage();

// Create thread and start thread 
//		Thread myThread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				printMessage();
//			}
//		});

		// Thread myThread = new Thread(() -> printMessage());
		Thread myThread = new Thread(MethodRefrenceMain::printMessage); // same as () -> printMessage()

		myThread.start();
	}

	public static void printMessage() {
		System.out.println("Hello From printMessage");
	}
}
