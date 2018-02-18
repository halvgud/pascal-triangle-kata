package com.developersdelicias.katas.pascaltriangle;

import java.util.Collection;
import java.util.Objects;

class PascalTriangleLevel {
	private final Collection<PascalTriangleNode> nodes;

	PascalTriangleLevel(final Collection<PascalTriangleNode> nodes) {
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		return "PascalTriangleLevel{" +
				"nodes=" + nodes +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PascalTriangleLevel that = (PascalTriangleLevel) o;
		return Objects.equals(nodes, that.nodes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nodes);
	}
}
