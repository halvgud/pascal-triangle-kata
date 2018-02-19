package com.developersdelicias.katas.pascaltriangle;

public class PascalTriangleDemo {

	public static void main(String[] args) {
		PascalTriangle triangle = new PascalTriangle(20);
		PascalTriangleFormat branchedFormat = new BranchedPascalTriangleFormat();
		PascalTriangleFormat singleFormat = new SinglePascalTriangleFormat();
		Console console = new Console();

		console.print("Branched Format");
		triangle.print(console, branchedFormat);
		console.print("Single Format");
		triangle.print(console, singleFormat);
	}
}
