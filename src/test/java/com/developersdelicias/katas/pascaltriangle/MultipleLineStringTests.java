package com.developersdelicias.katas.pascaltriangle;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MultipleLineStringTests {

	@Test
	public void can_append_new_lines_to_string() {
		MultipleLineString string = new MultipleLineString("Line 1")
				.appendLine("Line 2")
				.appendLine("Line 3")
				.appendLine("Line 4");

		assertThat(
				string.toString(), is(
						"Line 1\n" +
								"Line 2\n" +
								"Line 3\n" +
								"Line 4"
				));
	}

	@Test
	public void first_line_added_do_not_generate_new_line_at_beginning() {
		MultipleLineString string = new MultipleLineString();

		string.appendLine("First Line");
		string.appendLine("Second Line");

		assertThat(
				string.toString(),
				is("First Line\n" +
						"Second Line"
				)
		);
	}
}
