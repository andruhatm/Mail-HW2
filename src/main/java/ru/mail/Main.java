package ru.mail;

import com.google.inject.Guice;
import com.google.inject.Injector;
import ru.mail.service.InputLogger;

public class Main {

	private static String[] argsInfo;

	public static void main(String[] args) {

		argsInfo=args;

//		Logging: {
//				"console",
//				"file",
//				"composite"
//		}

		final Injector injector = Guice.createInjector(new Module());
		injector.getInstance(InputLogger.class).waitForInput(args);

	}

	public static String getArgsInfo(int i) {
		return argsInfo[i];
	}
}
