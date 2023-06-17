import java.util.Scanner;

public class OilSpill extends Card {
	
	public environmenthealth healthToUtilize;

	public stackEnvironment tileBussinessesToUtilize;
	
	public int moneyToUtilize;
	
	public void playCard (environmenthealth healthToChange, stackEnvironment tileBussinessesToChange, int moneyYouHave){
		Scanner scanner = new Scanner(System.in);
		int spillCost = randomNumber(10,100);
		// print out details of event for player
		System.out.println("=============================================================\n"+
				"There was an oil spill nearby.");
		if(spillCost<=moneyYouHave){
			System.out.println("You may spend $"+spillCost+" to protect the health of your water.\n"+
					"1. You decide to foot the bill and do some cleanup. It's water we all drink! \n"+
					"2. You decide not to help out with the cleanup - a little oil can't hurt. Right?\n"+
					"3. You decide to slide a little of your own mess into the mix. What's the harm if no one finds out?\n"+
					"What will you do? Type in your answer now.");
			int doEvent = pickOption(scanner, 3);
			if (doEvent == 1){
				System.out.println("You roll up your sleeves - well, the metaphorical ones - and get to some cleaning.\n"+
						"The water is cool and clear again.\n"+
						"Your "+variableType[5]+" has decreased by "+spillCost+".");
				moneyYouHave = moneyYouHave - spillCost;
			}else if (doEvent == 2){
				int spillPenalty = randomNumber(1,10);
				System.out.println("The oil spill continues. Your pockets stay safe, but many sea animals do not.\n"+
						"Your "+variableType[1]+" has reduced by "+spillPenalty+".");
				healthToChange.waterhealth = healthToChange.waterhealth - spillPenalty;
				healthToChange.biodiversity = healthToChange.biodiversity - (spillPenalty * 10); 
			}else{
				int incomeIncrease = randomNumber(10,100);
				int spillPenalty = randomNumber(1,10) + randomNumber(1,5);
				System.out.println("The oil spill continues, and no one notices your subterfuge.\n"+
						"Still, as your  "+variableType[1]+" reduces by "+spillPenalty+", you wonder... \n"+
						"Did you make it worse?\n"+
						"Then again, your "+variableType[5]+" increased by "+incomeIncrease+"...");
				healthToChange.waterhealth = healthToChange.waterhealth - spillPenalty;
				healthToChange.biodiversity = healthToChange.biodiversity - (spillPenalty * 10); 
				tileBussinessesToChange.impactTileBusinessProperties("RATEOFamountOfMoney", incomeIncrease, incomeIncrease);
				moneyYouHave = moneyYouHave + incomeIncrease;
			}  
		}else{
			int spillPenalty = randomNumber(1,10);
			System.out.println("Unfortunately, you were too low on funds and could do nothing about it.\n"+
					"Your  "+variableType[1]+" has reduced by "+spillPenalty+".");
			healthToChange.waterhealth = healthToChange.waterhealth - spillPenalty;
			healthToChange.biodiversity = healthToChange.biodiversity - (spillPenalty * 10); 
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