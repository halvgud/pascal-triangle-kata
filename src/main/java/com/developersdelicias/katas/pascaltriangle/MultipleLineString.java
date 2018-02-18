package com.developersdelicias.katas.pascaltriangle;

public class MultipleLineString {

	private final StringBuilder sb;

	MultipleLineString(String string) {
		this.sb = new StringBuilder(string);
	}

	public MultipleLineString appendLine(String newLine) {
		sb.append("\n").append(newLine);
		return this;
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}