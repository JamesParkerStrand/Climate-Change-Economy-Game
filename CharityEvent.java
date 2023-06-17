import java.util.Scanner;

public class CharityEvent extends Card {

	public environmenthealth healthToUtilize;

	public stackEnvironment tileBussinessesToUtilize;
	
	public int moneyToUtilize;

	public void playCard(environmenthealth healthToChange, stackEnvironment tileBussinessesToChange, int moneyYouHave) {
		Scanner scanner = new Scanner(System.in);
		int charityCost = randomNumber(10, 100);
		int charityTypeInt = randomNumber(1, 4);
		String charityType = variableType[charityTypeInt - 1];
		// print out details of event for player
		System.out.println("=============================================================\n"
				+ "You have been given the opportunity to throw a charity event.");

		if (!tileBussinessesToChange.willAmountOfImpactRemoveBusiness("amountOfMoney", charityCost, 50)) {
			System.out.println("You may spend $" + charityCost + " to have a chance at increasing " + charityType
					+ ".\n" + "1. You decide to host the charity event. " + charityType + " is important!\n"
					+ "2. You decide that hosting the event is not in the cards for this year.\n"
					+ "What will you do? Type in your answer now.");
			int doEvent = pickOption(scanner, 2);
			if (doEvent == 1) {
				tileBussinessesToChange.impactTileBusinessProperties("amountOfMoney", -charityCost, -charityCost);
				int charityDoesHelp = (tileBussinessesToChange.getSumOfProperty("civility")
						- tileBussinessesToChange.currentAmountHomeless) * randomNumber(1, 10);
				int charityBonus = randomNumber(1, 10);
				if (charityDoesHelp >= 20 * tileBussinessesToChange.currentAmountHomeless) {
					System.out.println(
							"The charity was a success! Your " + charityType + " has increased by" + charityBonus
									+ "!\n" + "Your " + variableType[5] + " has decreased by " + charityCost + ".");
					if (charityTypeInt == 1) {
						healthToChange.biodiversity = healthToChange.biodiversity + charityBonus;
					} else if (charityTypeInt == 2) {
						healthToChange.waterhealth = healthToChange.waterhealth + charityBonus;
					} else if (charityTypeInt == 3) {
						tileBussinessesToChange.impactTileBusinessProperties("civility", charityBonus, charityBonus);
					} else {
						healthToChange.health = healthToChange.health + charityBonus;
					}
				} else {
					System.out.println("The charity was a flop. " + charityType + " did not increase.");
				}
			} else {
				System.out.println("You decided not to host the charity event. Nothing changes.");
			}
		} else {
			System.out.println("Unfortunately, you were too low on funds and had to decline.");
		}
		System.out.println("=============================================================");
		
		healthToUtilize = healthToChange;
		tileBussinessesToUtilize = tileBussinessesToChange;
		moneyToUtilize = moneyYouHave;
	}
	
	public environmenthealth getHealthToUtilize() {
		return healthToUtilize;
	}

	public stackEnvironment getTileBussinessesToUtilize() {
		return tileBussinessesToUtilize;
	}
	
	public int getMoneyToUtilize() {
		return moneyToUtilize;
	}
}