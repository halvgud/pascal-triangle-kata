package com.developersdelicias.katas.pascaltriangle;

import java.util.Collections;

public class RepeatedString {
	private final String baseString;

	RepeatedString(String str) {
		this.baseString = str;
	}

	public String times(int times) {
		return String.join("", Collections.nCopies(times > 0 ? times : 0, baseString));
	}
}
