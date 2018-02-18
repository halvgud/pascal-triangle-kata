package com.developersdelicias.katas.pascaltriangle;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class BranchedPascalTriangleFormatTest {
	public static final PascalTriangleLevel LEVEL_1 = new PascalTriangleLevel(
			asList(new PascalTriangleNode(1))
	);
	public static final PascalTriangleLevel LEVEL_2 = new PascalTriangleLevel(
			asList(
					new PascalTriangleNode(1),
					new PascalTriangleNode(1)
			)
	);
	public static final PascalTriangleLevel LEVEL_3 = new PascalTriangleLevel(
			asList(
					new PascalTriangleNode(1),
					new PascalTriangleNode(2),
					new PascalTriangleNode(1)
			)
	);
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
		triangle = Mockito.spy(new PascalTriangle(3));
		given(triangle.iterator()).willReturn(asList(LEVEL_1, LEVEL_2, LEVEL_3).iterator());

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