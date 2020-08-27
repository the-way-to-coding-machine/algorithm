package org.wtcm.acmicpc.q1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_JY {
    static int[] characterPriority = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        String[] alphabets = new String[N];
        for (int i = 0; i < N; i++) {
            alphabets[i] = br.readLine();
            String string = alphabets[i];
            for (int idx = 0; idx < string.length(); idx++) {
                characterPriority[string.charAt(idx) - 'A'] += (int)Math.pow(10, string.length()-idx-1);
            }
        }
        Arrays.sort(characterPriority);

        int num = 9;
        for (int i = characterPriority.length-1; i >= 0; i--)
            if (characterPriority[i] > 0)
                answer += characterPriority[i]*(num--);

        System.out.println(answer);
    }

    /*
    * note. 이건 backtracking.
    * */
    public static void start() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int input= Integer.parseInt(br.readLine());
        String alpha[]= new String[input];
        int dp[]= new int[10];
        int num[]=new int[10];

        for(int i=0;i<input;i++){
            alpha[i]=br.readLine();
        }

        for(int i=0;i<input;i++){		//한줄
            int ten=1;
            for(int j=alpha[i].length()-1;j>=0;j--){		//끝문자
                for(int q=0;q<10;q++){
                    if(dp[q]==0){
                        dp[q]=(int)alpha[i].charAt(j);
                        num[q]+=ten;
                        break;
                    }
                    else if(dp[q]==(int)alpha[i].charAt(j)){
                        num[q]+=ten;
                        break;
                    }
                }
                ten*=10;
            }
        }
        int sum=0;

        Arrays.sort(num);
        for(int i=9;i>0;i--){
            sum+=num[i]*i;
        }
        System.out.println(sum);
    }
}
