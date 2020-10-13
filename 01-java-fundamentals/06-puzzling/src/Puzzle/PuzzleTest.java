package Puzzle;

import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleTest {

	public static void main(String[] args) {
		Puzzle array1 = new Puzzle();
		int[] testArray1 = {3,5,1,2,7,9,8,13,25,32};
		int sum1 = array1.printTheSum(testArray1);
		System.out.println(sum1);
		System.out.println(array1.greaterThan10(testArray1));

		Puzzle array2 = new Puzzle();
		String[] testArray2 = {"Nancy","Jinichi","Fujibayashi","Momochi","Ishikawa"};
		ArrayList<String> newTestArray1 = array2.shuffleName(testArray2);
		System.out.println(newTestArray1);
		System.out.println(array2.countLetters(testArray2));
		
		Puzzle array3 = new Puzzle();
		System.out.println(array3.alphabetArray());
		
		Puzzle array4 = new Puzzle();
		System.out.println(array4.randomNumbers());
		
		Puzzle array5 = new Puzzle();
		System.out.println(array5.randomStringArray());
	}


}
