package com.developersdelicias.katas.pascaltriangle;

import java.util.Iterator;

class BranchedPascalTriangleFormat implements PascalTriangleFormat {

	private static final String BRANCH_CONNECTOR = "/ \\";
	private static final RepeatedString BLANK = new RepeatedString(" ");
	private static final RepeatedString BRANCH_CONNECTOR_WITH_BLANK = new RepeatedString(BRANCH_CONNECTOR + BLANK.times(1));

	@Override
	public String format(PascalTriangle triangle) {
		Iterator<PascalTriangleLevel> iterator = triangle.iterator();
		MultipleLineString outputs = null;
		int actualLevelCount = 1;
		int leftMargin = (triangle.level() - 1) * 2;
		int additionalConnectors = 0;
		while (iterator.hasNext()) {
			PascalTriangleLevel currentLevel = iterator.next();
			String valueLine = createValueLine(leftMargin--, currentLevel.iterator());
			if (outputs == null)
				outputs = new MultipleLineString(valueLine);
			else
				outputs.appendLine(valueLine);

			if (triangle.level() > 1 && actualLevelCount < triangle.level()) {
				outputs.appendLine(nodeConnector(leftMargin--, additionalConnectors++));
			}
			actualLevelCount++;
		}
		return outputs == null ? "" : outputs.toString();
	}

	private String nodeConnector(int leftMargin, int additionalConnectors) {
		return BLANK.times(leftMargin) + BRANCH_CONNECTOR_WITH_BLANK.times(additionalConnectors) + BRANCH_CONNECTOR;
	}

	private String createValueLine(int leftMargin, Iterator<PascalTriangleNode> iterator) {
		StringBuilder line = new StringBuilder(BLANK.times(leftMargin));

		String previousValue = "";
		if (iterator.hasNext()) {
			previousValue = iterator.next().value();
			line.append(previousValue);
		}
		while (iterator.hasNext()) {
			String value = iterator.next().value();
			if (previousValue.length() == 2 && value.length() == 3) {
				line.append(BLANK.times(2));
			} else if (previousValue.length() == 3 && value.length() == 3) {
				line.append(BLANK.times(1));
			}
			else if (previousValue.length() == 3 && value.length() == 2) {
				line.append(BLANK.times(1));
			}
			else {
				line.append(BLANK.times(value.length() == 2 ? 2 : 3));
			}
			line.append(value);
			previousValue = value;
		}
		return line.toString();
	}
}
