package com.developersdelicias.katas.pascaltriangle;

import java.util.*;

class PascalTriangle {
	private final int level;
	private final Map<Integer, PascalTriangleLevel> levels;

	PascalTriangle(final int level) {
		this.level = level;
		levels = new HashMap<>(level);
		calculateLevels();
	}

	private void calculateLevels() {
		long[] lastLevel = null;
		for (int currentLevel = 1; currentLevel <= level; currentLevel++) {
			long[] newLevel = createNewLevel(lastLevel, currentLevel);
			putLevel(currentLevel, newLevel);
			lastLevel = newLevel;
		}
	}

	private void putLevel(int currentLevel, long[] aLevel) {
		Collection<PascalTriangleNode> nodes = new ArrayList<>();
		for (long value : aLevel) {
			nodes.add(new PascalTriangleNode(value));
		}
		levels.put(currentLevel, new PascalTriangleLevel(nodes));
	}

	private long[] createNewLevel(long[] lastLevel, int actualLevel) {
		if (lastLevel == null)
			return new long[]{1};

		long[] newLevel = new long[actualLevel];
		for (int i = 0; i < actualLevel; i++) {
			newLevel[i] = valueAt(i - 1, lastLevel) + valueAt(i, lastLevel);
		}
		return newLevel;
	}

	private long valueAt(int index, long[] array) {
		if (index < 0 || index >= array.length)
			return 0;
		return array[index];
	}

	public final void print(Console console, PascalTriangleFormat format) {
		console.print(format.format(this));
	}

	public int level() {
		return this.level;
	}

	public Iterator<PascalTriangleLevel> iterator() {
		return new PascalTriangleLevelIterator(this);
	}

	private PascalTriangleLevel levelAt(int currentLevel) {
		return levels.get(currentLevel);
	}

	private class PascalTriangleLevelIterator implements Iterator<PascalTriangleLevel> {
		private final PascalTriangle pascalTriangle;
		private int currentLevel;

		PascalTriangleLevelIterator(PascalTriangle pascalTriangle) {
			this.pascalTriangle = pascalTriangle;
			currentLevel = 0;
		}

		@Override
		public boolean hasNext() {
			return currentLevel < pascalTriangle.level();
		}

		@Override
		public PascalTriangleLevel next() {
			return pascalTriangle.levelAt(++currentLevel);
		}
	}
}
