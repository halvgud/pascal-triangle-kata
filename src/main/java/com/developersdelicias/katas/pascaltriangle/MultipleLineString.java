package com.developersdelicias.katas.pascaltriangle;

public class MultipleLineString {

	private final StringBuilder sb;

	MultipleLineString(String string) {
		this.sb = new StringBuilder(string);
	}

	MultipleLineString() {
		this("");
	}

	public MultipleLineString appendLine(String newLine) {
		sb.append(newLineCharIfRequired())
				.append(newLine);
		return this;
	}

	private String newLineCharIfRequired() {
		return sb.toString().isEmpty() ? "" : "\n";
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}