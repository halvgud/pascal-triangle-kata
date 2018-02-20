package com.developersdelicias.katas.pascaltriangle;

import java.util.Iterator;

class BranchedPascalTriangleFormat implements PascalTriangleFormat {

	private static final RepeatedString BLANK = new RepeatedString(" ");
	private int triangleLevel = 0;
	private int additionalMargin = 0;
	private int actualLevelCount;
	private int leftMargin;
	private int additionalConnectors;
	private String levelConnector = "/ \\";

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

		if (this.triangleLevel >= 14) {
			levelConnector = "/   \\";
		}
	}

	private MultipleLineString createOutput(PascalTriangle triangle) {
		Iterator<PascalTriangleLevel> triangleLevels = triangle.levels();
		MultipleLineString formattedTriangleString = new MultipleLineString();
		while (triangleLevels.hasNext()) {
			formattedTriangleString.appendLine(createValueLine(triangleLevels.next().nodes()));

			if (shouldAppendConnector()) {
				formattedTriangleString.appendLine(nodeConnector());
			}
			actualLevelCount++;
		}
		return formattedTriangleString;
	}

	private boolean shouldAppendConnector() {
		return actualLevelCount < triangleLevel;
	}

	private String nodeConnector() {
		resetAdditionalMargin();
		return BLANK.times(this.leftMargin-- + additionalMargin)
				+ extraConnectors()
				+ connector();
	}

	private String extraConnectors() {
		return new RepeatedString(connector() + BLANK.times(1)).times(this.additionalConnectors++);
	}

	private String connector() {
		return levelConnector;
	}

	private void resetAdditionalMargin() {
		if (additionalMargin < 0) {
			additionalMargin = 0;
		}
	}

	private String createValueLine(Iterator<PascalTriangleNode> iterator) {
		StringBuilder line = createMargin();
		String previousValue = "";
		if (iterator.hasNext()) {
			previousValue = iterator.next().value();
			line.append(previousValue);
		}
		while (iterator.hasNext()) {
			String value = iterator.next().value();
			line.append(valueSeparator(previousValue, value));
			line.append(value);
			previousValue = value;
		}
		return line.toString();
	}

	private String valueSeparator(String previousValue, String value) {
		return BLANK.times(between(previousValue, value));
	}

	private int between(String previousValue, String value) {
		int spacesBetweenValues;
		int first = previousValue.length();
		int second = value.length();
		if (triangleLevel >= 14) {
			if (first == 1 && second == 1) {
				spacesBetweenValues = 5;
			} else if (first == 1 && second == 2) {
				spacesBetweenValues = 4;
			} else if (first == 2 && (second == 2 || second == 3)) {
				spacesBetweenValues = 4;
			} else if (first == 3 && (second == 3 || second == 2)) {
				spacesBetweenValues = 3;
			} else if (first == 4 && second == 3) {
				spacesBetweenValues = 3;
			} else if (first == 3 && second == 4) {
				spacesBetweenValues = 2;
			} else if (first == 4 && (second == 4 || second == 5)) {
				spacesBetweenValues = 2;
			} else if (first == 5 && (second == 5 || second == 4)) {
				spacesBetweenValues = 1;
			} else {
				spacesBetweenValues = 5;
			}
		} else {
			if (first == 2 && second == 3) {
				spacesBetweenValues = 2;
			} else if (first == 3 && (second == 3 || second == 2)) {
				spacesBetweenValues = 1;
			} else {
				spacesBetweenValues = second == 2 ? 2 : 3;
			}
		}
		return spacesBetweenValues;
	}

	private StringBuilder createMargin() {
		return new StringBuilder(BLANK.times((leftMargin--) + (additionalMargin--)));
	}
}
