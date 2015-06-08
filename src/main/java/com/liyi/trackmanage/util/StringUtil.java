package com.liyi.trackmanage.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static int getNumFromString(String str) {
        int result = 0;
        if (str != null && str.length() > 0) {
            String regEx = "[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            String resultStr = m.replaceAll("").trim();
            if (!"".equals(resultStr)) {
                result = Integer.parseInt(resultStr);
            }
        }
        return result;
    }

}
