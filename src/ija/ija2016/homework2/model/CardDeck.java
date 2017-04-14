package ija.ija2016.homework2.model;

import java.util.ArrayList;

public class CardDeck {

    private static final int MAX_CARDS = 13;//
    public int size;

    //private Card.Color deck_color;

    private ArrayList<Card> deck;

    public CardDeck(int size) {
        this.deck = new ArrayList(size);       //initial capacity of 10
        this.size = size;
    }

//    public void setDeckColor(Card.Color color){
//        this.deck_color = color;
//    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public Card pop()          //pop  element
    {
        if (deck.size() != 0) {
            System.out.print("vybral som  = " + deck.get(deck.size() - 1));
        }
        //TODO maybe bad
        this.size--;
        return deck.remove(((deck.size()) - 1));
    }

    public static CardDeck createStandardDeck(){
        CardDeck newCardDeck = new CardDeck(52);

        for (int i = 1; i<14; i++) {
            System.out.print("CLUBS\n");
            //newCardDeck.size++;
            newCardDeck.put2(new Card(Card.Color.CLUBS, i));
        }
        for (int i = 1; i<14; i++) {
            System.out.print("DIA\n");
            //newCardDeck.size++;
            newCardDeck.put2(new Card(Card.Color.DIAMONDS, i));
        }
        for (int i = 1; i<14; i++) {
            System.out.print("SPADES\n");
            //newCardDeck.size++;
            newCardDeck.put2(new Card(Card.Color.SPADES, i));
        }
        for (int i = 1; i<14; i++) {
            System.out.print("<3\n");
            //newCardDeck.size++;
            newCardDeck.put2(new Card(Card.Color.HEARTS, i));
        }

        System.out.print("newCardDeck SIZE = " + newCardDeck.size() + "\n");

        return newCardDeck;
    }

    public boolean put2(Card card)
    {
        deck.add(card);

        return true;
    }

    public boolean put(Card card)
    {
        if ((card.color() == Card.Color.CLUBS) && ((card.value() == 1) || (card.value() == 2))) {
            deck.add(card);
            this.size++;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Card get(int idx) {
        return deck.get(idx);
    }

    public Card get() {
        return (deck.get(deck.size() - 1));
    }
}