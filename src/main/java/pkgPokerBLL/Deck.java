package pkgPokerBLL;

import java.util.ArrayList;
import java.util.UUID;

import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class Deck {

	private UUID DeckID;
	private ArrayList<Card> DeckCards = new ArrayList<Card>();  
	private int[] cardsIndexesForDraw = new int[52]; 			
	private int IndexeForDraw = 0; 								
	
	/**
	 * 洗牌
	 * 创建一个新的实例 Deck.
	 */
	public Deck()
	{
		//TODO: Implement This Constructor (no-arg Deck should build up a deck with 52 cards)
		
		//	This method will do a for/each, returning each rank in the enum.
		
		Card card = null;
		
		for (eRank Rank : eRank.values()) {
			if(Rank.getiRankNbr() == eRank.JOKER.getiRankNbr()){
				continue;
			}
			for(eSuit Suit : eSuit.values()){
				if(Suit.getiSuitNbr()== eSuit.JOKER.getiSuitNbr()){
					continue;
				}
				card = new Card(Rank, Suit);
				this.DeckCards.add(card);
			}
		}
		
		RandomSort randomSort = new RandomSort();
		randomSort.changePosition();
		this.cardsIndexesForDraw = randomSort.getPositions();
	}
	
	public Card DrawCard()
	{
		//	TODO: Implement this method... should draw a card from the deck.
		Card card = this.DeckCards.get(this.cardsIndexesForDraw[this.IndexeForDraw++]);
		return card;
	}
	
	public static void main(String[] args) {
		Card card = new Deck().DrawCard();
		System.out.println(card.geteRank());
	}
	
}
