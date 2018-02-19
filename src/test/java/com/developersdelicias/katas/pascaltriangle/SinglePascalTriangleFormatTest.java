package com.developersdelicias.katas.pascaltriangle;

import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

public class SinglePascalTriangleFormatTest {
	@Test
	public void formats_using_new_lines() {
		SinglePascalTriangleFormat format = new SinglePascalTriangleFormat();
		PascalTriangle triangle = spy(new PascalTriangle(4));
		given(triangle.iterator()).willReturn(
				asList(
						new PascalTriangleLevel(Collections.singletonList(node(1))),
						new PascalTriangleLevel(asList(node(2), node(2))),
						new PascalTriangleLevel(asList(node(3), node(3), node(3))),
						new PascalTriangleLevel(asList(node(4), node(4), node(4), node(4)))
				)
						.iterator());

		assertThat(
				"Cannot apply single formats",
				format.format(triangle),
				is("1\n" +
						"2 2\n" +
						"3 3 3\n" +
						"4 4 4 4")
		);
	}

	private PascalTriangleNode node(int value) {
		return new PascalTriangleNode(value);
	}
}