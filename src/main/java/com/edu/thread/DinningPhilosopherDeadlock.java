package com.edu.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DinningPhilosopherDeadlock {

	public static void main(String[] args) {
		try {
			int size = 4;

			Chopstick[] sticks = new Chopstick[size];
			String[] philosopher = { "A", "B", "C", "D" };
			// 线程池
			ExecutorService exec = Executors.newCachedThreadPool();

			for (int i = 0; i < size; i++)
				sticks[i] = new Chopstick(i + 1);

			for (int j = 0; j < size; j++) { // 1,2 2,3 3,4 4,1
				if (j == size - 1) {
					exec.execute(new Philosopher(philosopher[j], sticks[0], sticks[j]));
				} else {
					exec.execute(new Philosopher(philosopher[j], sticks[j], sticks[(j + 1) % size]));
				}
			}
			TimeUnit.SECONDS.sleep(5);
			// Attempts to stop all actively executing tasks, halts theprocessing of waiting
			// tasks, and returns a list of the tasksthat were awaiting execution.
			exec.shutdownNow();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
