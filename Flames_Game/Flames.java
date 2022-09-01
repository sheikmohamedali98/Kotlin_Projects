package Flames_Game;

import java.util.Arrays;

public class Flames {


    public  void flame(String name1, String name2) {

        int len1 = name1.length();
        int len2 = name2.length();
        String s1 = name1;
        String s2 = name2;


        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (name1.charAt(i) == name2.charAt(j)) {
                    name1 = name1.replaceFirst(String.valueOf(name1.charAt(i)), "0");
                    name2 = name2.replaceFirst(String.valueOf(name2.charAt(j)), "0");

                }
            }
        }

        System.out.println("Balance String of "+s1);
        String str1 = balanceName(name1);
        System.out.println(str1);
        System.out.println();
        System.out.println("Balance String of "+s2);
        String str2 = balanceName(name2);
        System.out.println(str2);
        name1 = name1.replaceAll("0", "");
        name2 = name2.replaceAll("0", "");
        String result = name1 + name2;
        char ch = findChar(result);
        System.out.println();

        System.out.println(s1+" and "+s2+" relation ship is "+relationShip(ch));

    }

    public  String balanceName(String str) {
        char[] ch = new char[str.length()];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                ch[index++] = str.charAt(i);
            }
        }
        ch = Arrays.copyOf(ch, index);
        return String.valueOf(ch);
    }

    public   char findChar(String str) {
        String flame = "FLAMES";
        int len = flame.length();
        int temp = 0;
        char relation = ' ';

        if(str.length()>0) {
            temp = str.length()%len;
        }
        if(temp ==0&&len>=6) {
            relation = 'S';
        }else {
            int count = temp-1;
            if(count>=0) {
                relation = flame.charAt(count);
            }
        }
        return relation;
    }

    public  String relationShip(char ch) {
        switch (ch) {
            case 'F':
                return "Friends";
            case 'L':
                return "Love";
            case 'A':
                return "Affection";

            case 'M':
                return "Marriage";
            case 'E':
                return "Enemies";
            case 'S':
                return "Sibling(Sister)";

        }
        return "";
    }

}
