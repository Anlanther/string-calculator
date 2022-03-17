package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	Calculator calc;

	@BeforeEach
	public void init() {
		calc = new Calculator();
	}

	@Test
	public void testEvaluateReturnsDoubleFourWhenStringFourIsPassedIn() {
		String toCalc = "4";

		double answer = calc.evaluate(toCalc);

		assertEquals(4.0, answer, 0.0);
	}

	@Test
	public void testEvaluateReturnsDoubleFiveWhenStringFiveIsPassedIn() {
		String toCalc = "5";

		double answer = calc.evaluate(toCalc);

		assertEquals(5.0, answer, 0.0);
	}

	@Test
	public void testEvaluateReturnsDoubleFourWhenStringTwoPlusTwoIsPassedIn() {
		String toCalc = "2+2";

		double answer = calc.evaluate(toCalc);

		assertEquals(4.0, answer, 0.0);
	}

	@Test
	public void testEvaluateReturnsDoubleFiveWhenStringTwoPlusThreeIsPassedIn() {
		String toCalc = "2+3";

		double answer = calc.evaluate(toCalc);

		assertEquals(5.0, answer, 0.0);
	}

	@Test
	public void testEvaluateReturnsDoubleTenWhenStringTwoPlusThreePlusFiveIsPassedIn() {
		String toCalc = "2+3+5";

		double answer = calc.evaluate(toCalc);

		assertEquals(10.0, answer, 0.0);
	}

	@Test
	public void testEvaluateReturnsDoubleFiveWhenStringTwoPlusThreePlusFiveMinusFiveIsPassedIn() {
		String toCalc = "2+3+5-5";

		double answer = calc.evaluate(toCalc);

		assertEquals(5.0, answer, 0.0);
	}

	@Test
	public void testEvaluateReturnsDoubleNineWhenStringThreeTimesSixDividedByTwoIsPassedIn() {
		String toCalc = "3*6/2";

		double answer = calc.evaluate(toCalc);

		assertEquals(9.0, answer, 0.0);
	}

	@Test
	public void testEvaluateReturnsDoubleFourteenPointEightThreeWhenStringThreeDividedByTwoPlusThenDividedByThreeTimesFourIsPassedIn() {
		String toCalc = "3/2+10/3*4";

		double answer = calc.evaluate(toCalc);

		assertEquals(14.83, answer, 0.0);
	}

	@Test
	public void testEvaluateReturnsDoubleZeroPointOneSevenWhenStringOneDividedBySixIsPassedIn() {
		String toCalc = "1/6";

		double answer = calc.evaluate(toCalc);

		assertEquals(0.17, answer,0.0);
	}

	@Test
	public void testEvaluateReturnsZeroWhenOneDividedZeroIsPassedIn() {
		String toCalc = "1/0";

		double answer = calc.evaluate(toCalc);

		assertEquals(0, answer,0.0);
	}
}
