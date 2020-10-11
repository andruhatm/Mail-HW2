package ru.mail.logImpls;

import org.jetbrains.annotations.NotNull;
import ru.mail.entities.Counter;
import ru.mail.Input;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileInputImpl implements Input {

	private final @NotNull
	String tag;

	public FileInputImpl(@NotNull String tag) {
		this.tag = tag;
	}

	@Override
	public void waitForInput(Counter counter, Logger logger) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");

			//logging to file
			while (true) {
				FileOutputStream stream = new FileOutputStream("consoleLog.txt", true);
				String log = "<" + tag + ">" + scanner.nextLine() +
									"<" + tag + ">" + " " + counter.getCounter() +"\n";
				counter.add();
				byte[] buf = log.getBytes();
				stream.write(buf);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
