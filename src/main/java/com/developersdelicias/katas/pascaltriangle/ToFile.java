package com.developersdelicias.katas.pascaltriangle;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ToFile implements Output {

	private final String fileName;

	ToFile(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void print(String output) {
		Path path = Paths.get(fileName);
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(output);
		} catch (IOException e) {
			// ignored
		}
	}
}
