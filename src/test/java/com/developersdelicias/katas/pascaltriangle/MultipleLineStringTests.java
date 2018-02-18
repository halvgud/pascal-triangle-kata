package com.developersdelicias.katas.pascaltriangle;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class MultipleLineStringTests {

	@Test
	public void can_append_new_lines_to_string() {
		MultipleLineString string = new MultipleLineString("Line 1")
				.appendLine("Line 2")
				.appendLine("Line 3")
				.appendLine("Line 4");

		assertThat(
				string.toString(), Is.is(
						"Line 1\n" +
								"Line 2\n" +
								"Line 3\n" +
								"Line 4"
				));
	}
}
