/**
-- Binary Search approched
-- 2 String array
-- Trun every int to String
 */
import java.util.*;
import java.io.*;

public class draftTwo{
  public static void main(String[] args)throws FileNotFoundException{
    int phoneNum = ( askNum() % 10000000);
    System.out.println(phoneNum);
    String[] wordsListArr = checkDigits();
    String[] numArr = stringArrToNumberArr(wordsListArr);
    checkDIgits(numArr, wordsListArr, phoneNum);//Part One && 2
  }

  public static int askNum(){
    Scanner read = new Scanner(System.in);
    System.out.println("Enter a number: ");
    String n = read.nextLine();
    String[] i = n.split(" ");
    int num = Integer.valueOf(i[1]);
    return num;
  }

  public static String[] checkDigits()throws FileNotFoundException{
    String wordsList = "";
    int count = 0;
    File myFile = new File("word_list.txt");
    Scanner input = new Scanner(myFile);
    while (input.hasNext()){
      String word = input.next();
        wordsList += word + " ";
    }
    input.close();
    String[] wordsListArr = wordsList.split(" ");
    return wordsListArr;
  }

  public static String[] stringArrToNumberArr(String[] wordsListArr)throws FileNotFoundException{
    String[] numArr = new String[wordsListArr.length];
    for(int i = 0; i < numArr.length; i ++){
      wordsListArr[i] = wordsListArr[i].toUpperCase();
      numArr[i] = stringToInt604(wordsListArr[i]);
    }
    //System.out.println("count = " + numArr[203]);
    return numArr;
  }



  public static String stringToInt(String words)throws FileNotFoundException{
    String num = "";
    for (int i = 0; i < words.length(); i ++){
      char letter = words.charAt(i);
      if(letter == 'A' || letter == 'B' || letter == 'C')
        num = num + "2";
      else if(letter =='D' || letter =='E' || letter =='F')
        num = num + "3";
      else if(letter =='G' || letter =='H' || letter =='I')
        num = num + "4";
      else if(letter =='J' || letter =='K' || letter =='L')
        num = num + "5";
      else if(letter =='M' || letter =='N' || letter =='O')
        num = num + "6";
      else if(letter =='P' || letter =='Q' || letter =='R'|| letter =='S')
        num = num + "7";
      else if(letter =='T' || letter =='U' || letter =='V')
        num = num + "8";
      else if(letter =='W' || letter =='X' || letter =='Y'|| letter =='Z')
        num = num + "9";
    }
    return num;
  }

  public static void checkDIgits(String[]numArr, String[]wordsListArr, int phoneNum)throws FileNotFoundException{
    int firstThree = phoneNum / 10000;
    int lastFour = phoneNum % 10000;
    File myFile = new File("output.txt");
    PrintWriter outPut = new PrintWriter(myFile);
    for (int i = 0; i < numArr.length; i ++){
      if (numArr[i].equals( phoneNum )){
        outPut.println(wordsListArr[i]);
      }
    }
    for (int i = 0; i < numArr.length; i ++){
      if (numArr[i].equals( firstThree )){
        outPut.println(firstThree + ": " + wordsListArr[i]);
      }
    }
    for (int i = 0; i < numArr.length; i ++){
      if (numArr[i].equals( lastFour )){
        outPut.println(lastFour + ": " + wordsListArr[i]);
      }
    }
    outPut.close();
  }

}//end of the whole program
