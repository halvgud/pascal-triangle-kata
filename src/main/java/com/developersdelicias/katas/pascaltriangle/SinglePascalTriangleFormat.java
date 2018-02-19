package com.developersdelicias.katas.pascaltriangle;

import java.util.Iterator;

public class SinglePascalTriangleFormat implements PascalTriangleFormat {

	@Override
	public String format(PascalTriangle triangle) {
		Iterator<PascalTriangleLevel> iterator = triangle.iterator();
		if (iterator.hasNext()) {
			MultipleLineString output = null;
			while (iterator.hasNext()) {
				PascalTriangleLevel currentLevel = iterator.next();
				Iterator<PascalTriangleNode> nodeIterator = currentLevel.iterator();
				StringBuilder line = new StringBuilder();
				while (nodeIterator.hasNext()) {
					line.append(nodeIterator.next().value());
					if (nodeIterator.hasNext()) {
						line.append(" ");
					}
				}
				if (output == null) {
					output = new MultipleLineString(line.toString());
				} else
					output.appendLine(line.toString());
			}
			return output != null ? output.toString() : null;
		}

		return null;
	}
}
