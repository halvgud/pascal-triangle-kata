package com.developersdelicias.katas.pascaltriangle;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class AcceptanceTests {

	private Console console = Mockito.mock(Console.class);
	private PascalTriangleFormat format = new BranchedPascalTriangleFormat();

	@Test
	public void can_print_pascal_triangle_of_level_one_in_console() {
		printPascalTriangleOfLevel(1);

		verify(console).print("1");
	}

	@Test
	public void can_print_pascal_triangle_of_level_two_in_console() {
		printPascalTriangleOfLevel(2);

		verify(console).print(
						"  1\n" +
						" / \\\n" +
						"1   1"
		);
	}

	@Test
	public void can_print_pascal_triangle_of_level_six_in_console() {
		printPascalTriangleOfLevel(6);

		verify(console).print(
						"          1\n" +
						"         / \\\n" +
						"        1   1\n" +
						"       / \\ / \\\n" +
						"      1   2   1\n" +
						"     / \\ / \\ / \\\n" +
						"    1   3   3   1\n" +
						"   / \\ / \\ / \\ / \\\n" +
						"  1   4   6   4   1\n" +
						" / \\ / \\ / \\ / \\ / \\\n" +
						"1   5  10  10   5   1"
		);
	}

	private void printPascalTriangleOfLevel(final int level) {
		new PascalTriangle(level).print(console, format);
	}
}
