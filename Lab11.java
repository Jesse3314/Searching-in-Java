//Program name: Lab11.java
//Name:         Zongxi (Jesse) Li
//ID:           100256604
//DATE:         July,31,2018
//Compiler:     Java SE Development Kit 10.0.1
import java.io.*;
import java.util.*;

public class Lab11{
    public static void main(String[] args)throws FileNotFoundException {
        //Get both phone number and words list from the txt file by using scanner
        Scanner wordIn = new Scanner(new File("word_list.txt"));
        Scanner phoneIn = new Scanner(new File("telephone.txt"));
        System.out.print("Loading...");
        compare(wordIn,phoneIn);
        wordIn.close();
        phoneIn.close();
    }

    /** read the contant from the file letter by letter and count the number of letters as well as the words
      @return: 2D array of strings
      @param input : txt file contains all the words
     */
    public static String[][] txt2Array(Scanner wordIn)throws FileNotFoundException {
        System.out.print("Please wait");
        String tmp = "";
        //Get word line by line from the txt file
        while(wordIn.hasNext()){
            tmp = tmp + wordIn.next() +" ";
        }
        //Creat the 2D array that save both the words and the corresponding number
        String[] temp = tmp.split(" ");
        String[][] wordsArray = new String[temp.length][2];
        for (int i = 0;i<temp.length;i++){
            wordsArray[i][0] = temp[i];
            wordsArray[i][1] = word2number(temp[i]);
        }
        wordIn.close();
        return wordsArray;
    }


    /** Set up the array
      @param wordIn : txt file for words list
      @param phone : txt file for phone numbers
     */
    public static void compare(Scanner wordIn,Scanner phone)throws FileNotFoundException {
        //Read the word from the file and save to the array
        String[][] wordsArray = txt2Array(wordIn);
        phonenum2word(phone, wordsArray);
        wordIn.close();
        phone.close();
    }

    /** Cover all the words into corresponding number
      @return: String of numbers
      @param s1 : one word in the list
     */
    public static String word2number(String s1)throws FileNotFoundException{
        String num = "";
        //Match the word to number character by character
        for(int i = 0;i<s1.length();i++){
            char tep = s1.charAt(i);
            if(tep=='A' || tep=='B' || tep=='C')
                num = num + "2";
            else if(tep=='D' || tep=='E' || tep=='F')
                num = num + "3";
            else if(tep=='G' || tep=='H' || tep=='I')
                num = num + "4";
            else if(tep=='J' || tep=='K' || tep=='L')
                num = num + "5";
            else if(tep=='M' || tep=='N' || tep=='O')
                num = num + "6";
            else if(tep=='P' || tep=='Q' || tep=='R'|| tep=='S')
                num = num + "7";
            else if(tep=='T' || tep=='U' || tep=='V')
                num = num + "8";
            else if(tep=='W' || tep=='X' || tep=='Y'|| tep=='Z')
                num = num + "9";
        }
        return num;
    }

    /** Convert all the phone numbers from the list to all the possibility for word combination
      @param phone : txt file for phone numbers
      @param arr : Array of words and numbers that matches each other
     */
    public static void phonenum2word(Scanner phone,String[][] arr)throws FileNotFoundException{
        //Create a new output file
        PrintWriter out = new PrintWriter("Result.txt");
        //Separate the first three and last seven digits in a phone number
        while(phone.hasNext()){
            String first3 = phone.next();
            String next7 = phone.next();
            out.println("TEL: "+first3+next7);
            out.println();
            //Trying to find a match for seven digits
            for(int i = 0;i<arr.length;i++){
                if(next7.equals(arr[i][1])){
                    out.println(next7 + ":" + arr[i][0]);
                }
            }
            //Separate the last seven into three and four
            int temp = Integer.parseInt(next7);
            String next4 = temp%10000+"";
            String next3 = temp/10000+"";
            //Find all match for 3 digits
            for(int i = 0;i<arr.length;i++){
                if(next4.equals(arr[i][1])){
                    out.println(next4 + ": " + arr[i][0]);
                }
            }
            //Find all match for 4 digits
            for(int i = 0;i<arr.length;i++){
                if(next3.equals(arr[i][1])){
                    out.println(next3 + ": " + arr[i][0]);
                }
            }
            out.println("------------------");
        }
        System.out.println(".");
        out.close();
        phone.close();
    }
}
