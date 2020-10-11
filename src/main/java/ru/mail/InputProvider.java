package ru.mail;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.jetbrains.annotations.NotNull;
import ru.mail.entities.Params;
import ru.mail.logImpls.CompositeInputImpl;
import ru.mail.logImpls.ConsoleInputImpl;
import ru.mail.logImpls.FileInputImpl;

public class InputProvider implements Provider<Input> {

	@Inject
	private final @NotNull
	Params params;

	@Inject
	public InputProvider(@NotNull Params params) {
		this.params = params;
	}

	//choosing implementation
	@Override
	public Input get() {

		System.out.println(params.toString());

		if(params.getType().equals("console")){
			return new ConsoleInputImpl();
		}
		else if(params.getType().equals("file")){
			return new FileInputImpl(params.getTag());
		}
		else {
			return new CompositeInputImpl(params.getTag());
		}

	}
}
