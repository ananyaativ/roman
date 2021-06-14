package com.company;

import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(roman("D"));
    }

    public static int roman(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int num=0;
        if(s.length()==1)
            return map.get(s.charAt(0));
        char a;
        char b;
        for (int i=0;i<s.length()-1;i++)
        {
            a=s.charAt(i);
            b=s.charAt(i+1);
            if(b=='X'||b=='V')
                if(a=='I')
                {
                    num=num+ map.get(b)-1;
                    if(i==(s.length()-2))
                        return num;
                    if(i==s.length()-3){
                        num=num+map.get(s.charAt(i+2));
                        break;
                    }
                    i++;
                    continue;}

            if(b=='L'||b=='C')
                if(a=='X'){
                    num=num+ map.get(b)-10;
                    if(i==(s.length()-2))
                        return num;
                    if(i==s.length()-3){
                        num=num+map.get(s.charAt(i+2));
                        break;
                    }

                    i++;
                    continue;}

            if(b=='D'||b=='M')
                if(a=='C'){
                    num=num+map.get(b)-100;
                    if(i==(s.length()-2))
                        return num;
                    if(i==s.length()-3){
                        num=num+map.get(s.charAt(i+2));
                        break;
                    }

                    i++;
                    continue;}


            num=num+map.get(a);
            if(i==(s.length()-2))
                num=num+map.get(b);
        }

        return num;

    }
}
