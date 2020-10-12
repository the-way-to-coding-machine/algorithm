package org.wtcm.nb2020;

import java.util.Stack;

public class DecompressString_JY {
    StringBuilder number = new StringBuilder();
    Stack<Integer> numStack = new Stack<>();
    StringBuilder character = new StringBuilder();
    StringBuilder answer = new StringBuilder();
    Stack<Character> parentheses = new Stack<>();

    char[] compressedArray;
    int current = 0;

    public String solution(String compressed) {
        // input : 3(hi)xa5(b)4(he3(q)llo) * 소문자만 나옴.
        // output : hihihixabbbbbheqqqlloheqqqlloheqqqlloheqqqllo
        compressedArray = compressed.toCharArray();


        while(current < compressedArray.length) {
            if (isNumber(compressedArray[current])) {
                readNumber();
            } else if (isAlpha(compressedArray[current])) {
                readChar();
            } else if (compressedArray[current] == '(') {
                parentheses.push(compressedArray[current++]);
                numStack.push(Integer.parseInt(number.toString()));
                number = new StringBuilder();
            } else { // )
                unzip(numStack.pop(), character.toString());
                parentheses.pop();
            }
        }
        return answer.toString();
    }

    private void readChar() {
        do {
            character.append(compressedArray[current++]);
        } while(isAlpha(compressedArray[current]));
    }

    void readNumber() {
        do {
            number.append(compressedArray[current++]);
        } while(isNumber(compressedArray[current]));
    }

    void unzip(int times, String string) {
        for (int i = 0; i < times; i ++)
            answer.append(string);
    }

    boolean isNumber(char c) {
        return 48 <= c && c <= 57;
    }

    boolean isAlpha(char c) {
        return  97 <= c && c <= 122;
    }
}
