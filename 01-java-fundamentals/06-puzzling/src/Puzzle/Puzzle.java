package Puzzle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Puzzle {
	//print the sum
	public int printTheSum(int[] sumArray) {
		int sum1 = 0;
		for(int a = 0; a < sumArray.length; a++) {
			sum1 = sum1 + sumArray[a];
		}
		return sum1;
	}
	public ArrayList<Integer> greaterThan10(int[] sumArray1) {
		ArrayList<Integer> newArray1 = new ArrayList<Integer>();
		for(int b = 0; b < sumArray1.length; b++) {
			if(sumArray1[b] > 10) {
				newArray1.add(sumArray1[b]);				
			}
		}
		return newArray1;
	}
	public ArrayList<String> shuffleName(String[] nameArray1){
		ArrayList<String> nameArray1Random = new ArrayList<>();
		for(int c = nameArray1.length - 1; c >= 0; c--) {
			nameArray1Random.add(nameArray1[c]);		
		}
		return nameArray1Random;		
	}
	public ArrayList<String> countLetters(String[] nameArray2) {
		ArrayList<String> lettersName = new ArrayList<>();
		for(int d = 0; d < nameArray2.length; d++) {
			if(nameArray2[d].length() > 5) {
				lettersName.add(nameArray2[d]);
			}
		}
		return lettersName;
	}
	public ArrayList<Character> alphabetArray(){
		ArrayList<Character> alphabet = new ArrayList<Character>();
		for(char ch = 'a'; ch <= 'z'; ++ch) {
			alphabet.add(ch);
		}
		Collections.shuffle(alphabet);
		if((alphabet.get(0) == 'a') || (alphabet.get(0) == 'e') || (alphabet.get(0) == 'i') || (alphabet.get(0) == 'o') || (alphabet.get(0) == 'u') || (alphabet.get(0) == 'y')) {
			System.out.println("The first letter is a vowel");
		}
		System.out.println(alphabet.get(alphabet.size()- 1));
		System.out.println(alphabet.get(0));
		return alphabet;
	}
	public ArrayList<Integer> randomNumbers(){
		Random rNum = new Random();		
		ArrayList<Integer> randomNumbers1 = new ArrayList<Integer>();
		int maxI = 0;
		int minI = 0;		
		for(int e = 1; e <= 10; e++) {
			int rand = Math.abs((55) + rNum.nextInt(255));
			randomNumbers1.add(rand);
			minI = randomNumbers1.get(0);
			if(maxI < rand) {
				maxI = rand;
			}
			else if (minI > rand ) {
				minI = rand;
			}
		}
		Collections.sort(randomNumbers1);
		System.out.println("The max value is " + maxI);
		System.out.println("The min value is " + minI);
		return randomNumbers1;
	}
	public String randomString(){
		String charOptions = "abcdefghijklmnopqrstuvwxzy1234567890";
		Random rNum1 = new Random();
		StringBuilder rString = new StringBuilder();
		for(int f = 1; f <= 5; f++) {
			rString.append(charOptions.charAt(rNum1.nextInt(charOptions.length())));
		}
		return rString.toString();

	}
	public ArrayList<String> randomStringArray(){
		ArrayList<String> rStringArray = new ArrayList<String>();
		for(int g = 1; g <=10; g++ ) {
			rStringArray.add(randomString());
		}
		return rStringArray;
	}
	
	

}
