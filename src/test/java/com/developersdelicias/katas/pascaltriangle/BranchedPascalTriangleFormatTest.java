package com.developersdelicias.katas.pascaltriangle;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class BranchedPascalTriangleFormatTest {
	private BranchedPascalTriangleFormat format;
	private PascalTriangle triangle;

	@Before
	public void setUp() {
		format = new BranchedPascalTriangleFormat();
		triangle = Mockito.mock(PascalTriangle.class);
	}

	@Test
	public void can_format_triangles_of_level_one() {
		given(triangle.level()).willReturn(1);

		assertThat(
				"Cannot format triangles of level one",
				format.format(triangle),
				is("1")
		);
	}

	@Test
	public void can_format_triangles_of_level_two() {
		given(triangle.level()).willReturn(2);

		assertThat(
				"Cannot format triangles of level two",
				format.format(triangle),
				is("  1\n" +
						" / \\\n" +
						"1   1"
				)
		);
	}

	@Test
	public void can_format_triangles_of_level_three() {
		given(triangle.level()).willReturn(3);

		assertThat(
				"Cannot format triangles of level three",
				format.format(triangle),
				is("    1\n" +
						"   / \\\n" +
						"  1   1\n" +
						" / \\ / \\\n" +
						"1   2   1"
				)
		);
	}
}