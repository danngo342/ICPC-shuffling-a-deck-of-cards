import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DealDeck {
	private List<Integer> deck = new ArrayList<Integer>();
	private List<Integer> deckShuffled = new ArrayList<Integer>();
	private List<Integer> start = new ArrayList<Integer>();
	private Stack<Integer> hand = new Stack<Integer>();
	private int numPlayers;
	
	public DealDeck (int numPlayers, int totalCards) {
		this.numPlayers = numPlayers;
		int timesDealt = 0;
		boolean shouldDeal = true;

		startDeck(totalCards);
		
		while (shouldDeal) {
			deal(totalCards);
			resetDeck();
			
			//debugging
			System.out.print("Cards in deck after shuffling: ");
			displayDeck(totalCards, deck);

			timesDealt++;
			if (start.equals(deck)) {
				shouldDeal = false;
			}
		};
		
		System.out.println("The deck was dealt and shuffled " + timesDealt 
				+ " times until each card was in the original order.");
	}
	
	private void startDeck(int totalCards) {
		for (int i = 0; i < totalCards; i++) {
			deck.add(i);
		}
		start.clear();
		start.addAll(deck);
		
		//debugging
		System.out.print("Starting deck: ");
		displayDeck(totalCards, deck);
	}
	
	private void deal (int totalCards) {
		for (int player = 0; player < numPlayers; player++) {
			for (int cardDealt = player; cardDealt < totalCards; cardDealt += numPlayers) {
				hand.add(deck.get(cardDealt));
			}
			
			/*
			//debugging
			System.out.print("cards in player " + player + "'s hand unreversed: ");
			displayDeck(hand.size(), hand);
			*/
			
			shuffleDeck();
			hand.clear();
		}
	}
	
	private void shuffleDeck () {
		int cardsHeld = hand.size();
		for (int card = 0; card < cardsHeld; card++) {
			deckShuffled.add(hand.pop());
		}
		
		//debugging
		System.out.print("Cards in deckShuffled while shuffling: ");
		displayDeck(deckShuffled.size(), deckShuffled);
	}
	
	private void resetDeck () {
		deck.clear();
		deck.addAll(deckShuffled);
		deckShuffled.clear();
	}

	// debugging
	private void displayDeck (int totalCards, List<Integer> cards) {
		for (int i = 0; i < totalCards; i++) {
			System.out.print(cards.get(i) + " ");
		}
		System.out.println("\n");
	}
}
