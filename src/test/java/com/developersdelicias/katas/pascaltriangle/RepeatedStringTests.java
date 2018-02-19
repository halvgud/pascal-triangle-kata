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
		assertThat(
				new RepeatedString("a").times(1),
				Is.is("a")
		);
	}

	@Test
	public void can_determine_repeated_strings_for_zero_times() {
		assertThat(
				new RepeatedString("a").times(0),
				Is.is("")
		);
	}

	@Test
	public void can_determine_repeated_strings_for_negative_times() {
		assertThat(
				new RepeatedString("a").times(-1),
				Is.is("")
		);
	}
}
