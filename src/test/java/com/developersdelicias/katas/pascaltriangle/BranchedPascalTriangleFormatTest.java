package com.developersdelicias.katas.pascaltriangle;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class BranchedPascalTriangleFormatTest {
	private static final PascalTriangleLevel LEVEL_1 = new PascalTriangleLevel(
			Collections.singletonList(new PascalTriangleNode(1))
	);
	private static final PascalTriangleLevel LEVEL_2 = new PascalTriangleLevel(
			asList(
					new PascalTriangleNode(1),
					new PascalTriangleNode(1)
			)
	);
	private static final PascalTriangleLevel LEVEL_3 = new PascalTriangleLevel(
			asList(
					new PascalTriangleNode(1),
					new PascalTriangleNode(2),
					new PascalTriangleNode(1)
			)
	);

	private static final PascalTriangleLevel LEVEL_4 = new PascalTriangleLevel(
			asList(
					new PascalTriangleNode(1),
					new PascalTriangleNode(3),
					new PascalTriangleNode(3),
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
		configureIteratorWithLevels(LEVEL_1);

		assertThat(
				"Cannot format triangles of level one",
				format.format(triangle),
				is("1")
		);
	}

	@Test
	public void can_format_triangles_of_level_two() {
		configureIteratorWithLevels(LEVEL_1, LEVEL_2);

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
		configureIteratorWithLevels(LEVEL_1, LEVEL_2, LEVEL_3);

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

	@Test
	public void can_format_triangles_of_level_four() {
		configureIteratorWithLevels(LEVEL_1, LEVEL_2, LEVEL_3, LEVEL_4);

		assertThat(
				"Cannot format triangles of level four",
				format.format(triangle),
				is("      1\n" +
						"     / \\\n" +
						"    1   1\n" +
						"   / \\ / \\\n" +
						"  1   2   1\n" +
						" / \\ / \\ / \\\n" +
						"1   3   3   1"
				)
		);
	}

	@Test
	public void can_format_triangles_with_two_digits() {
		configureIteratorWithLevels(
				new PascalTriangleLevel(
						Collections.singletonList(new PascalTriangleNode(5))
				),
				new PascalTriangleLevel(
						asList(
								new PascalTriangleNode(5),
								new PascalTriangleNode(5)
						)
				),
				new PascalTriangleLevel(
						asList(
								new PascalTriangleNode(5),
								new PascalTriangleNode(10),
								new PascalTriangleNode(5)
						)
				)
		);
		assertThat(
				"Cannot format triangles of level four",
				format.format(triangle),
				is("    5\n" +
						"   / \\\n" +
						"  5   5\n" +
						" / \\ / \\\n" +
						"5  10   5"
				)
		);
	}

	private void configureIteratorWithLevels(PascalTriangleLevel... levels) {
		triangle = Mockito.spy(new PascalTriangle(levels.length));
		given(triangle.iterator()).willReturn(asList(levels).iterator());
	}
}