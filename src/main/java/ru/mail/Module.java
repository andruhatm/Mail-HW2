package ru.mail;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.jetbrains.annotations.NotNull;
import ru.mail.entities.Counter;
import ru.mail.entities.Params;

public class Module extends AbstractModule {

	@Override
	protected void configure() {
		bind(Input.class).toProvider(InputProvider.class);
		bind(Counter.class).toInstance(new Counter());

	}

	@Provides
	public @NotNull Params provideParams(){
		return new Params(Main.getArgsInfo(0),Main.getArgsInfo(1));
	}
}
