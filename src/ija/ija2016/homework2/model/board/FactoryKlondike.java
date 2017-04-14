package ija.ija2016.homework2.model.board;

import ija.ija2016.homework2.model.Card;
import ija.ija2016.homework2.model.CardDeck;
import ija.ija2016.homework2.model.CardException;
import ija.ija2016.homework2.model.CardStack;


public class FactoryKlondike extends AbstractFactorySolitaire {
    public Card createCard(Card.Color color, int i){
            Card someCard = new Card(color, i);
            if (someCard.value() == 0){
                return null;
            }
            return someCard;
    }
    public CardDeck createCardDeck() {

        return CardDeck.createStandardDeck();
    }
    public CardDeck createTargetPack(Card.Color pack_color){

        CardDeck newCardDeck = new CardDeck(0);

        return newCardDeck;

    }
    public CardStack createWorkingPack(){
        CardStack newCardStack = new CardStack(52);

        return newCardStack;
    }
}
