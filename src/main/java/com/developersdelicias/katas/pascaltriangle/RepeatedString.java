package com.developersdelicias.katas.pascaltriangle;

import java.util.Collections;

public class RepeatedString {
	private final String baseString;

	RepeatedString(String str) {
		this.baseString = str;
	}

	public String times(int times) {
		if (times <= 0)
			return "";
		return String.join("", Collections.nCopies(times, baseString));
	}
}
