package ija.ija2016.homework2.model.board;

import ija.ija2016.homework2.model.Card;
import ija.ija2016.homework2.model.CardDeck;

public abstract class AbstractFactorySolitaire {

    public abstract Card createCard(Card.Color clubs, int i);
    public abstract CardDeck createCardDeck();
    public abstract CardDeck createTargetPack(Card.Color clubs);
}
