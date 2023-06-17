import java.util.Stack;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class stackEnvironment {

	public int currentAmountHomeless;

	// note, when making the int[] properties, make sure you are also creating index
	// -properties for the rate of change for every other property. otherwise things
	// -break!
	public Stack<HashMap<String, Integer>> tileBusinesses = new Stack<HashMap<String, Integer>>();

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

		newBusiness.put("Plant Farms", null);

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
	
	public void addJunkFoodBusiness() {

		HashMap<String, Integer> newBusiness = new HashMap<String, Integer>();

		newBusiness.put("Junk Food Business", null);

		newBusiness.put("amountOfMoney", 0);

		newBusiness.put("numberOfEmployees", 0);

		newBusiness.put("AmountOfFoodProduced", 120);

		newBusiness.put("amountOfWaterDraining", 30);
		
		newBusiness.put("amountOfCarbonRelase", 20);

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

			// if we have housing, were doing a special change.
			if (currentStack.containsKey("Housing")) {

				int amountOfMoneySustainableForHousing = currentStack.get("amountOfMoney");

				int amountOfPeopleLivingInside = currentStack.get("amountOfPeopleInside");

				int civility = currentStack.get("civility");

				if (amountOfPeopleLivingInside < 0) {
					tileBusinesses.remove(i - currentRemoved);
					currentRemoved++;
					continue;
				}

				if (amountOfMoneySustainableForHousing < 0 || civility < 0) {
					amountHomeless += currentStack.get("amountOfPeopleInside");
					tileBusinesses.remove(i - currentRemoved);
					currentRemoved++;
					continue;
				}

			}

			for (String propertyname : currentStack.keySet()) {

				if (currentStack.get(propertyname) != null && currentStack.get(propertyname) < 0
						&& !propertyname.contains("RATEOF")) {

					tileBusinesses.remove(i - currentRemoved);
					currentRemoved++;
					break;

				}

			}

		}

		return amountHomeless;
	}

	// this simulates how the economy does overtime
	public void doRateOfChanges() {

		int currentSize = tileBusinesses.size();

		// loop through stack, and get the current hashmap
		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			// loop through all keysets of our currentstack to find RATEOF.
			for (String currentPropertyOfChange : currentStack.keySet()) {

				// if we find RATEOF, cut that word off, and well start applying that change to
				// a property.
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

			// if we find that property we are looking for, we will add to sum.
			if (currentStack.containsKey(PropertyToLookFor)) {

				sumOfProperty = sumOfProperty + currentStack.get(PropertyToLookFor);

			}

		}

		return sumOfProperty;

	}

	// allows you to filter out what business type you want to get sum of! same
	// method as above
	public int getSumOfProperty(String PropertyToLookFor, String BusinessTypeFiltering) {

		int currentSize = tileBusinesses.size();

		int sumOfProperty = 0;

		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			// if we find that property we are looking for, we will add to sum.
			if (currentStack.containsKey(PropertyToLookFor) && currentStack.containsKey(BusinessTypeFiltering)) {

				// if you otherwise try to use BusinessTypeFiltering as a second property, you
				// can't do that
				if (currentStack.get(BusinessTypeFiltering) != null) {
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
	public void impactTileBusinessProperties(String PropertyToLookFor, int minRange, int maxRange) {

		int currentSize = tileBusinesses.size();

		Random random = new Random();

		for (int i = 0; i < currentSize; i++) {

			// takes current stack of hashmap i'th loop.
			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			// if we find that property we are looking for, we will change the propertie's
			// number accordingly.
			if (currentStack.containsKey(PropertyToLookFor)) {

				if (minRange < maxRange) {
					int randomGiveOrTake = minRange + random.nextInt(maxRange - minRange + 1);
					currentStack.put(PropertyToLookFor, currentStack.get(PropertyToLookFor) + randomGiveOrTake);
				}

				else {
					int randomGiveOrTake = random.nextInt(minRange - maxRange + 1) + maxRange;
					currentStack.put(PropertyToLookFor, currentStack.get(PropertyToLookFor) + randomGiveOrTake);
				}

			}

			tileBusinesses.set(i, currentStack);

		}

	}

	// can allow you to tell if and when a business tile will get removed from a certain impact.
	public boolean willAmountOfImpactRemoveBusiness(String PropertyToLookFor, int damageToDo, int safeNumberLeft) {

		int currentSize = tileBusinesses.size();

		Random random = new Random();

		for (int i = 0; i < currentSize; i++) {

			// takes current stack of hashmap i'th loop.
			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			// if we find that property we are looking for, we will change the propertie's
			// number accordingly.
			if (currentStack.containsKey(PropertyToLookFor)) {

				if(currentStack.get(PropertyToLookFor) - damageToDo < safeNumberLeft) {
					return true;
				}
				
			}
		}

		return false;
	}

	// this is the same thing, except you can filter this out by business type too.
	public void impactTileBusinessProperties(String PropertyToLookFor, String BusinessTypeFiltering,
			int minimumRangeOfAmountToGiveOrTake, int maximumRangeOfAmountToGiveOrTake) {

		int currentSize = tileBusinesses.size();

		Random random = new Random();

		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			// if we find that property we are looking for, we will change the propertie's
			// number accordingly.
			if (currentStack.containsKey(PropertyToLookFor) && currentStack.containsKey(BusinessTypeFiltering)) {

				// if you otherwise try to use BusinessTypeFiltering as a second property, you
				// can't do that
				if (currentStack.get(BusinessTypeFiltering) != null) {
					break;
				}

				int randomGiveOrTake = minimumRangeOfAmountToGiveOrTake
						+ random.nextInt(maximumRangeOfAmountToGiveOrTake - minimumRangeOfAmountToGiveOrTake);

				currentStack.put(PropertyToLookFor, currentStack.get(PropertyToLookFor) + randomGiveOrTake);

			}

			tileBusinesses.set(i, currentStack);

		}

	}

	// allows you to simulate a natural disaster.
	public void doDisaster() {

		int currentSize = tileBusinesses.size();

		Random random = new Random();

		// loop through stack
		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			// loop through all properties, we will be negatively affecting that business.
			for (String currentProperty : currentStack.keySet()) {

				// rates will be negatively affected differently.
				if (currentStack.get(currentProperty) != null && currentProperty.contains("RATEOF")) {

					int maxIntensity = 20;

					int minIntensity = 10;

					int randomDamage = random.nextInt(maxIntensity - minIntensity) + minIntensity;

					currentStack.replace(currentProperty, currentStack.get(currentProperty) - randomDamage);

					continue;

				}

				// properties will be negatively affected differently.
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

	// allows you to track the amount of a certain businesses you bought, or how
	// much the amount of the businesses tile
	// - you have after a simulation wiped it out
	public int getAmountOfABusinessTile(String TileBusinessToLookFor) {

		int currentSize = tileBusinesses.size();

		int amountOfBusinessTile = 0;

		for (int i = 0; i < currentSize; i++) {

			HashMap<String, Integer> currentStack = tileBusinesses.get(i);

			// if we find business, add to the size.
			if (currentStack.containsKey(TileBusinessToLookFor)) {

				// acts as a safe for when your trying to look for a property number of a
				// business, rather than it's name.
				if (currentStack.get(TileBusinessToLookFor) == null) {
					amountOfBusinessTile++;
				}
				// otherwise if your just trying to look for a property name, it will
				// effectively cancel the loop.
				else {
					break;
				}

			}

		}

		return amountOfBusinessTile;
	}


	public int buyAction(String action, int amount, int currentMoneyYouHave) {
		
		System.out.println("you just bought the ID #" + action + " with an expressed amount for " + amount);
		
		switch (action) {
		
		case "1": //business

			int price = amount * 30;

			if (currentMoneyYouHave - (amount * 30) < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addTileBusiness(0);
			}

			return price;

		case "2": //housing

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addHousing();
			}

			return price;

		case "3": //fossil fuels

			price = amount * 15;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addFossilFuels();
			}

			return price;

		case "4": //nuclear power

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addNuclearPower();
			}

			return price;
		case "5": //solar power

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addSolar();
			}

			return price;

		case "6": //wind power

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addWindPower();
			}

			return price;

		case "7": //natural gas

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addNaturalGas();
			}

			return price;

		case "8": //water power

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addWaterPower();
			}

			return price;

		case "9": //mining

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addMining();
			}

			return price;

		case "10": //grass fed farm ranch

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addFarmRanch(30);
			}

			return price;

		case "11": //farm ranch

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addFarmRanch(60);
			}

			return price;

		case "12": //produce farm

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addFarmPlants();
			}

			return price;
			
		case "13": //junk food

			price = amount * 25;

			if (currentMoneyYouHave - price < 0) {
				System.out.println("Sorry you cant afford that amount for that tile!");
				return 0;
			}

			for (int i = 0; i < amount; i++) {
				addJunkFoodBusiness();
			}

			return price;

		case "14": //water treatment

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

		System.out.println("Welcome to the shopping interface! Available items below:");
		
		while (true) {

			String[] itemName = { "Business[1]", "Housing[2]", "Fossil Fuels[3]", "Nuclear Power[4]", "Solar Power[5]",
					"Wind Power[6]", "Natural Gas[7]", "Hydro Power[8]", "Mining[9]", "Grass-Fed Farm Ranch[10]",
					"Farm Ranch[11]", "Produce Farm[12]", "Junk Food[13]", "Water Treatment[14]" };
			int[] itemPrice = { 30, 25, 15, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25};
			for (int i = 0; i < itemName.length; i++) {
				if (i <= 4) {
					System.out.print(itemName[i] + " = $" + itemPrice[i] + ", ");
				} else if (i <= 8 && i >= 5) {
					if (i == 5) {
						System.out.println("");
					}
					System.out.print(itemName[i] + " = $" + itemPrice[i] + ", ");
				} else {
					if (i == 9) {
						System.out.println("");
					}
					System.out.print(itemName[i] + " = $" + itemPrice[i] + ", ");
				}
			}
			System.out.println("\n");
			
			System.out.println("Enter integers for [product code] & [amount] to purchase (or 'exit' to finish shopping): you currently have "
					+ currentMoneyYouHave + "$");
			String productName = scanner.nextLine().toLowerCase(); 

			if (productName.contains("exit")) {
				break;
			}

			String[] shoppingSelection = productName.split(" ");
			
			try {
				int PriceYouPay = buyAction(shoppingSelection[0], Integer.parseInt(shoppingSelection[1]),
						currentMoneyYouHave);

				currentMoneyYouHave -= PriceYouPay;
			} catch (Exception e) { // for if player enters only a String or only a #
				System.out.println("Wrong input. Did you remember to enter a product id and amount, and ONLY use integers?");
			}
		}

		System.out.println("Thank you for shopping with us!");
		return currentMoneyYouHave;
	}

	/*
	 * Random tester code please ignore
	 * 
	 * TODO: modify the text ui to display all of the businesses you can by, a
	 * recommendation would be to use string builder, and use two seperate arrays
	 * between prices and the string of the business name
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
