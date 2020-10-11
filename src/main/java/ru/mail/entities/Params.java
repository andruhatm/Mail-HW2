package ru.mail.entities;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class Params {

	private @NotNull
	String type;

	private @NotNull
	String tag;

	@Inject
	public Params(@NotNull String type, @NotNull String tag) {
		this.type = type;
		this.tag = tag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Params{" +
						"type='" + type + '\'' +
						", tag='" + tag + '\'' +
						'}';
	}
}
