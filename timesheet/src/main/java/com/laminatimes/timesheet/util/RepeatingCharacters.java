package com.laminatimes.timesheet.util;

import java.util.HashSet;
import java.util.Set;

public class RepeatingCharacters {
    public static void main(String[] args) {
        String str = "bbcszqbbbbab";
//        "aabcabcbb";
//        "abcabcbb";
//        new RepeatingCharacters().lengthOfLongestSubstring(str);
        System.out.println(unique(str));
    }
    public int lengthOfLongestSubstring(String s) {
    int len  = 0;
    char sArray[] = s.toCharArray();
    char current = sArray[0];
    int index = 0;
    for(int i=1; i<s.length()-1;i++) {
        int tIndex = check(sArray[i], s.substring(index, i));

        if(tIndex == -1) {
            current = sArray[i];
            continue;
        } else {
            current =  sArray[i];
            index = tIndex;
        }
    }

    return len;
    }

    public int check(char c, String st) {
        for(int i=0; i<st.length();i++) {
            if(c == st.charAt(i)) {
                return i;
            }
        }
        return -1;
    }



    private static int unique(String str) {
        // TODO Auto-generated method stub
        int len=str.length();
        int max=1;
        Set<Character> set=new HashSet<>();

        for(int i=0;i<len;i++){
            int count=1;
            for(int j=i+1;j<len;j++){

                if(str.charAt(i)!=str.charAt(j)){
                    set.add(str.charAt(j));
                    count=count+1;
                    if(set.size() != count-1){
                        count=1;
                        set.clear();
                    }

                    if(count>max)max=count;
                }else{
                    count=1;
                }

            }

        }
        return max;
    }
}
