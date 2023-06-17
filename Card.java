import java.util.Scanner;

public abstract class Card {
	String[] variableType = new String[] { "BIODIVERSITY", "WATER HEALTH", "HAPPINESS", "HEALTH POPULATION", "INCOME", "BUDGET" };

	public environmenthealth healthToUtilize;

	public stackEnvironment tileBussinessesToUtilize;
	
	public int moneyToUtilize;

	public abstract void playCard(environmenthealth healthToChange, stackEnvironment tileBussinessesToChange, int moneyYouHave);

	public static int randomNumber(int min, int max) {
		int randomInt = (int) Math.floor(Math.random() * (max) + min);
		return randomInt;
	}

	public int pickOption(Scanner input, int max) {
		int testNumber = 0;
		while (testNumber <= 0 || testNumber > max) {
			// This while loop will continue until the test number is a non-zero.
			if (input.hasNextInt()) {
				testNumber = input.nextInt();
				if (testNumber > 0 && testNumber <= max) {
					// With these if statements, the test number will only become non-zero if it is
					// a valid integer.
					input.nextLine();
					// return int within range (1-max)
					return testNumber;
				} else {
					System.out.println("That was not a valid number! Please try again.");
					input.nextLine();
				}
			} else {
				// yell at user if not one of the options, ask for new input
				System.out.println("That was not a valid number! Please try again.");
				input.nextLine();
			}
		}
		return 0;
	}

	public abstract environmenthealth getHealthToUtilize(); 

	public abstract stackEnvironment getTileBussinessesToUtilize();
	
	public abstract int getMoneyToUtilize();


}