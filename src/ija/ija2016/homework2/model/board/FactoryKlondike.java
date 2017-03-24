package ija.ija2016.homework2.model.board;

import ija.ija2016.homework2.model.Card;
import ija.ija2016.homework2.model.CardDeck;
import ija.ija2016.homework2.model.CardException;


public class FactoryKlondike extends AbstractFactorySolitaire {
    public Card createCard(Card.Color clubs, int i){
        try {
            return new Card(clubs, i);
        }catch(CardException e)
        {
            e.getMessage();
            return null;
        }

    }
    public CardDeck createCardDeck() {
        return CardDeck.createStandardDeck();
    }
    public CardDeck createTargetPack(Card.Color clubs){
//        Card newCard = new Card();
        try {
            CardDeck newCardDeck = new CardDeck(99);
            for(int i = 0; i < 14; i++) {

                Card newCard = new Card(clubs, i);
                newCardDeck.put(newCard);
            }
            return newCardDeck;
        }
        catch (CardException e){
            return null;
        }
    }
}
