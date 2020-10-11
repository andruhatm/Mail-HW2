package ru.mail.logImpls;

import ru.mail.entities.Counter;
import ru.mail.Input;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;

public class ConsoleInputImpl implements Input {

	@Override
	public void waitForInput(Counter counter, Logger logger) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");

			//logging to console
			while (true) {
				logger.info(scanner.nextLine()+" "+counter.getCounter());
				counter.add();
			}
		} catch (IllegalStateException | NoSuchElementException e) {
		}

	}

}
