package com.sam.controller;

import java.io.File;
import java.io.IOException;

public class FileCreateTest {
	
	public static void main(String[] args) {
		createFile();
	}

	public static void createFile() {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		String fileName = "abc.txt";// 文件名及类型
		File file = new File(path, fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
