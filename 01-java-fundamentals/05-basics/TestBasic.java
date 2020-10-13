import java.util.ArrayList;

public class TestBasic{
	public static void countUp() {
		for(int i = 1; i<= 254; i++) {
			System.out.println(i);
		}
	}
	// print odd numbers between 1 and 255
	public static void oddNumbers() {
		for(int a = 1; a <=255; a++) {
			if(a % 2 != 0) {
				System.out.println(a);
			}
		}
	}
	//print sum 
	public static void printSum() {
		int sum = 0;
		for(int b = 0; b <= 255; b++) {
			sum += b;
			System.out.println("New number: " + b + "Sum: " + sum);
		}
		
	}
	//iterating through an array
	public static void iteratingArray() {
		int[] myArray = {1,3,5,7,9,13};
		for(int c = 0; c < myArray.length; c++) {
			System.out.println(myArray[c]);
		}		
	}
	//get average of an array
	public static int getAverageOrDieTrying() {
		int[] theArray = {2,10,3};
		int sum1 = 0;
		for(int d = 0; d < theArray.length; d++) {
			sum1 += theArray[d];
		}
		int avg = sum1/theArray.length;
		return avg;
	}
	//greater than y
	public static void greaterThanY() {
		int[] anArray = {1,2,4,20,52};
		int y = 3;
		for(int p = 0; p <= anArray.length; p++) {
			if(anArray[p] > y) {
				System.out.println(anArray[p]);
			}
		}
	}
	//square the values
	public static void squareTheValues() {
		int[] squareArray = {1,5,10};
		for(int w = 0; w <= squareArray.length; w++) {
			squareArray[w] = squareArray[w] * squareArray[w];
		}
	}
	//elminate negative numbers
	public static void elminiateNegatives() {
		int[] negArray = {-1,3,-5};
		for(int f = 0; f <= negArray.length; f++) {
			if(negArray[f] < 0) {
				negArray[f] = 0;
			}
		}
	}
	//max min and average
	public static void maxMinAvg() {
		int max = 0;
		int min = 0;
		int sum1 = 0;
		int avg1 = 0;
		int[] checkArray = {5,10,15};
		for(int s = 0; s < checkArray.length; s++) {
			if (max < checkArray[s]) {
				max = checkArray[s];
			}
			else if(min > checkArray[s]) {
				min = checkArray[s];
			}
			sum1 = sum1 + checkArray[s];
		}
		avg1 = sum1 / checkArray.length;
		int[] newArray1 = {max, min, avg1};
		System.out.println(newArray1);
	}

}