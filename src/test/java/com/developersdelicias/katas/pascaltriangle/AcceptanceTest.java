package com.developersdelicias.katas.pascaltriangle;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AcceptanceTest {

	private Output output;
	private PascalTriangleFormat format;

	@Before
	public void setUp() {
		output = mock(Console.class);
	}

	@Test
	public void can_print_pascal_triangle_of_level_one_in_console() {
		format = new BranchedPascalTriangleFormat();

		printPascalTriangleOfLevel(1);

		verify(output).print("1");
	}

	@Test
	public void can_print_pascal_triangle_of_level_two_in_console() {
		format = new BranchedPascalTriangleFormat();

		printPascalTriangleOfLevel(2);

		verify(output).print(
				"  1\n" +
						" / \\\n" +
						"1   1"
		);
	}

	@Test
	public void can_print_pascal_triangle_of_level_six_in_console() {
		format = new BranchedPascalTriangleFormat();

		printPascalTriangleOfLevel(6);

		verify(output).print(
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
		format = new BranchedPascalTriangleFormat();

		printPascalTriangleOfLevel(11);

		verify(output).print(
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
		format = new BranchedPascalTriangleFormat();

		printPascalTriangleOfLevel(14);

		verify(output).print(
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
		format = new BranchedPascalTriangleFormat();

		printPascalTriangleOfLevel(17);

		verify(output).print(
				"                                                1\n" +
						"                                              /   \\\n" +
						"                                             1     1\n" +
						"                                           /   \\ /   \\\n" +
						"                                          1     2     1\n" +
						"                                        /   \\ /   \\ /   \\\n" +
						"                                       1     3     3     1\n" +
						"                                     /   \\ /   \\ /   \\ /   \\\n" +
						"                                    1     4     6     4     1\n" +
						"                                  /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"                                 1     5    10    10     5     1\n" +
						"                               /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"                              1     6    15    20    15     6     1\n" +
						"                            /   \\ /   \\ /   \\ /   \\ /   \\ /   \\ /   \\\n" +
						"                           1     7    21    35    35    21     7     1\n" +
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

	@Test
	public void can_print_in_single_format() {
		format = new SinglePascalTriangleFormat();

		printPascalTriangleOfLevel(5);

		verify(output)
				.print("1\n" +
						"1 1\n" +
						"1 2 1\n" +
						"1 3 3 1\n" +
						"1 4 6 4 1"
				);
	}

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();
	@Test
	public void can_be_stored_in_a_file() throws IOException {
		String fileToCreate = "src/test/triangle.text";
		format = new SinglePascalTriangleFormat();
		output = new ToFile(fileToCreate);

		printPascalTriangleOfLevel(5);

		File file = new File(fileToCreate);
		assertTrue(file.exists());
		assertThat(textOf(file), is("1\n" +
				"1 1\n" +
				"1 2 1\n" +
				"1 3 3 1\n" +
				"1 4 6 4 1"));
		assertTrue(file.delete());
	}

	private String textOf(File file) throws IOException {
		return new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset());
	}

	private void printPascalTriangleOfLevel(final int level) {
		new PascalTriangle(level).print(output, format);
	}
}
