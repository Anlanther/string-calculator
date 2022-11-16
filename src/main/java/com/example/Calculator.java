package com.example;

import java.util.Arrays;

public class Calculator {
	private double answer = 0.0;
	private boolean errorFlag = false;

	public double evaluate(String toCalc) {
		answer = 0;
		// List with just numbers
		String[] numbers = toCalc.split("[^0-9]");
		// List with just symbols
		String[] regEx = toCalc.replaceAll("[0-9]", "").split("");
		// New list of length numbers and symbols for calculation
		String[] numInput = new String[(numbers.length + regEx.length)];
		// Sorted equation array
		String[] calcInput = organiseCalcArray(numbers, regEx, numInput);


		calcInput = doOperators(calcInput, "/");

		if (!errorFlag) {
			calcInput = doOperators(calcInput, "*");
			calcInput = doOperators(calcInput, "-");
			calcInput = doOperators(calcInput, "+");
		}

		if (numbers.length == 1) {
			answer = Double.parseDouble(toCalc);
		}

		double roundOff = Math.round(answer * 100.0) / 100.0;
		return roundOff;
	}

	private String[] doOperators(String[] calcInput, String symbol) {
		while (Arrays.toString(calcInput).contains(symbol)) {
			for (int i = 0; i < calcInput.length; i++) {
				String curString = calcInput[i];

				if (curString.equals(symbol)) {
					double num1 = Double.parseDouble(calcInput[i - 1]);
					double num2 = Double.parseDouble(calcInput[i + 1]);

					answer = changeAnswer(answer, symbol, num1, num2);
					calcInput[i - 1] = Double.toString(answer);
					calcInput = shiftNumbers(i, calcInput);
					break;
				}
			}
		}
		return calcInput;
	}

	private double changeAnswer(double answer, String symbol, double leftNo, double rightNo) {
		if (symbol.equals("/")) {
			if (rightNo == 0) {
				answer = 0;
				errorFlag = true;
				System.out.println("Answer is undefined.");
			} else {
				answer = leftNo / rightNo;
			}
		} else if (symbol.equals("*")) {
			answer = leftNo * rightNo;
		} else if (symbol.equals("+")) {
			answer = leftNo + rightNo;
		} else {
			answer = leftNo - rightNo;
		}
		return answer;
	}

	private String[] shiftNumbers(int i, String[] calcInput) {
		// Shifts all code to the left and replaces end with a
		for (int shift = 0; shift <= calcInput.length - i - 3; shift++) {
			calcInput[i + shift] = calcInput[i + shift + 2];
		}
		calcInput[calcInput.length - 1] = "a";
		calcInput[calcInput.length - 2] = "a";
		return calcInput;
	}

	private String[] organiseCalcArray(String[] numbers, String[] regEx, String[] numInput) {
		int numberIndex = 0;
		int regIndex = 0;

		for (int i = 0; i < numInput.length; i++) {
			if (i == 0) {
				numInput[i] = numbers[numberIndex];
				numberIndex++;
				continue;
			}
			if (i % 2 == 0) {
				numInput[i] = numbers[numberIndex];
				numberIndex++;
				continue;
			}
			if (i % 2 != 0) {
				numInput[i] = regEx[regIndex];
				regIndex++;
				continue;
			}
		}
		return numInput;
	}
}
