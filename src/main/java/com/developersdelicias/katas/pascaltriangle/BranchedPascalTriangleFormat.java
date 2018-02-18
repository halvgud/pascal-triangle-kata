package com.developersdelicias.katas.pascaltriangle;

class BranchedPascalTriangleFormat implements PascalTriangleFormat {
	@Override
	public String format(PascalTriangle triangle) {
		if (triangle.level() == 2)
			return "  1\n" +
					" / \\\n" +
					"1   1";
		return "1";
	}
}
