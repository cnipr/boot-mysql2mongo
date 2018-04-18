package com.easysoft.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class LogFileService  implements CommandLineRunner {
	
	
	@Override
	public void run(String... args) throws Exception {
//		long t1 = System.currentTimeMillis();
//		String path = "Y:\\132demo";
//		File file = new File(path);
//		printFiles(file);
//		long t2 = System.currentTimeMillis();
//		System.out.println("consume time:" + (t2 - t1) + "ms");
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LogFileService.class, args);
	}

	private void printFiles(File file) throws Exception {
		System.out.println(file.getAbsolutePath());
		int count = 0;
		long t1 = System.currentTimeMillis();
		if (file.isDirectory()) {
			File[] files = file.listFiles();
//			for (int i = 0; i < files.length; i++) {
//				printFiles(files[i]);
//			}
			for (int i = files.length-1; i > -1; i--) {
				printFiles(files[i]);
			}
		}else{
			BufferedReader in =new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));    
			while (true) {
				if (file.getName().endsWith(".log")) {
					System.out.println("跳过当前正在使用的文件...."); 
					break;
				}				 
				String line = in.readLine();
				if (line == null) {
					in.close();
					long t2 = System.currentTimeMillis();
					System.out.println(file.getAbsolutePath() + "\t记录数:" + count + "\t consume time:" + (t2 - t1) + "ms");
					break;
				}else{
//					System.out.println(line);
					line = line.substring(line.indexOf("{"));
					try {
						Json2MongoService.saveJsonStr(line);
					} catch (Throwable e) {
						System.out.println(line);
						e.printStackTrace();
					}
					count ++;
				}
			}

		}
	}

}
