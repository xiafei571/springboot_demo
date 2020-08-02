package com.edu.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {

	private String name;

	private Chopstick left;

	private Chopstick right;

	public Philosopher(String name, Chopstick left, Chopstick right) {
		super();
		this.name = name;
		this.left = left;
		this.right = right;
	}

	private void think() throws InterruptedException {
		// TimeUnit.MILLISECONDS.sleep(1500);
		TimeUnit.MILLISECONDS.sleep(new Random(5).nextInt(10));
	}

	@Override
	public void run() {
		try {
			// Tests whether the current thread has been interrupted.
			while (!Thread.interrupted()) {
				System.out.println(this.name + " feels hungry");
				right.take();
				System.out.println(this.name + " picks up " + right);
				left.take();
				System.out.println(this.name + " picks up " + left);
				System.out.println(this.name + " is eating");
				think();
				System.out.println(this.name + " is thinking");
				right.drop();
				left.drop();
			}
		} catch (InterruptedException e) {
			System.out.println(this.name + " exiting via interrupt");
		}

	}
}
