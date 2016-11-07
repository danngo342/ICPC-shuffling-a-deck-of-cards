import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ICPC {
	
	/*
	 * lists vs array
	 * array is for objects and primitive data types
	 * lists are for classes
	 */
	
	private void note () {
		/*
		 * The new arraylist on the right of the equal sign means that the List interface is being implemented 
		 * by ArrayList. Such implementation is required because the attributes within List is undefined (hence
		 * that's why its an interface) while ArrayList is a "general purpose implementation"
		 */
		List<Integer> hand = new ArrayList<Integer>();
		List<List<Integer>> deck = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				hand.add(j);
			}
		}
		
		deck.add(hand);
		deck.get(0).add(6);
		
		for (int i = 0; i < 5; i++) {
			/*
			 * the first call of get(0) acquires the element hand from deck, and then the second get call acquires
			 * the integer element from the list hand
			 */
			//System.out.print(deck.get(0).get(i) + " ");
		}
		//System.out.print(deck.get(0).get(0) + " ");
		System.out.println(deck.get(0).get(16));
	}
	
	public static void main (String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("Type in the number of players");
		int numPlayers = key.nextInt();
		System.out.println("Type in the total number of cards");
		int totalCards = key.nextInt();
		System.out.println();
		new DealDeck(numPlayers, totalCards);
	}
}
