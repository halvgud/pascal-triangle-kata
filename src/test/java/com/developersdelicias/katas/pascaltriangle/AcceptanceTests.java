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
						"1   5  10  10   5   1");
	}

	@Test
	public void triangle_of_11() {
		printPascalTriangleOfLevel(11);
		verify(console).print(
				"                    1\n" +
						"                   / \\\n" +
						"                  1   1\n" +
						"                 / \\ / \\\n" +
						"                1   2   1\n" +
						"               / \\ / \\ / \\\n" +
						"              1   3   3   1\n" +
						"             / \\ / \\ / \\ / \\\n" +
						"            1   4   6   4   1\n" +
						"           / \\ / \\ / \\ / \\ / \\\n" +
						"          1   5  10  10   5   1\n" +
						"         / \\ / \\ / \\ / \\ / \\ / \\\n" +
						"        1   6  15  20  15   6   1\n" +
						"       / \\ / \\ / \\ / \\ / \\ / \\ / \\\n" +
						"      1   7  21  35  35  21   7   1\n" +
						"     / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\\n" +
						"    1   8  28  56  70  56  28   8   1\n" +
						"   / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\\n" +
						"  1   9  36  84  126 126 84  36   9   1\n" +
						" / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\\n" +
						"1  10  45  120 210 252 210 120 45  10   1"
		);
	}

	@Test
	public void triangle_of_14() {
		printPascalTriangleOfLevel(14);
		verify(console).print(
				"                                       1\n" +
						"                                     /   \\\n" +
						"                                    1     1\n" +
						"                                  /   \\ /   \\\n" +
						"                                 1     2     1\n" +
						"                               /   \\ /   \\ /   \\\n" +
						"                              1     3     3     1\n" +
						"                            /   \\ /   \\ /   \\ /   \\\n" +
						"                           1     4     6     4     1\n" +
						"                         /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"                        1     5    10    10     5     1\n" +
						"                      /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"                     1     6    15    20    15     6     1\n" +
						"                   /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"                  1     7    21    35    35    21     7     1\n" +
						"                /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"               1     8    28    56    70    56    28     8     1\n" +
						"             /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"            1     9    36    84   126   126    84    36     9     1\n" +
						"          /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"         1    10    45   120   210   252   210   120    45    10     1\n" +
						"       /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"      1    11    55   165   330   462   462   330   165    55    11     1\n" +
						"    /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"   1    12    66   220   495   792   924   792   495   220    66    12     1\n" +
						" /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"1    13    78   286   715  1287  1716  1716  1287   715   286    78    13     1"
		);
	}

	@Test
	public void triangle_of_17() {
		printPascalTriangleOfLevel(17);
		verify(console).print(
				"                                                1                                          \n" +
						"                                              /   \\\n" +
						"                                             1     1\n" +
						"                                           /   \\ /   \\\n" +
						"                                          1     2     1\n" +
						"                                        /   \\ /   \\ /   \\\n" +
						"                                       1     3     3     1 \n" +
						"                                     /   \\ /   \\ /   \\ /   \\\n" +
						"                                    1     4     6     4     1 \n" +
						"                                  /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"                                 1     5    10    10     5     1 \n" +
						"                               /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"                              1     6    15    20    15     6     1 \n" +
						"                            /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"                           1     7    21    35    35    21     7     1 \n" +
						"                         /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"                        1     8    28    56    70    56    28     8     1\n" +
						"                      /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"                     1     9    36    84   126   126    84    36     9     1\n" +
						"                   /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"                  1    10    45   120   210   252   210   120    45    10     1\n" +
						"                /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"               1    11    55   165   330   462   462   330   165    55    11     1\n" +
						"             /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"            1    12    66   220   495   792   924   792   495   220    66    12     1\n" +
						"          /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"         1    13    78   286   715  1287  1716  1716  1287   715   286    78    13     1\n" +
						"       /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"      1    14    91   364  1001  2002  3003  3432  3003  2002  1001   364    91    14     1\n" +
						"    /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"   1    15   105   455  1365  3003  5005  6435  6435  5005  3003  1365   455   105    15     1\n" +
						" /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"1    16   120   560  1820  4368  8008 11440 12870 11440  8008  4368  1820   560   120    16     1"
		);
	}

	private void printPascalTriangleOfLevel(final int level) {
		new PascalTriangle(level).print(console, format);
	}
}
