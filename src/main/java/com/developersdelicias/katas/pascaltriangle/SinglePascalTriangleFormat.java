package com.developersdelicias.katas.pascaltriangle;

import java.util.Iterator;

public class SinglePascalTriangleFormat implements PascalTriangleFormat {

	@Override
	public String format(PascalTriangle triangle) {
		Iterator<PascalTriangleLevel> levels = triangle.levels();
		MultipleLineString output = new MultipleLineString();
		while (levels.hasNext()) {
			output.appendLine(toLine(levels.next()));
		}
		return output.toString();
	}

	private String toLine(PascalTriangleLevel currentLevel) {
		Iterator<PascalTriangleNode> nodes = currentLevel.nodes();
		StringBuilder line = new StringBuilder();
		while (nodes.hasNext()) {
			line.append(nodes.next().value());
			if (nodes.hasNext()) {
				line.append(" ");
			}
		}
		return line.toString();
	}
}
