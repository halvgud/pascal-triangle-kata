package com.developersdelicias.katas.pascaltriangle;

import java.util.Iterator;

class BranchedPascalTriangleFormat implements PascalTriangleFormat {

	private static final RepeatedString BLANK = new RepeatedString(" ");
	private int triangleLevel = 0;
	private int additionalMargin = 0;
	private int actualLevelCount;
	private int leftMargin;
	private int additionalConnectors;

	@Override
	public String format(PascalTriangle triangle) {
		initialize(triangle);
		return createOutput(triangle).toString();
	}

	private void initialize(PascalTriangle triangle) {
		this.triangleLevel = triangle.level();
		actualLevelCount = 1;
		leftMargin = (triangleLevel - 1) * 2;
		additionalMargin = triangleLevel >= 14 ? 13 : 0;
		additionalConnectors = 0;

		if (triangleLevel >= 17) {
			additionalMargin += 3;
		}
	}

	private MultipleLineString createOutput(PascalTriangle triangle) {
		Iterator<PascalTriangleLevel> triangleLevels = triangle.levels();
		MultipleLineString outputs = new MultipleLineString();
		while (triangleLevels.hasNext()) {
			PascalTriangleLevel currentLevel = triangleLevels.next();
			outputs.appendLine(createValueLine(currentLevel.nodes()));

			if (triangleLevel > 1 && actualLevelCount < triangleLevel) {
				outputs.appendLine(nodeConnector(leftMargin--, additionalConnectors++));
			}
			actualLevelCount++;
		}
		return outputs;
	}

	private String nodeConnector(int leftMargin, int additionalConnectors) {

		String branchSymbol = "/ \\";

		if (this.triangleLevel >= 14) {
			branchSymbol = "/   \\";
		}

		if (additionalMargin < 0) {
			additionalMargin = 0;
		}

		return BLANK.times(leftMargin + additionalMargin)
				+ new RepeatedString(branchSymbol + BLANK.times(1)).times(additionalConnectors)
				+ branchSymbol;
	}

	private String createValueLine(Iterator<PascalTriangleNode> iterator) {
		if (additionalMargin < 0) {
			additionalMargin = 0;
		}
		StringBuilder line = new StringBuilder(BLANK.times((leftMargin--) + (additionalMargin--)));

		String previousValue = "";
		if (iterator.hasNext()) {
			previousValue = iterator.next().value();
			line.append(previousValue);
		}
		while (iterator.hasNext()) {
			String value = iterator.next().value();
			if (triangleLevel >= 14) {
				if (previousValue.length() == 1 && value.length() == 1) {
					line.append(BLANK.times(5));
				} else if (previousValue.length() == 1 && value.length() == 2) {
					line.append(BLANK.times(4));
				} else if (previousValue.length() == 2 && value.length() == 2) {
					line.append(BLANK.times(4));
				} else if (previousValue.length() == 2 && value.length() == 3) {
					line.append(BLANK.times(3));
				} else if (previousValue.length() == 3 && value.length() == 3) {
					line.append(BLANK.times(3));
				} else if (previousValue.length() == 3 && value.length() == 2) {
					line.append(BLANK.times(4));
				} else if (previousValue.length() == 3 && value.length() == 4) {
					line.append(BLANK.times(2));
				} else if (previousValue.length() == 4 && value.length() == 3) {
					line.append(BLANK.times(3));
				} else if (previousValue.length() == 4 && value.length() == 4) {
					line.append(BLANK.times(2));
				} else if (previousValue.length() == 4 && value.length() == 5) {
					line.append(BLANK.times(1));
				} else if (previousValue.length() == 5 && value.length() == 5) {
					line.append(BLANK.times(1));
				} else if (previousValue.length() == 5 && value.length() == 4) {
					line.append(BLANK.times(2));
				} else {
					line.append(BLANK.times(5));
				}
			} else {
				if (previousValue.length() == 2 && value.length() == 3) {
					line.append(BLANK.times(2));
				} else if (previousValue.length() == 3 && value.length() == 3) {
					line.append(BLANK.times(1));
				} else if (previousValue.length() == 3 && value.length() == 2) {
					line.append(BLANK.times(1));
				} else {
					line.append(BLANK.times(value.length() == 2 ? 2 : 3));
				}
			}

			line.append(value);
			previousValue = value;
		}
		return line.toString();
	}
}
