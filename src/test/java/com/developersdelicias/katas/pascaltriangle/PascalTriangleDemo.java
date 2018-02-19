package com.developersdelicias.katas.pascaltriangle;

public class PascalTriangleDemo {

	public static void main(String[] args) {
		for (int level = 1; level <= 30; level++) {
			createFileForTriangleOfLevel(level);
		}
	}

	private static void createFileForTriangleOfLevel(int level) {
		PascalTriangle triangle = new PascalTriangle(level);
		PascalTriangleFormat branchedFormat = new BranchedPascalTriangleFormat();
		Output file = new ToFile("C://tmp/triangles/triangle_level_" + level + ".txt");

		triangle.print(file, branchedFormat);
	}
}
