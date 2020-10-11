package ru.mail.service;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.jetbrains.annotations.NotNull;
import ru.mail.entities.Counter;
import ru.mail.Input;

import java.util.logging.Logger;

public class InputLogger {

	private final @NotNull
	Provider<Input> input;

	private @NotNull
	Counter counter;

	private @NotNull
	Logger logger;

	@Inject
	public InputLogger(@NotNull Provider<Input> input, @NotNull Counter counter,@NotNull Logger logger) {
		this.input = input;
		this.counter = counter;
		this.logger = logger;
	}

	public void waitForInput(String[] args) {
		input.get().waitForInput(counter,logger);
	}

}
