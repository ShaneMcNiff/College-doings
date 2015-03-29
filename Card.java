public class Card {
	public int CardNumber;
	public int SuitID;
	
	public Card(int newCardNumber, int newSuitID){
		CardNumber = newCardNumber;
		SuitID = newSuitID;
		
	}
	public int getCardNumber(){
		return CardNumber;
	}
	public int getSuitID(){
		return SuitID;
	}
	
}
