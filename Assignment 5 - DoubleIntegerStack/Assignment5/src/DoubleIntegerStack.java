public class DoubleIntegerStack {
	int[] numbers;
	int evenNumHead = 0;
	int oddNumHead = 0;
	int totEven = 0;
	int totOdd = 0;

	public DoubleIntegerStack() {
		final int SIZE = 200;

		numbers = new int[SIZE];
		evenNumHead = 0;
		oddNumHead = SIZE - 1;

	}

	public void push(int num) {
		int parity = 0;

		parity = num % 2;

		if (parity == 1) {
			numbers[oddNumHead] = num;
			oddNumHead--;
			totOdd++;
		} else {
			numbers[evenNumHead] = num;
			evenNumHead++;
			totEven++;
		}
	}

	public int popOdd() {
		int temp = numbers[oddNumHead];
		numbers[oddNumHead] = 0;
		oddNumHead++;
		totOdd--;
		return temp;
	}

	public int popEven() {
		int temp = numbers[evenNumHead];
		numbers[evenNumHead] = 0;
		evenNumHead--;
		totEven--;
		return temp;
	}

	public int getEven() {
		return numbers[evenNumHead];
	}

	public int getOdd() {
		return numbers[oddNumHead];
	}

	public int getNumEvens() {
		return totEven;
	}

	public int getNumOdds() {
		return totOdd;
	}

	public String toString() {
		String str = "";
		int cols = 0;

		// even numbers
		str += totEven + " Even numbers \n-------------------------------------"
				+ "------------------------------------------\n";
		for (int i = 0; i < totEven; i++) {
			if (cols < 10) {
				str += numbers[i] + "\t";
				cols++;
			} else {
				str += "\n" + numbers[i] + "\t";
				cols = 1;
			}
		}

		// odd numbers
		cols = 0;
		str += "\n\n" + totOdd + " Odd numbers \n-------------------------------------"
				+ "------------------------------------------\n";
		for (int i = (200 - totOdd); i < 200; i++) {
			if (cols < 10) {
				str += numbers[i] + "\t";
				cols++;
			} else {
				str += "\n" + numbers[i] + "\t";
				cols = 1;
			}
		}

		return str;
	}
}
