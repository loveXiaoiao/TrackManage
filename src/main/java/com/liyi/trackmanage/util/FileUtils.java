package com.liyi.trackmanage.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author liyi
 * @date 2015年6月1日
 * @desc 文件处理工具类
 */
public class FileUtils {

	public static List<String> readTxtFile(String filePath) {
		try {
			List<String> resultList = null;
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				resultList = new ArrayList<String>();
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					resultList.add(lineTxt);
				}
				read.close();
			} else {
				System.out.println("File not found:"+filePath);
				return null;
			}
			return resultList;
		} catch (Exception e) {
			System.out.println("Read file error");
			e.printStackTrace();
			return null;
		}

	}

	public static void writeStringToFile(String filePath, String str) {
		File f = new File(filePath);
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			FileOutputStream out = new FileOutputStream(filePath);
			out.write(str.getBytes());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
