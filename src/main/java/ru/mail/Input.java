package ru.mail;

import ru.mail.entities.Counter;

import java.util.logging.Logger;

public interface Input {

	public void waitForInput(Counter counter, Logger logger);

}
