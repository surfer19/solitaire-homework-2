package ija.ija2016.homework2.model;

import java.util.Arrays;

public class CardDeck {

    private int size;
    private int top;
    private Card[] deck;
    private static final int MAX_CARDS = 13;

//    public int size() {
//    }
//
//    public Card pop() {
//    }

    // constructor
    public CardDeck(int size){
        this.size = size;
        this.deck = new Card[size];
        this.top = -1;
    }

    public boolean put(Card card){
        this.top++;
        deck[this.top] = card;
        return true;
    }
    public Card pop(){
        return deck[top--];
    }

    public static CardDeck createStandardDeck(){
        CardDeck newCardDeck = new CardDeck(52);

        for (Card.Color color : Card.Color.values()){
            int i = 1;
            while (i <= MAX_CARDS){
                try {
                    newCardDeck.put(new Card(color,i));
                }catch(CardException e)
                {
                    e.getMessage();
                    return null;
                }

                i++;
            }
        }
        return newCardDeck;
    }
    public int size(){
        return this.top+1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public Card get() {
        return deck[top];
    }

    Card[] addCard(Card[] oldArr, Card added) {
        Card[] result = Arrays.copyOf(oldArr, oldArr.length +1);
        result[oldArr.length] = added;
        return result;
    }
}
