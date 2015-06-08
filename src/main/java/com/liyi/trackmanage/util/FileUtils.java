package com.liyi.trackmanage.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<String> readTxtFile(String filePath) {
        try {
            String encoding = "utf-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                List<String> resultList = new ArrayList<String>();
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    resultList.add(lineTxt);
                }
                read.close();
                return resultList;
            } else {
                System.out.println("File not found:" + filePath);
                return null;
            }
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
