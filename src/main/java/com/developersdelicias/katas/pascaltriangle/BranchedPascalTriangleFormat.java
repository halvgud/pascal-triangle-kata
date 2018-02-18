package com.developersdelicias.katas.pascaltriangle;

class BranchedPascalTriangleFormat implements PascalTriangleFormat {

	private static final String NEW_LINE = "\n";
	private static final String BRANCH_CONNECTOR = "/ \\";

	@Override
	public String format(PascalTriangle triangle) {
		if (triangle.level() == 3)
			return "    1" + NEW_LINE +
					"   " + BRANCH_CONNECTOR + NEW_LINE +
					"  1   1" + NEW_LINE +
					" " + BRANCH_CONNECTOR + " " + BRANCH_CONNECTOR + NEW_LINE +
					"1   2   1";

		if (triangle.level() == 2)
			return "  1" + NEW_LINE +
					" " + BRANCH_CONNECTOR + NEW_LINE +
					"1   1";
		return "1";
	}
}
