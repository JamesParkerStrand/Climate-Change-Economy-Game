
import java.util.EmptyStackException;

import java.util.Scanner;
import java.util.Random;

//ANYONE CAN MODIFY!

public class playerInterfaceJames {
	
	final static int STATISTICAL_LIMIT_FOR_ENVIROMNENT_HEALTH = 1000;
	
	final static int STATISTICAL_LIMIT_FOR_HEALTH_POPULATION = 10000;

	// GAME INTERFACE
	public static void main(String[] args) {

		stackEnvironment tiles = new stackEnvironment();

		environmenthealth health = new environmenthealth();

		decision options = new decision(tiles, health);

		Deck cardPlayOut = new Deck();

		Scanner s = new Scanner(System.in);

		// this variable is used to track the fact that you start with people who are
		// homeless, and depending on how much people are inside homes
		// by the home's rate of change of people going inside, it will effect this
		// variable here to go down or up. also this can never be a negative number!
		int amountOfPeopleNeededForHomes = 10;

		double amountOfWater = 1000;

		int moneyYouHave = 150;
		
		boolean isGameOver = false;

		while (!isGameOver) {

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

					int moneySpent = tiles.doShoppingLoop(s, moneyYouHave);

					moneyYouHave = moneySpent;

					// this is just a sample of having the choice to tax your citizens.

					// we first check how many people we had in homes before.
					int amountOfPeopleInsideHomesBefore = tiles.getSumOfProperty("amountOfPeopleInside");

					// does the rate of change for the time
					tiles.doRateOfChanges();

					// if any housing can't fit a population, it's going to Displace it's people,
					// causing homelessness.
					int amountGoingHomeless = tiles.checkHousingLimit(150);
					
					// destroys any businesses if they go on the negatives in terms of their
					// properties
					int IfAnyOtherHousingGetDestroyedDisplacingOthers = tiles.checkNegatives();

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

					tiles.currentAmountHomeless = amountOfPeopleNeededForHomes;

					/**
					 * this is the usage of a tax option of the options class
					 */
					int taxMoneyYouCollect = options.taxOption(s, tiles, health);

					// change our current health and tiles after our taxes.
					health = options.healthToUtilize;
					tiles = options.tileBusinessToUtilize;

					moneyYouHave += taxMoneyYouCollect;

					Random random = new Random();

					// 1 out of 5 chance of card picking event happening.
					int randomChanceOfCardsPlayingOut = random.nextInt(6);

					// if our chance it hit, we play the cards!
					if (randomChanceOfCardsPlayingOut == 1) {
						// This is where we play our card options.
						cardPlayOut.tileBussinessesToUtilize = tiles;
						cardPlayOut.healthToUtilize = health;
						cardPlayOut.moneyToUtilize = moneyYouHave;

						cardPlayOut.playCard(moneyYouHave);

						health = cardPlayOut.healthToUtilize;
						tiles = cardPlayOut.tileBussinessesToUtilize;
						moneyYouHave = cardPlayOut.moneyToUtilize;
						
						System.out.println("feel free to look at the text and scroll around, then input anything, then press enter to continue!");
						
						s.nextLine();
					}
					
					/**
					 * You have reached the point in which you are printing out all available
					 * variables. and making impacts
					 */
					int amountOfMoney = tiles.getSumOfProperty("amountOfMoney");

					int civility = tiles.getSumOfProperty("civility");

					int amountOfPeopleInside = tiles.getSumOfProperty("amountOfPeopleInside");

					int negativeImpact;
					// increases happiness of environmenthealth.
					
					// if you see that numberOfEmployees < ( amountOfPeopleInside + amountOfPeopleNeededForHomes) <-- current population, subtract happiness
					//-- by doing int negativeImpact = numberOfEmployees - ( amountOfPeopleInside + amountOfPeopleNeededForHomes)
					//-- then do tiles.impactTileBusinessProperties("amountOfMoney", "Housing" <-- our filtering, negativeImpact,negativeImpact);
					int numberOfEmployees = tiles.getSumOfProperty("numberOfEmployees");
					negativeImpact = numberOfEmployees-(amountOfPeopleInside+amountOfPeopleNeededForHomes);;
					if(negativeImpact<0) {	
						health.happiness = health.happiness+negativeImpact;
						tiles.impactTileBusinessProperties("amountOfMoney","Housing",negativeImpact,negativeImpact);
					}
					// keep adding this variable up in the environment health's carbon variable
					int amountOfCarbonRelase = tiles.getSumOfProperty("amountOfCarbonRelase");
						health.amountOfCarbon=amountOfCarbonRelase+health.amountOfCarbon;
						
					// subtract the health of the population and happiness ((environmenthealth)) if
					//-- 10 / (amountOfPowerProduced - ( amountOfPeopleInside + amountOfPeopleNeededForHomes) ) < 0
					//--meaning we aren't producing enough food to sustain the population.
					int amountOfPowerProduced = tiles.getSumOfProperty("amountOfPowerProduced");
					negativeImpact = amountOfPowerProduced - (amountOfPeopleInside+amountOfPeopleNeededForHomes);
					if(negativeImpact<0) {
						health.health = health.health+negativeImpact; 
            health.happiness = health.happiness+negativeImpact;
					}
					// subtracts water health
					int amountOfWaterPollution = tiles.getSumOfProperty("amountOfWaterPollution");
					health.waterhealth=health.waterhealth-amountOfWaterPollution;
					health.biodiversity= health.biodiversity-(amountOfWaterPollution/2);
					
					// subtract the health of the population ((environmenthealth)) if
					//--(AmountOfFoodProduced - ( amountOfPeopleInside + amountOfPeopleNeededForHomes
					//--) ) < 0
					//--meaning we aren't producing enough food to sustain the population.
					int AmountOfFoodProduced = tiles.getSumOfProperty("AmountOfFoodProduced");
					negativeImpact = AmountOfFoodProduced-(amountOfPeopleInside+amountOfPeopleNeededForHomes);
					if(negativeImpact<0) {
						health.health=health.health+negativeImpact;
					}
					// subtract to enviroment health's water health.
					int amountOfWaterDraining = tiles.getSumOfProperty("amountOfWaterDraining");
					health.waterhealth = health.waterhealth-amountOfWaterDraining;
					health.biodiversity= health.biodiversity-(amountOfWaterDraining/2);
					// add to environment health's water health.
					int amountOfWaterBeingReplenished = tiles.getSumOfProperty("amountOfWaterBeingReplenished");
					health.waterhealth=health.waterhealth+amountOfWaterBeingReplenished;
					health.biodiversity= health.biodiversity+(amountOfWaterBeingReplenished/2);
					
					// allows us to get the amount of businesses we bought.
					int sizeOfBusiness = tiles.getAmountOfABusinessTile("Business");
					health.happiness+=sizeOfBusiness * 5;					
					int sizeOfHousing = tiles.getAmountOfABusinessTile("Housing");
					health.happiness+=sizeOfHousing * 5;					
					int sizeOfFossilFuels = tiles.getAmountOfABusinessTile("Fossil Fuels");
					health.waterhealth-=sizeOfFossilFuels;
					health.amountOfCarbon+=sizeOfFossilFuels;
					int sizeOfNuclearPower = tiles.getAmountOfABusinessTile("Nuclear Power");
					int sizeOfSolarPower = tiles.getAmountOfABusinessTile("Solar Power");
					int sizeOfWindPower = tiles.getAmountOfABusinessTile("Wind Power");
					int sizeOfNaturalGas = tiles.getAmountOfABusinessTile("Natural Gas");
					health.amountOfCarbon+=sizeOfNaturalGas;
					int sizeOfWaterPower = tiles.getAmountOfABusinessTile("Water Power");
					int sizeOfMiningBusiness = tiles.getAmountOfABusinessTile("Mining Business");
					health.waterhealth-=sizeOfMiningBusiness;
					health.biodiversity = health.biodiversity- ( (sizeOfMiningBusiness) / 10 );
					// make these food businesses drain population's health if we have zero food
					// produced.
					int sizeOfFarmRanch = tiles.getAmountOfABusinessTile("Farm Ranch");
					
					// make these food businesses drain population's health if we have zero food
					// produced.
					int sizeOfPlantFarms = tiles.getAmountOfABusinessTile("Plant Farms");
					health.biodiversity = health.biodiversity-(sizeOfPlantFarms+sizeOfFarmRanch)/10;
					// make this variable play into the fact that this decreases the health variable
					// inside of environment health class. hint just use this size variable to
					// multiply the impact
					int sizeOfJunkFoodBusiness = tiles.getAmountOfABusinessTile("Junk Food Business");
					health.health= health.health-(sizeOfJunkFoodBusiness * 2);
					
					int sizeOfWaterTreatment = tiles.getAmountOfABusinessTile("Water Treatment");
					
					health.waterhealth=health.waterhealth+sizeOfWaterTreatment;
					
					// drain more water based on population
					health.waterhealth = health.waterhealth - (amountOfPeopleInside+amountOfPeopleNeededForHomes);
					
					if(health.amountOfCarbon > STATISTICAL_LIMIT_FOR_ENVIROMNENT_HEALTH) {
						isGameOver = true;
						break;
					}
					
					if(health.biodiversity < 0 || health.health < 0 || health.waterhealth < 0 || health.happiness < 0) {
						isGameOver = true;
						break;
					}
					
					if(health.biodiversity > STATISTICAL_LIMIT_FOR_ENVIROMNENT_HEALTH) {
						health.biodiversity = STATISTICAL_LIMIT_FOR_ENVIROMNENT_HEALTH;
					}
					
					if(health.waterhealth > STATISTICAL_LIMIT_FOR_ENVIROMNENT_HEALTH) {
						health.waterhealth = STATISTICAL_LIMIT_FOR_ENVIROMNENT_HEALTH;
					}
					
					if(health.happiness > STATISTICAL_LIMIT_FOR_ENVIROMNENT_HEALTH) {
						health.happiness = STATISTICAL_LIMIT_FOR_ENVIROMNENT_HEALTH;
					}
					
					if(health.health > STATISTICAL_LIMIT_FOR_HEALTH_POPULATION) {
						health.health = STATISTICAL_LIMIT_FOR_HEALTH_POPULATION;
					}
					
					System.out.println("Current Homeless Population: " + amountOfPeopleNeededForHomes);
					System.out.println("Current Population Housed: " + amountOfPeopleInside);
					System.out.println("Current Population: " + (amountOfPeopleInside + amountOfPeopleNeededForHomes));
					System.out.println("Amount of Money: " + amountOfMoney);
					System.out.println("Civility: " + civility);
					System.out.println("Amount of People Inside: " + amountOfPeopleInside);
					System.out.println("Number of Employees: " + numberOfEmployees);
					System.out.println("Amount of Carbon Release: " + amountOfCarbonRelase);
					System.out.println("Amount of Power Produced: " + amountOfPowerProduced);
					System.out.println("Amount of Water Pollution: " + amountOfWaterPollution);
					System.out.println("Amount of Food Produced: " + AmountOfFoodProduced);
					System.out.println("Amount of Water Draining: " + amountOfWaterDraining);
					System.out.println("Amount of Water Being Replenished: " + amountOfWaterBeingReplenished);
					
					System.out.println(" ");
					
					
					System.out.println("Size of Business: " + sizeOfBusiness);
					System.out.println("Size of Housing: " + sizeOfHousing);
					System.out.println("Size of Fossil Fuels: " + sizeOfFossilFuels);
					System.out.println("Size of Nuclear Power: " + sizeOfNuclearPower);
					System.out.println("Size of Solar Power: " + sizeOfSolarPower);
					System.out.println("Size of Wind Power: " + sizeOfWindPower);
					System.out.println("Size of Natural Gas: " + sizeOfNaturalGas);
					System.out.println("Size of Water Power: " + sizeOfWaterPower);
					System.out.println("Size of Mining Business: " + sizeOfMiningBusiness);
					System.out.println("Size of Farm Ranch: " + sizeOfFarmRanch);
					System.out.println("Size of Plant Farms: " + sizeOfPlantFarms);
					System.out.println("Size of Junk Food Business: " + sizeOfJunkFoodBusiness);
					System.out.println("Size of Water Treatment: " + sizeOfWaterTreatment);
					
					System.out.println(" ");
					
					System.out.println("Amount of carbon : " + health.amountOfCarbon + "/1000");
					System.out.println("BioDiversity Health : " + health.biodiversity + "/1000");
					System.out.println("Happiness of citizens : " + health.happiness + "/1000");
					System.out.println("Health of the population : " + health.health + "/10000");
					System.out.println("Amount of drinkable water : " + health.waterhealth + "/1000");
					
					System.out.println(" ");
					
					System.out.println("feel free to look at your stats and scroll around, then input anything, then press enter to continue!");
					
					s.nextLine();

				}

			}

		}
	}

}
