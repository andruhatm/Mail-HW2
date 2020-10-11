package ru.mail.entities;

import com.google.inject.Singleton;

@Singleton
public class Counter {
	private int counter = 1;

	public Counter() {
	}

	public int getCounter() {
		return counter;
	}

	public void add() {
		counter++;
	}
}
