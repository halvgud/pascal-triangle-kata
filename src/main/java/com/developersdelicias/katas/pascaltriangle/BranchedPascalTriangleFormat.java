package com.developersdelicias.katas.pascaltriangle;

import java.util.Iterator;

class BranchedPascalTriangleFormat implements PascalTriangleFormat {

	private static final String NEW_LINE = "\n";
	private static final String BRANCH_CONNECTOR = "/ \\";
	private static final RepeatedString BLANK = new RepeatedString(" ");
	private static final RepeatedString BRANCH_CONNECTOR_WITH_BLANK = new RepeatedString(BRANCH_CONNECTOR + BLANK.times(1));
	private static final String EMPTY_STRING = "";

	@Override
	public String format(PascalTriangle triangle) {

		if (triangle.level() == 2) {
			return BLANK.times(2) + "1" + NEW_LINE +
					BLANK.times(1) + BRANCH_CONNECTOR + NEW_LINE +
					EMPTY_STRING + "1" + BLANK.times(3) + "1";
		}

		if (triangle.level() == 3) {
			Iterator<PascalTriangleLevel> iterator = triangle.iterator();
			PascalTriangleLevel level1 = iterator.next();
			PascalTriangleLevel level2 = iterator.next();
			PascalTriangleLevel level3 = iterator.next();

			Iterator<PascalTriangleNode> level1NodeIterator = level1.iterator();
			Iterator<PascalTriangleNode> level2NodeIterator = level2.iterator();
			Iterator<PascalTriangleNode> level3NodeIterator = level3.iterator();
			return BLANK.times(4) + level1NodeIterator.next().value() + NEW_LINE +
					BLANK.times(3) + BRANCH_CONNECTOR + NEW_LINE +
					BLANK.times(2) + level2NodeIterator.next().value() + BLANK.times(3) + level2NodeIterator.next().value() + NEW_LINE +
					BLANK.times(1) + BRANCH_CONNECTOR + BLANK.times(1) + BRANCH_CONNECTOR + NEW_LINE +
					level3NodeIterator.next().value() + BLANK.times(3) + level3NodeIterator.next().value() + BLANK.times(3) + level3NodeIterator.next().value();
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
			return BLANK.times(6) + level1NodeIterator.next().value() + NEW_LINE +
					BLANK.times(5) + BRANCH_CONNECTOR_WITH_BLANK.times(0) + BRANCH_CONNECTOR + NEW_LINE +
					BLANK.times(4) + level2NodeIterator.next().value() + BLANK.times(3) + level2NodeIterator.next().value() + NEW_LINE +
					BLANK.times(3) + BRANCH_CONNECTOR_WITH_BLANK.times(1) + BRANCH_CONNECTOR + NEW_LINE +
					BLANK.times(2) + level3NodeIterator.next().value() + BLANK.times(3) + level3NodeIterator.next().value() + BLANK.times(3) + level3NodeIterator.next().value() + NEW_LINE +
					BLANK.times(1) + BRANCH_CONNECTOR_WITH_BLANK.times(2) + BRANCH_CONNECTOR + NEW_LINE +
					BLANK.times(0) + level4NodeIterator.next().value() + BLANK.times(3) + level4NodeIterator.next().value() + BLANK.times(3) + level4NodeIterator.next().value() + BLANK.times(3) + level4NodeIterator.next().value();
		}

		return "1";
	}
}
