import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class stackEnvironment {

	// this will track how many businesses get lost at a time, and if you lose too
	// many at a time civility goes WAY down.
	public int businessesLost;

	// this will track how much housing gets lost for people at a time, and if you
	// lose too at a time many civility goes WAY down.
	public int housingLosses;

	public int currentAmountHomeless;

	// note, when making the int[] properties, make sure you are also creating index
	// -properties for the rate of change for every other property. otherwise things
	// -break!
	Stack<HashMap<String, Integer>> tileBusinesses = new Stack<HashMap<String, Integer>>();

	// ignore num, that is a test parameter, just remove it when finally doing some
	// changes we want.
	public void addTileBusiness(int num) {

		HashMap<String, Integer> newBusiness = new HashMap<String, Integer>();

		newBusiness.put("Business", null);

		newBusiness.put("amountOfMoney", num);

		newBusiness.put("numberOfEmployees", 0);

		newBusiness.put("civility", 0);

		newBusiness.put("RATEOFcivility", 10);

		newBusiness.put("RATEOFamountOfMoney", 10);

		newBusiness.put("RATEOFnumberOfEmployees", 10);

		tileBusinesses.add(newBusiness);
	}

	public void addHousing() {

		HashMap<String, Integer> newHousing = new HashMap<String, Integer>();

		newHousing.put("Housing", null);

		newHousing.put("amountOfPeopleInside", 0);

		newHousing.put("amountOfMoney", 0);

		newHousing.put("civility", 0);

		newHousing.put("RATEOFcivility", 10);

		newHousing.put("RATEOFamountOfMoney", 10);

		newHousing.put("RATEOFamountOfPeopleInside", 10);
		
		tileBusinesses.add(newHousing);

	}

	public void addFossilFuels() {
		HashMap<String, Integer> newBusiness = new HashMap<String, Integer>();

		newBusiness.put("Fossil Fuels", null);

		newBusiness.put("amountOfMoney", 0);

		newBusiness.put("numberOfEmployees", 0);

		newBusiness.put("amountOfCarbonRelase", 20);

		newBusiness.put("amountOfPowerProduced", 100);

		newBusiness.put("civility", 0);

		newBusiness.put("RATEOFcivility", 10);

		newBusiness.put("RATEOFamountOfMoney", 10);

		newBusiness.put("RATEOFnumberOfEmployees", 10);
		
		tileBusinesses.add(newBusiness);

	}

	public void addNuclearPower() {

		HashMap<String, Integer> newBusiness = new HashMap<String, Integer>();

		newBusiness.put("Nuclear Power", null);

		newBusiness.put("amountOfMoney", 0);

		newBusiness.put("numberOfEmployees", 0);

		newBusiness.put("amountOfPowerProduced", 50);
		
		newBusiness.put("civility", 0);

		newBusiness.put("RATEOFcivility", 10);

		newBusiness.put("RATEOFamountOfMoney", 10);

		newBusiness.put("RATEOFnumberOfEmployees", 10);
		
		tileBusinesses.add(newBusiness);

	}

	public void addSolar() {

		HashMap<String, Integer> newBusiness = new HashMap<String, Integer>();

		newBusiness.put("Solar Power", null);

		newBusiness.put("amountOfMoney", 0);

		newBusiness.put("numberOfEmployees", 0);

		newBusiness.put("amountOfPowerProduced", 30);
		
		newBusiness.put("civility", 0);

		newBusiness.put("RATEOFcivility", 10);

		newBusiness.put("RATEOFamountOfMoney", 10);

		newBusiness.put("RATEOFnumberOfEmployees", 10);
		
		tileBusinesses.add(newBusiness);

	}

	public void addWindPower() {

		HashMap<String, Integer> newBusiness = new HashMap<String, Integer>();

		newBusiness.put("Wind Power", null);

		newBusiness.put("amountOfMoney", 0);

		newBusiness.put("numberOfEmployees", 0);

		newBusiness.put("amountOfPowerProduced", 20);
		
		newBusiness.put("civility", 0);

		newBusiness.put("RATEOFcivility", 10);

		newBusiness.put("RATEOFamountOfMoney", 10);

		newBusiness.put("RATEOFnumberOfEmployees", 10);
		
		tileBusinesses.add(newBusiness);

	}

	public void addNaturalGas() {

		HashMap<String, Integer> newBusiness = new HashMap<String, Integer>();

		newBusiness.put("Natural Gas", null);

		newBusiness.put("amountOfMoney", 0);

		newBusiness.put("numberOfEmployees", 0);

		newBusiness.put("amountOfPowerProduced", 60);

		newBusiness.put("amountOfCarbonRelase", 20);

		newBusiness.put("amountOfWaterPollution", 30);
		
		newBusiness.put("civility", 0);

		newBusiness.put("RATEOFcivility", 10);

		newBusiness.put("RATEOFamountOfMoney", 10);

		newBusiness.put("RATEOFnumberOfEmployees", 10);
		
		tileBusinesses.add(newBusiness);

	}

	public void addWaterPower() {

		HashMap<String, Integer> newBusiness = new HashMap<String, Integer>();

		newBusiness.put("Water Power", null);

		newBusiness.put("amountOfMoney", 0);

		newBusiness.put("numberOfEmployees", 0);

		newBusiness.put("amountOfPowerProduced", 35);
		
		newBusiness.put("civility", 0);

		newBusiness.put("RATEOFcivility", 10);

		newBusiness.put("RATEOFamountOfMoney", 10);

		newBusiness.put("RATEOFnumberOfEmployees", 10);
		
		tileBusinesses.add(newBusiness);

	}

	public void addMining() {

		HashMap<String, Integer> newBusiness = new HashMap<String, Integer>();

		newBusiness.put("Mining Business", null);

		newBusiness.put("amountOfMoney", 0);

		newBusiness.put("numberOfEmployees", 0);

		newBusiness.put("economyMoneyBooster", 50);

		newBusiness.put("amountOfCarbonRelase", 40);
		
		newBusiness.put("civility", 0);

		newBusiness.put("RATEOFcivility", 10);

		newBusiness.put("RATEOFamountOfMoney", 10);

		newBusiness.put("RATEOFnumberOfEmployees", 10);
		
		tileBusinesses.add(newBusiness);

	}

	public void addFarmRanch(int amountWaterDraining) {

		HashMap<String, Integer> newBusiness = new HashMap<String, Integer>();

		newBusiness.put("Farm Ranch", null);

		newBusiness.put("amountOfMoney", 0);

		newBusiness.put("numberOfEmployees", 0);

		newBusiness.put("AmountOfFoodProduced", 50);

		newBusiness.put("amountOfCarbonRelase", 40);

		// could be used to buy certain ways cows are raised.
		newBusiness.put("amountOfWaterDraining", amountWaterDraining);
		
		newBusiness.put("civility", 0);

		newBusiness.put("RATEOFcivility", 10);

		newBusiness.put("RATEOFamountOfMoney", 10);

		newBusiness.put("RATEOFnumberOfEmployees", 10);
		
		tileBusinesses.add(newBusiness);

	}

	// think of things like corn, apples, fruits, vegetables etc.
	public void addFarmPlants() {

		HashMap<String, Integer> newBusiness = new HashMap<String, Integer>();

		newBusiness.put("Farm Ranch", null);

		newBusiness.put("amountOfMoney", 0);

		newBusiness.put("numberOfEmployees", 0);

		newBusiness.put("AmountOfFoodProduced", 50);

		newBusiness.put("amountOfWaterDraining", 70);
		
		newBusiness.put("civility", 0);

		newBusiness.put("RATEOFcivility", 10);

		newBusiness.put("RATEOFamountOfMoney", 10);

		newBusiness.put("RATEOFnumberOfEmployees", 10);
		
		tileBusinesses.add(newBusiness);

	}

	public void addWaterTreatment() {

		HashMap<String, Integer> newBusiness = new HashMap<String, Integer>();

		newBusiness.put("Water Treatment", null);

		newBusiness.put("amountOfMoney", 0);

		newBusiness.put("numberOfEmployees", 0);

		newBusiness.put("amountOfWaterBeingReplenished", 60);
		
		newBusiness.put("civility", 0);

		newBusiness.put("RATEOFcivility", 10);

		newBusiness.put("RATEOFamountOfMoney", 10);

		newBusiness.put("RATEOFnumberOfEmployees", 10);
		
		tileBusinesses.add(newBusiness);

	}

	// if a certain population is going over living population limit in housing,
	// it's going to return am integer of how many people are left.
	public int checkHousingLimit(int limitOfPeopleInHouses) {

		int currentSize = tileBusinesses.size();

		int amountHomeless = 0;

		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			if (currentStack.containsKey("Housing")
					&& currentStack.get("amountOfPeopleInside") > limitOfPeopleInHouses) {

				int amountOfPeopleDisplaced = currentStack.get("amountOfPeopleInside") - limitOfPeopleInHouses;

				currentStack.replace("amountOfPeopleInside", limitOfPeopleInHouses);

				amountHomeless += amountOfPeopleDisplaced;

			}

			tileBusinesses.set(i, currentStack);

		}

		return amountHomeless;
	}

	// this is used to essentially remove any business that manages to go into any
	// negatives, since that means that it has effectively been destroyed

	// the @return gives you the amount of people who will go homeless, if the
	// housing money is negative.
	public int checkNegatives() {

		int currentSize = tileBusinesses.size();

		int currentRemoved = 0;

		int amountHomeless = 0;

		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i - currentRemoved);

			if (currentStack.containsKey("Housing")) {

				int amountOfMoneySustainableForHousing = currentStack.get("amountOfMoney");

				int amountOfPeopleLivingInside = currentStack.get("amountOfPeopleInside");

				if (amountOfPeopleLivingInside < 0) {
					tileBusinesses.remove(i - currentRemoved);
					housingLosses++;
					currentRemoved++;
					continue;
				}

				if (amountOfMoneySustainableForHousing < 0) {
					amountHomeless += currentStack.get("amountOfPeopleInside");
					tileBusinesses.remove(i - currentRemoved);
					housingLosses++;
					currentRemoved++;
					continue;
				}

			}

			for (String propertyname : currentStack.keySet()) {

				if (currentStack.get(propertyname) != null && currentStack.get(propertyname) < 0
						&& !propertyname.contains("RATEOF")) {

					tileBusinesses.remove(i - currentRemoved);
					businessesLost++;
					currentRemoved++;
					break;

				}

			}

		}

		return amountHomeless;
	}

	public void doRateOfChanges() {

		int currentSize = tileBusinesses.size();

		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			for (String currentPropertyOfChange : currentStack.keySet()) {

				if (currentPropertyOfChange.contains("RATEOF")) {

					String lookForRateOfProperty = currentPropertyOfChange.substring(6);

					int currentNumberOfProperty = currentStack.get(lookForRateOfProperty);

					int currentRateOfProperty = currentStack.get(currentPropertyOfChange);

					currentStack.replace(lookForRateOfProperty, currentNumberOfProperty + currentRateOfProperty);

				}

			}

			tileBusinesses.set(i, currentStack);

		}

	}

	// allows you to loop through all businesses for a certain property in order to
	// sum something up like amount of money the tiles have
	public int getSumOfProperty(String PropertyToLookFor) {

		int currentSize = tileBusinesses.size();

		int sumOfProperty = 0;

		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			if (currentStack.containsKey(PropertyToLookFor)) {

				sumOfProperty = sumOfProperty + currentStack.get(PropertyToLookFor);

			}

		}

		return sumOfProperty;

	}
	
	// allows you to filter out what business type you want to get sum of! same method as above
	public int getSumOfProperty(String PropertyToLookFor, String BusinessTypeFiltering) {

		int currentSize = tileBusinesses.size();

		int sumOfProperty = 0;

		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			if (currentStack.containsKey(PropertyToLookFor) && currentStack.containsKey(BusinessTypeFiltering)) {

				// if you otherwise try to use BusinessTypeFiltering as a second property, you can't do that
				if(currentStack.get(BusinessTypeFiltering) != null) {
					break;
				}
				
				sumOfProperty = sumOfProperty + currentStack.get(PropertyToLookFor);

			}

		}

		return sumOfProperty;

	}
	

	// allows you to loop through all business tiles, and then change the number of
	// a certain property. for example you might want to say that
	// a decision lead to your businesses losing some money.
	public void impactTileBusinessProperties(String PropertyToLookFor, int minimumRangeOfAmountToGiveOrTake,
			int maximumRangeOfAmountToGiveOrTake) {

		int currentSize = tileBusinesses.size();

		Random random = new Random();

		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			if (currentStack.containsKey(PropertyToLookFor)) {

				int randomGiveOrTake = minimumRangeOfAmountToGiveOrTake
						+ random.nextInt(maximumRangeOfAmountToGiveOrTake - minimumRangeOfAmountToGiveOrTake);

				currentStack.put(PropertyToLookFor, currentStack.get(PropertyToLookFor) + randomGiveOrTake);

			}

			tileBusinesses.set(i, currentStack);

		}

	}
	
	// this is the same thing, except you can filter this out by business type too.
	public void impactTileBusinessProperties(String PropertyToLookFor, String BusinessTypeFiltering,int minimumRangeOfAmountToGiveOrTake,
			int maximumRangeOfAmountToGiveOrTake) {

		int currentSize = tileBusinesses.size();

		Random random = new Random();

		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			if ( currentStack.containsKey(PropertyToLookFor) && currentStack.containsKey(BusinessTypeFiltering) ) {
				
				// if you otherwise try to use BusinessTypeFiltering as a second property, you can't do that
				if(currentStack.get(BusinessTypeFiltering) != null) {
					break;
				}

				int randomGiveOrTake = minimumRangeOfAmountToGiveOrTake
						+ random.nextInt(maximumRangeOfAmountToGiveOrTake - minimumRangeOfAmountToGiveOrTake);

				currentStack.put(PropertyToLookFor, currentStack.get(PropertyToLookFor) + randomGiveOrTake);

			}

			tileBusinesses.set(i, currentStack);

		}

	}

	public void doDisaster() {

		int currentSize = tileBusinesses.size();

		Random random = new Random();

		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			for (String currentProperty : currentStack.keySet()) {

				if (currentStack.get(currentProperty) != null && currentProperty.contains("RATEOF")) {

					int maxIntensity = 20;

					int minIntensity = 10;

					int randomDamage = random.nextInt(maxIntensity - minIntensity) + minIntensity;

					currentStack.replace(currentProperty, currentStack.get(currentProperty) - randomDamage);

					continue;

				}

				if (currentStack.get(currentProperty) != null) {

					int maxIntensity = 100;

					int minIntensity = 50;

					int randomDamage = random.nextInt(maxIntensity - minIntensity) + minIntensity;

					currentStack.replace(currentProperty, currentStack.get(currentProperty) - randomDamage);

				}

			}

			tileBusinesses.set(i, currentStack);
		}

	}
	
	// allows you to track the amount of a certain businesses you bought, or how much the amount of the businesses tile
	//- you have after a simulation wiped it out
	public int getAmountOfABusinessTile(String TileBusinessToLookFor) {
		
		int currentSize = tileBusinesses.size();
		
		int amountOfBusinessTile = 0;

		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			if (currentStack.containsKey(TileBusinessToLookFor)) {

				// acts as a safe for when your trying to look for a property number of a business, rather than it's name.
				if( currentStack.get(TileBusinessToLookFor) == null ) {
					amountOfBusinessTile++;
				}
				// otherwise if your just trying to look for a property name, it will effectively cancel the loop.
				else {
					break;
				}

			}

		}
		
		return amountOfBusinessTile;
	}

	public int buyAction(String action, int amount, int currentMoneyYouHave) {
		switch (action) {
		case "Business":

			int price = amount * 30;

			if (currentMoneyYouHave - (amount * 30) < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addTileBusiness(0);
			}

			return price;

		case "Housing":

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addHousing();
			}

			return price;

		case "Fossil Fuels":

			price = amount * 15;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addFossilFuels();
			}

			return price;

		case "Nuclear Power":

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addNuclearPower();
			}

			return price;
		case "Solar Power":

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addSolar();
			}

			return price;

		case "Wind Power":

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addWindPower();
			}

			return price;

		case "Natural Gas":

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addNaturalGas();
			}

			return price;

		case "Water Power":

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addWaterPower();
			}

			return price;

		case "Mining":

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addMining();
			}

			return price;

		case "Grass Fed Farm Ranch":

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addFarmRanch(30);
			}

			return price;

		case "Farm Ranch":

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addFarmRanch(60);
			}

			return price;

		case "Vegetable/Fruit Farm":

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addFarmPlants();
			}

			return price;

		case "Water Treatment":

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addWaterTreatment();
			}

			return price;
		default:
			System.out.println("Invalid action.");
			return 0;
		}

	}

	public int doShoppingLoop(Scanner scanner, int currentMoneyYouHave) {

		System.out.println("Welcome to the shopping interface!");

		while (true) {
			System.out.println("Enter the product name (or 'exit' to finish shopping): you currently have "
					+ currentMoneyYouHave + "$");
			String productName = scanner.nextLine();

			if (productName.contains("exit")) {
				break;
			}

			String[] shoppingSelection = productName.split(" ");

			int PriceYouPay = buyAction(shoppingSelection[0], Integer.parseInt(shoppingSelection[1]),
					currentMoneyYouHave);

			currentMoneyYouHave -= PriceYouPay;

		}

		System.out.println("Thank you for shopping with us!");
		return currentMoneyYouHave;
	}

	/*
	 * Random tester code please ignore
	 */
	public static void main(String[] args) {

		stackEnvironment test = new stackEnvironment();

		for (int i = 0; i < 100; i++) {
			test.addTileBusiness(-1);
		}

		for (int i = 0; i < 50; i++) {
			test.addTileBusiness(1);
		}

		for (int i = 0; i < 10; i++) {
			test.addTileBusiness(-1);
		}

		for (int i = 0; i < 50; i++) {
			test.addTileBusiness(100);
		}

		test.checkNegatives();

		System.out.println(test.tileBusinesses);

		test.doRateOfChanges();

		System.out.println(test.tileBusinesses);

		test.doDisaster();

		System.out.println(test.tileBusinesses);

		System.out.println("businesses lost at a time: " + test.businessesLost);

		Scanner scanner = new Scanner(System.in);

		test.doShoppingLoop(scanner, 50);

	}

}
