package com.developersdelicias.katas.pascaltriangle;

import java.util.Iterator;

class BranchedPascalTriangleFormat implements PascalTriangleFormat {

	private static final String BRANCH_CONNECTOR = "/ \\";
	private static final RepeatedString BLANK = new RepeatedString(" ");
	private static final RepeatedString BRANCH_CONNECTOR_WITH_BLANK = new RepeatedString(BRANCH_CONNECTOR + BLANK.times(1));

	@Override
	public String format(PascalTriangle triangle) {

		if (triangle.level() == 2) {
			Iterator<PascalTriangleLevel> iterator = triangle.iterator();
			PascalTriangleLevel level1 = iterator.next();
			PascalTriangleLevel level2 = iterator.next();
			Iterator<PascalTriangleNode> level1NodeIterator = level1.iterator();
			Iterator<PascalTriangleNode> level2NodeIterator = level2.iterator();
			MultipleLineString output = new MultipleLineString(createValueLine(2, level1NodeIterator))
					.appendLine(nodeConnector(1, 0))
					.appendLine(createValueLine(0, level2NodeIterator));
			return output.toString();
		}

		if (triangle.level() == 3) {
			Iterator<PascalTriangleLevel> iterator = triangle.iterator();
			PascalTriangleLevel level1 = iterator.next();
			PascalTriangleLevel level2 = iterator.next();
			PascalTriangleLevel level3 = iterator.next();

			Iterator<PascalTriangleNode> level1NodeIterator = level1.iterator();
			Iterator<PascalTriangleNode> level2NodeIterator = level2.iterator();
			Iterator<PascalTriangleNode> level3NodeIterator = level3.iterator();
			MultipleLineString output = new MultipleLineString(createValueLine(4, level1NodeIterator))
					.appendLine(nodeConnector(3, 0))
					.appendLine(createValueLine(2, level2NodeIterator))
					.appendLine(nodeConnector(1, 1))
					.appendLine(createValueLine(0, level3NodeIterator));
			return output.toString();
		}
		if (triangle.level() == 4) {
			Iterator<PascalTriangleLevel> iterator = triangle.iterator();
			PascalTriangleLevel level1 = iterator.next();
			PascalTriangleLevel level2 = iterator.next();
			PascalTriangleLevel level3 = iterator.next();
			PascalTriangleLevel level4 = iterator.next();

			Iterator<PascalTriangleNode> level1NodeIterator = level1.iterator();
			Iterator<PascalTriangleNode> level2NodeIterator = level2.iterator();
			Iterator<PascalTriangleNode> level3NodeIterator = level3.iterator();
			Iterator<PascalTriangleNode> level4NodeIterator = level4.iterator();
			MultipleLineString output = new MultipleLineString(createValueLine(6, level1NodeIterator))
					.appendLine(nodeConnector(5, 0))
					.appendLine(createValueLine(4, level2NodeIterator))
					.appendLine(nodeConnector(3, 1))
					.appendLine(createValueLine(2, level3NodeIterator))
					.appendLine(nodeConnector(1, 2))
					.appendLine(createValueLine(0, level4NodeIterator));
			return output.toString();
		}

		return "1";
	}

	private String nodeConnector(int leftMargin, int additionalConnectors) {
		return BLANK.times(leftMargin) + BRANCH_CONNECTOR_WITH_BLANK.times(additionalConnectors) + BRANCH_CONNECTOR;
	}

	private String createValueLine(int leftMargin, Iterator<PascalTriangleNode> iterator) {
		StringBuilder line = new StringBuilder(BLANK.times(leftMargin));
		while (iterator.hasNext()) {
			line.append(iterator.next().value());
			if (iterator.hasNext())
				line.append(BLANK.times(3));
		}
		return line.toString();
	}
}
