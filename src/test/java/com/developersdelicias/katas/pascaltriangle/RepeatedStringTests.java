package com.developersdelicias.katas.pascaltriangle;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class RepeatedStringTests {

	@Test
	public void can_determine_repeated_strings() {
		assertThat(
				new RepeatedString(" ").times(2),
				Is.is("  ")
		);

		assertThat(
				new RepeatedString("a").times(3),
				Is.is("aaa")
		);
	}
}
