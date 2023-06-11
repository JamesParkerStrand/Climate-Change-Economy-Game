
import java.util.EmptyStackException;
import java.util.Scanner;

//ANYONE CAN MODIFY!

public class playerInterfaceJames {

	// GAME INTERFACE
	public static void main(String[] args) {

		stackEnvironment tiles = new stackEnvironment();

		Scanner s = new Scanner(System.in);

		// this variable is used to track the fact that you start with people who are
		// homeless, and depending on how much people are inside homes
		// by the home's rate of change of people going inside, it will effect this
		// variable here to go down or up. also this can never be a negative number!
		int amountOfPeopleNeededForHomes = 10;

		int moneyYouHave = 150;

		while (true) {

			// hitting start should do a push command 50 times to generate stacks!
			System.out.print("Type 'Start' to begin, or 'End' to quit program: ");
			String action = s.nextLine().toLowerCase();
			System.out.println("");

			// player has option to terminate program
			if (action.equals("end")) {
				System.out.println("Goodbye, quitter!");
				break;
			}
			if ((action.equals("start") != true) && (action.equals("end") != true)) {
				System.out.println("Invalid Input. Type 'Start' to begin, or 'End' to quit program: ");
				continue;
			}
			int turnCount = -1; // placeholder turnCount
			for (int i = 0; i > turnCount; i++) {

				if (action.equals("start")) {
					// Print initial stack sizes

					int moneySpent = tiles.doShoppingLoop(s, moneyYouHave);
					
					moneyYouHave = moneySpent;

					System.out.println(tiles.tileBusinesses);

					System.out.println("Would you like to tax all of your businesses and housing? say yes or no: ");
					// this is just a sample of having the choice to tax your citizens.
					String taxChoice = s.nextLine().toLowerCase();

					// we first check how many people we had in homes before.
					int amountOfPeopleInsideHomesBefore = tiles.getSumOfProperty("amountOfPeopleInside");

					// if any housing can't fit a population, it's going to Displace it's people,
					// causing homelessness.
					int amountGoingHomeless = tiles.checkHousingLimit(150);
					// destroys any businesses if they go on the negatives in terms of their
					// properties
					int IfAnyOtherHousingGetDestroyedDisplacingOthers = tiles.checkNegatives();

					// does the rate of change for the time
					tiles.doRateOfChanges();

					// now we check to see how many people are inside homes after.
					int amountOfPeopleInsideHomesAfter = tiles.getSumOfProperty("amountOfPeopleInside");

					// now we find the difference of change to see how people are doing in terms of
					// their housing
					int ChangeOfPopulationInHomes = amountOfPeopleInsideHomesAfter - amountOfPeopleInsideHomesBefore;

					// change the fact that the amount of people inside homes, will essentially make
					// this go down. if not this goes up.
					amountOfPeopleNeededForHomes -= ChangeOfPopulationInHomes;
					amountOfPeopleNeededForHomes += amountGoingHomeless;
					amountOfPeopleNeededForHomes += IfAnyOtherHousingGetDestroyedDisplacingOthers;

					// if amount of people homeless is a negative number, just make it zero, it
					// means we have no one homeless.
					if (amountOfPeopleNeededForHomes < 0) {
						amountOfPeopleNeededForHomes = 0;
					}

					// doing our taxes if we said yes.
					if (taxChoice.equals("yes")) {
						int amountOfBusinessTileMoneyBefore = tiles.getSumOfProperty("amountOfMoney");

						tiles.impactTileBusinessProperties("amountOfMoney", -5, -10);

						int amountOfBusinessTileMoneyAfter = tiles.getSumOfProperty("amountOfMoney");

						int amountOfMoneyYouGot = amountOfBusinessTileMoneyBefore - amountOfBusinessTileMoneyAfter;

						moneyYouHave += amountOfMoneyYouGot;

					}

					System.out.println("You! The leader of this land, you currently have: " + moneyYouHave + "$");

					System.out.println(
							"your businesses money currently have: " + tiles.getSumOfProperty("amountOfMoney") + "$");

					System.out.println("your overall civility is: " + tiles.getSumOfProperty("civility"));

					System.out.println("your overall homeless population is: " + amountOfPeopleNeededForHomes);

					System.out.println(
							"population is: " + (amountOfPeopleInsideHomesAfter + amountOfPeopleNeededForHomes));
					
					System.out.println(tiles.tileBusinesses);


				}

			}

		}
	}

}
