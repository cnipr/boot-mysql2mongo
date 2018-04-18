package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BufferedReaderTest {

	public static void main(String[] args) throws Exception {
		// 获取读取流
		FileReader reader = new FileReader("Y:\\testlog\\ub.log.103");
		BufferedReader br = new BufferedReader(reader);

		String string = null;
		while ((string = br.readLine()) != null) {
			// 注意这里输出的是string,实际上readLine()方法只被调用了一次。
			System.out.println(string);
		}

		// 关闭读取流
		br.close();
		reader.close();

	}

}
