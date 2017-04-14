package ija.ija2016.homework2.model.board;

import ija.ija2016.homework2.model.Card;
import ija.ija2016.homework2.model.CardDeck;
import ija.ija2016.homework2.model.CardStack;

public abstract class AbstractFactorySolitaire {

    public abstract Card createCard(Card.Color clubs, int i);
    public abstract CardDeck createCardDeck();
    public abstract CardDeck createTargetPack(Card.Color clubs);
    abstract public CardStack createWorkingPack();
}
