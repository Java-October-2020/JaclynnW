package calculatorPart1;

public class Calculator {
	
	public char operator;
	public double results;
	public double operandOne;
	public double operandTwo;
	
	public Calculator() {
		
	}

	
	public double performOperation(double operandOne, char operator, double operandTwo) {
		this.operandOne = operandOne;
		this.operandTwo = operandTwo;
		this.operator = operator;
		if(operator == '+') {
			this.results = operandOne + operandTwo;
		}
		else if(operator == '-') {
			this.results = operandOne - operandTwo;
		}
		System.out.println("The answer is " + this.results);
		return this.results;
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public double getResults() {
		return results;
	}

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	

}
