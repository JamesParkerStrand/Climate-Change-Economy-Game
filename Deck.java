import java.util.ArrayList;

public class Deck {
	static ArrayList<Card> cardDeck = new ArrayList<Card>();
	
	public static environmenthealth healthToUtilize;

	public static stackEnvironment tileBussinessesToUtilize;
	
	public static int moneyToUtilize;
	
	public static void shuffleDeck (ArrayList<Card> cardDeck) {
		for(int i = 0; i < 10; i++) {
			int addition = Card.randomNumber(1,2);
			if(addition == 1) {
				cardDeck.add(new CharityEvent());
			}else if(addition == 2) {
				cardDeck.add(new OilSpill());
			}
		}
	}
	
	public static void playCard(int MoneyYouHave) {
		if (cardDeck.size() == 0) {
			shuffleDeck(cardDeck);
		}
		cardDeck.get(0).playCard(healthToUtilize, tileBussinessesToUtilize, MoneyYouHave);
		healthToUtilize = cardDeck.get(0).getHealthToUtilize();
		tileBussinessesToUtilize = cardDeck.get(0).getTileBussinessesToUtilize();
		moneyToUtilize = cardDeck.get(0).getMoneyToUtilize();
		cardDeck.remove(0);
	}
}