package com.developersdelicias.katas.pascaltriangle;

import java.util.Objects;

public class PascalTriangleNode {
	private final long value;

	PascalTriangleNode(final long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "PascalTriangleNode{" +
				"value=" + value +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PascalTriangleNode that = (PascalTriangleNode) o;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	public String value() {
		return String.valueOf(this.value);
	}
}
