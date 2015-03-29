import java.util.*;
public class Deck {
	public Card []FullDeck = new Card[52];
	public Card []ShuffledDeck = new Card[52];
	public Deck(){
		ArrayList<Integer> usedNumbers = new ArrayList<Integer>(52);
		int i = 1, j = 1, k = 0;
		for(i = 1; i <= 4; i++){
			for(j = 1; j <= (FullDeck.length / 4); j++){
				FullDeck[k] = new Card(j,i);
				k++;
			}
		}
		
		int r = 0;
		for(i = 0; i < FullDeck.length; i++){
			r =  (int)(Math.random() * 52);
			while(usedNumbers.contains(r))
				r =  (int)(Math.random() * 52);
			ShuffledDeck[r] = FullDeck[i];
			usedNumbers.add(r);
		}
		
	}
	public String toString(){
		int z = 0;
		String result = "";
		for(z = 0; z < 52; z++){
			
			if(ShuffledDeck[z].getCardNumber() == 11)
				result += "Jack ";
			else if(ShuffledDeck[z].getCardNumber() == 12)
				result += "Queen ";
			else if(ShuffledDeck[z].getCardNumber() == 13)
				result += "King ";
			else if(ShuffledDeck[z].getCardNumber() == 1)
				result += "Ace ";
			else{
				result += ShuffledDeck[z].getCardNumber() + " ";
			}
			
			if(ShuffledDeck[z].getSuitID() == 1){
				result += "of Hearts\n";
			}
			else if(ShuffledDeck[z].getSuitID() == 2){
				result += "of Diamonds\n";
			}
			else if(ShuffledDeck[z].getSuitID() == 3){
				result += "of Spades\n";
			}
			else{
				result += "of Clubs\n";
			}
			
		}
		return result;
	}
	public String getNextCard(int n){
		String result = "";
		
		
		int b = ShuffledDeck[n].getCardNumber();
		if (b == 1)
			result += "Ace ";
		else if (b == 11)
			result += "Jack ";
		else if (b == 12)
			result += "Queen ";
		else if (b == 13)
			result += "King ";
		else
			result += b + " ";
		
		int a = ShuffledDeck[n].getSuitID();
		if (a == 1)
			result += "of Hearts\n";
		else if (a == 2)
			result += "of Diamonds\n";
		else if (a == 3)
			result += "of Spades\n";
		else
			result += "of Clubs\n";
		return result;
	}
}
