public class Card {
  public static void playCard (){
    // empty method for inheritance
  }
  
}

public class CharityEvent extends Card (){
  @Override
    public void playCard (){
      int charityCost = randomNumber(100,10000);
      int charityTypeInt = randomNumber(1,4);
      String charityType = variableType(charityTypeInt);
      // print out details of event for player
      System.out.println("=============================================================\n"+
                         "You have been given the opportunity to throw a charity event.");
      if(charityCost<=budget){
        System.out.println("You may spend $"+charityCost+" to have a chance at increasing "+charityType+".\n"+
          "1. You decide to host the charity event. "+charityType+" is important!\n"+
          "2. You decide that hosting the event is not in the cards for this year.");
        int doEvent = pickOption(scanner,"What will you do? Type in your answer now.", 2);
        if (doEvent = 1){
          budget = budget - charityCost;
          int charityDoesHelp = happiness * randomNumber(1,10);
          int charityBonus = randomNumber(1,10);
          if (charityDoesHelp >= 450){
            System.out.println("The charity was a success! Your "+charityType+" has increased by"+charityBonus+"!\n"+
                              "Your "+variableType(6)+" has decreased by "+charityCost+".");
            if(charityTypeInt == 1){
              biologicalDiversity = Math.floor(biologicalDiversity + charityBonus, 100);
            }else if(charityTypeInt == 2){
              waterHealth = Math.floor(waterHealth + charityBonus, 100);
            }else if(charityTypeInt == 3){
              happiness = Math.floor(happiness + charityBonus,100);
            }else{
              health = Math.floor(health + charityBonus,100);
            }
          }else{
            System.out.println("The charity was a flop. "+CharityType+" did not increase.");
          }
        }else{
          System.out.println("You decided not to host the charity event. Nothing changes.");
        }
      }else{
        System.out.println("Unfortunately, you were too low on funds and had to decline.");
      }
      System.out.println("=============================================================");                  
    }
}

public class OilSpill extends Card (){
  @Overrides
  public void playCard (){
      int spillCost = randomNumber(1000,100000);
      // print out details of event for player
      System.out.println("=============================================================\n"+
                         "There was an oil spill nearby.");
      if(spillCost<=budget){
        System.out.println("You may spend $"+spillCost+" to protect the health of your water.\n"+
          "1. You decide to foot the bill and do some cleanup. It's water we all drink! \n"+
          "2. You decide not to help out with the cleanup - a little oil can't hurt. Right?\n"+
          "3. You decide to slide a little of your own mess into the mix. What's the harm if no one finds out?");
        int doEvent = pickOption(scanner,"What will you do? Type in your answer now.", 3);
        if (doEvent == 1){
          System.out.println("You roll up your sleeves - well, the metaphorical ones - and get to some cleaning.\n"+
                            "The water is cool and clear again.\n"+
                            "Your "+variableType(6)+" has decreased by "+spillCost+".");
          budget = budget - spillCost;
        }else if (doEvent == 2){
          int spillPenalty = randomNumber(1,10);
          System.out.println("The oil spill continues. Your pockets stay safe, but many sea animals do not.\n"+
                              "Your "+variableType(2)+" has reduced by "+spillPenalty+".");
          waterHealth = waterHealth - spillPenalty;
        }else{
          int incomeIncrease = randomNumber(10,100);
          int spillPenalty = randomNumber(1,10) + randomNumber(1,5);
          System.out.println("The oil spill continues, and no one notices your subterfuge.\n"+
                            "Still, as your  "+variableType(2)+" reduces by "+spillPenalty+", you wonder... \n"+
                            "Did you make it worse?\n"+
                            "Then again, your "+variableType(5)+" increased by "+incomeIncrease+"...");
          waterHealth = waterHealth - spillPenalty;
          income = income + incomeIncrease;
        }  
      }else{
        int spillPenalty = randomNumber(1,10);
        System.out.println("Unfortunately, you were too low on funds and could do nothing about it.\n"+
                        "Your  "+variableType(2)+" has reduced by "+spillPenalty+".");
         waterHealth = waterHealth - spillPenalty;
      }
      System.out.println("=============================================================");                  
    }
}