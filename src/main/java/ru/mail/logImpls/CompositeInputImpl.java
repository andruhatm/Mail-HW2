package ru.mail.logImpls;

import org.jetbrains.annotations.NotNull;
import ru.mail.entities.Counter;
import ru.mail.Input;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class CompositeInputImpl implements Input {

	private @NotNull
	String tag;

	public CompositeInputImpl(@NotNull String tag) {
		this.tag = tag;
	}

	@Override
	public void waitForInput(Counter counter, Logger logger) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");

			while (true) {

				String line = scanner.nextLine();

				//logging to console
				logger.info(line+" "+counter.getCounter());
				counter.add();

				//logging to file
				FileOutputStream stream = new FileOutputStream("consoleLogComposite.txt", true);
				String log = "<" + tag + ">" + line +
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
