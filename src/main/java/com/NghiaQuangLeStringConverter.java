package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class NghiaQuangLeStringConverter {

	public static String convert(String input, Map<String,String> nghiaQuangLeMap){
        StringTokenizer token = new StringTokenizer(input, " ");
        List<String> list = new ArrayList<>();
        while (token.hasMoreTokens()) {
            String word = token.nextToken();
            for (char c : word.toCharArray()) {
                if (nghiaQuangLeMap.containsKey(String.valueOf(c))) {
                    word = word.replace(c, (char) nghiaQuangLeMap.get(String.valueOf(c)).charAt(0));
                }
            }
            list.add(word);
        }
        String content = "";
        for (String s : list) {
            content += s + " ";
        }
        return content.trim();
    }
}
