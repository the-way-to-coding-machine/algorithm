package org.wtcm.kakao2021;


public class Q1 {
//    static String new_id = "...!@BaT#*..y.abcdefghijklm";
    static String new_id = "=.=";
//    static String new_id = "z-+.^.";

    public static void main(String[] args) {
        new_id = replace(new_id.toLowerCase());

        System.out.println(new_id);
    }

    static String replace(String id) {

        StringBuffer sb = new StringBuffer(id);

        sb = new StringBuffer(sb.toString().replaceAll("\\.{2,}", "."));

        int length = sb.length()-1;
        for (int i = 0; i <= length; i++)
            if (!availableCharacter(sb.charAt(i))) {
                sb.deleteCharAt(i);
                length--;
                i--;
            }

        while (sb.length() >= 1 && sb.charAt(0) == '.')
            sb.deleteCharAt(0);

        int last = sb.length() - 1;
        while (sb.length() >= 1 && sb.charAt(last) == '.')
            sb.deleteCharAt(last--);

        if (sb.length() == 0)
            sb.append('a');

        if (sb.length() >= 16)
            sb = new StringBuffer(sb.toString().substring(0,15));

        while (sb.length() >= 1 && sb.charAt(0) == '.')
            sb.deleteCharAt(0);

        while (sb.length() >= 1 && sb.charAt(sb.length() - 1) == '.')
            sb.deleteCharAt(sb.length() - 1);

        while (sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        return sb.toString();
    }

    static boolean availableCharacter(char ch) {
        if (ch == '.') {
            return true;
        } else if (ch == '-') {
            return true;
        } else if (ch == '_') {
            return true;
        } else if ('a' <= ch && ch <= 'z') {
            return true;
        } else return '0' <= ch && ch <= '9';
    }
}
