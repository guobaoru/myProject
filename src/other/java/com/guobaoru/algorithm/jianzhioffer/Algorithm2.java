package com.guobaoru.algorithm.jianzhioffer;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/19.
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Algorithm2 {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("aaa bbb ccc ddd");
        System.out.println(replaceSpace(stringBuffer));
    }

    /**
     * 遍历循环出空格替换
     * @param str
     * @return
     */
    public static String replaceSpace1(StringBuffer str) {

        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if (s == ' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }

    public static String replaceSpace(StringBuffer str) {
        if(str==null){
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                newStr.append("%20");
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
}
