import java.util.Scanner;

public class decision {

	public stackEnvironment tileBusinessToUtilize;

	public environmenthealth healthToUtilize;

	// my idea:
	// to make this class interact with playerinterface, for everytime we call a
	// function, we then afterwards make stackenvironment =
	//--decision.stackenviornmentChanged inside of the playerinterface
	// --same with health!
	public decision(stackEnvironment tileBusinessToUtilize, environmenthealth healthToUtilize) {

		this.healthToUtilize = healthToUtilize;
		this.tileBusinessToUtilize = tileBusinessToUtilize;

	}

	/**
	 * 
	 * remember that in playerinterface, do
	 * taxoption() 1st
	 * tilebusinesses = decision.tileBusinessToUtilize; 2nd or 3rd
	 * environmentHealth = decision.healthToUtilize; 2nd or 3rd
	 * 
	 * @param scanner
	 * @param tileBusinessToUtilize
	 * @param healthToUtilize
	 * @return gives you how much money you get if you decide to tax all your businesses or not
	 */
	public int taxOption(Scanner scanner, stackEnvironment newTileBusinessesToTransForm, environmenthealth newHealthToTransForm) {
		System.out.println("Would you like to tax all of your businesses and housing? say yes or otherwise just input something else to say no: ");
		// this is just a sample of having the choice to tax your citizens.
		String taxChoice = scanner.nextLine().toLowerCase();
		
		// doing our taxes if we said yes.
		if (taxChoice.equals("yes")) {
			int amountOfBusinessTileMoneyBefore = newTileBusinessesToTransForm.getSumOfProperty("amountOfMoney");

			newTileBusinessesToTransForm.impactTileBusinessProperties("amountOfMoney", -5, -10);

			int amountOfBusinessTileMoneyAfter = newTileBusinessesToTransForm.getSumOfProperty("amountOfMoney");

			int amountOfMoneyYouGot = amountOfBusinessTileMoneyBefore - amountOfBusinessTileMoneyAfter;
			
			// change our current health and stack environment to be what we've changed		
			this.tileBusinessToUtilize = newTileBusinessesToTransForm;
			this.healthToUtilize = newHealthToTransForm;
			
			System.out.println("you have collected a total of " + amountOfMoneyYouGot + "$ for your tax money");

			// gives you amount of money
			return amountOfMoneyYouGot;

		}
		
		this.tileBusinessToUtilize = newTileBusinessesToTransForm;
		this.healthToUtilize = newHealthToTransForm;
		
		// else just return 0;
		return 0;
	}

}
