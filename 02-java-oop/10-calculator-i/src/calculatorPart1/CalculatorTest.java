package calculatorPart1;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator addition = new Calculator();
		Calculator subtraction = new Calculator();
		
		addition.performOperation(10.5, '+', 5.2);
		subtraction.performOperation(10.5, '-', 5.2);

	}

}
