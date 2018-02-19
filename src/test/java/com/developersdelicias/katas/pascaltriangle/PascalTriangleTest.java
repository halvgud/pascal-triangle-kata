package com.developersdelicias.katas.pascaltriangle;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.Iterator;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;

public class PascalTriangleTest {

	private static final PascalTriangleLevel LEVEL_1 =
			aLevelWithNodes(
					nodeWithValue(1)
			);
	private static final PascalTriangleLevel LEVEL_2 =
			aLevelWithNodes(
					nodeWithValue(1),
					nodeWithValue(1)
			);
	private static final PascalTriangleLevel LEVEL_3 =
			aLevelWithNodes(
					nodeWithValue(1),
					nodeWithValue(2),
					nodeWithValue(1)
			);

	private static final PascalTriangleLevel LEVEL_4 =
			aLevelWithNodes(
					nodeWithValue(1),
					nodeWithValue(3),
					nodeWithValue(3),
					nodeWithValue(1)
			);

	private static final PascalTriangleLevel LEVEL_5 =
			aLevelWithNodes(
					nodeWithValue(1),
					nodeWithValue(4),
					nodeWithValue(6),
					nodeWithValue(4),
					nodeWithValue(1)
			);

	private static final PascalTriangleLevel LEVEL_6 =
			aLevelWithNodes(
					nodeWithValue(1),
					nodeWithValue(5),
					nodeWithValue(10),
					nodeWithValue(10),
					nodeWithValue(5),
					nodeWithValue(1)
			);

	private static final PascalTriangleLevel LEVEL_7 =
			aLevelWithNodes(
					nodeWithValue(1),
					nodeWithValue(6),
					nodeWithValue(15),
					nodeWithValue(20),
					nodeWithValue(15),
					nodeWithValue(6),
					nodeWithValue(1)
			);

	@Test
	public void can_print_in_a_console_with_given_format() {
		Console console = Mockito.mock(Console.class);
		PascalTriangleFormat format = Mockito.mock(PascalTriangleFormat.class);
		PascalTriangle triangle = new PascalTriangle(1);
		String formattedOutput = "Formatted Triangle";
		given(format.format(triangle)).willReturn(formattedOutput);

		triangle.print(console, format);

		InOrder inorder = inOrder(format, console);
		inorder.verify(format).format(triangle);
		inorder.verify(console).print(formattedOutput);
	}

	@Test
	public void can_inform_its_level() {
		assertThat(new PascalTriangle(1).level(), is(1));
		assertThat(new PascalTriangle(2).level(), is(2));
		assertThat(new PascalTriangle(3).level(), is(3));
		assertThat(new PascalTriangle(100).level(), is(100));
	}

	@Test
	public void can_iterate_triangles_of_level_one() {
		Iterator<PascalTriangleLevel> levels = triangleWithLevel(1);

		assertThat(levels.hasNext(), is(true));
		assertThat(levels.next(), is(LEVEL_1));
		assertThat(levels.hasNext(), is(false));
	}

	@Test
	public void can_iterate_triangles_of_level_two() {
		Iterator<PascalTriangleLevel> levelIterator = triangleWithLevel(2);

		assertThat(levelIterator.hasNext(), is(true));
		assertThat(levelIterator.next(), is(LEVEL_1));
		assertThat(levelIterator.next(), is(LEVEL_2));
		assertThat(levelIterator.hasNext(), is(false));
	}

	@Test
	public void can_iterate_triangles_of_level_three() {
		Iterator<PascalTriangleLevel> levelIterator = triangleWithLevel(3);

		assertThat(levelIterator.hasNext(), is(true));
		assertThat(levelIterator.next(), is(LEVEL_1));
		assertThat(levelIterator.next(), is(LEVEL_2));
		assertThat(levelIterator.next(), is(LEVEL_3));
		assertThat(levelIterator.hasNext(), is(false));
	}

	@Test
	public void can_iterate_triangles_of_level_six() {
		Iterator<PascalTriangleLevel> levelIterator = triangleWithLevel(6);

		assertThat(levelIterator.hasNext(), is(true));
		assertThat(levelIterator.next(), is(LEVEL_1));
		assertThat(levelIterator.next(), is(LEVEL_2));
		assertThat(levelIterator.next(), is(LEVEL_3));
		assertThat(levelIterator.next(), is(LEVEL_4));
		assertThat(levelIterator.next(), is(LEVEL_5));
		assertThat(levelIterator.next(), is(LEVEL_6));
		assertThat(levelIterator.hasNext(), is(false));
	}

	@Test
	public void can_iterate_triangles_of_level_seven() {
		Iterator<PascalTriangleLevel> levelIterator = triangleWithLevel(7);

		assertThat(levelIterator.hasNext(), is(true));
		assertThat(levelIterator.next(), is(LEVEL_1));
		assertThat(levelIterator.next(), is(LEVEL_2));
		assertThat(levelIterator.next(), is(LEVEL_3));
		assertThat(levelIterator.next(), is(LEVEL_4));
		assertThat(levelIterator.next(), is(LEVEL_5));
		assertThat(levelIterator.next(), is(LEVEL_6));
		assertThat(levelIterator.next(), is(LEVEL_7));
		assertThat(levelIterator.hasNext(), is(false));
	}

	private Iterator<PascalTriangleLevel> triangleWithLevel(int level) {
		return new PascalTriangle(level).levels();
	}

	private static PascalTriangleLevel aLevelWithNodes(PascalTriangleNode... nodes) {
		return new PascalTriangleLevel(asList(nodes));
	}

	private static PascalTriangleNode nodeWithValue(long value) {
		return new PascalTriangleNode(value);
	}
}