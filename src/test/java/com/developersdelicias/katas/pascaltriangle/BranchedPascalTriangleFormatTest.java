package com.developersdelicias.katas.pascaltriangle;

import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class BranchedPascalTriangleFormatTest {

	@Test
	public void can_format_triangles_of_level_one() {
		BranchedPascalTriangleFormat format = new BranchedPascalTriangleFormat();
		PascalTriangle triangle = Mockito.mock(PascalTriangle.class);
		given(triangle.level()).willReturn(1);

		assertThat(
				"Cannot format triangles of level one",
				format.format(triangle),
				is("1")
		);
	}

	@Test
	public void can_format_triangles_of_level_two() {
		BranchedPascalTriangleFormat format = new BranchedPascalTriangleFormat();
		PascalTriangle triangle = Mockito.mock(PascalTriangle.class);
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
}