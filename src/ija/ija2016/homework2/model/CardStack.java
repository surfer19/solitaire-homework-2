package ija.ija2016.homework2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class CardStack {

    private int size;
    private ArrayList<Card> cardArray;

    public CardStack(int size) {
        this.size = size;
        this.cardArray = new ArrayList(size);       //initial capacity of 10
    }

    public boolean isEmpty() {
        return cardArray.isEmpty();
    }

    public Card pop()          //pop Card element
    {
        System.out.print("popol som = " + cardArray.get(cardArray.size() - 1) + "\n");

        //System.out.print("vrchol after pop = " + cardArray.get(cardArray.size()-1) + "\n");
        return cardArray.remove(cardArray.size() - 1);
    }

    public boolean put(Card card)      //push integer element
    {

        Card last = getLast();

        System.out.print("prisla karta    = "+ card.value() + "(" + card.color() +")\n");

        if (card.value() == 13 && (last==null)) {
            cardArray.add(card);
            System.out.print("vlozil sa kral\n");

            return true;

        }
        else if (last != null) {
            if (!card.similarColorTo(last)) {
                if (card.value()+1 == last.value()) {
                    System.out.print("vlozila sa = " + card.value() + "(" + card.color() + ")\n");
                    cardArray.add(card);
                    //System.out.println("added = "+ card);
                    return true;
                }
            }
        }
        return false;
    }
    public Card getLast() {
        if (cardArray.size() != 0) {
            return cardArray.get(cardArray.size() - 1);
        }
        return null;
    }

    public int size() {
        return cardArray.size();
    }

    public CardStack takeFrom(Card card) {

        CardStack newCardStack = new CardStack(size);

        int found_idx = -1;

        // compare cards from stack with given card
        for (int i = 0; i < cardArray.size(); i++) {
            if (card.equals(cardArray.get(i))) {
                found_idx = i;
            }
        }
        if (found_idx == -1) {
            return null;
        }

        while (found_idx <= this.size() - 1) {
            newCardStack.put(this.pop());
            System.out.print("popol+putol som kartu\n");
        }

        return newCardStack;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CardStack) {

            CardStack stackis = (CardStack) o;
            for (int i = 0; i < this.size(); i++) {
                if (stackis.size() == this.size()) {
                    if (stackis.cardArray.get(i).color() == ((CardStack) o).cardArray.get(i).color()) {
                        if (stackis.cardArray.get(i).value() == ((CardStack) o).cardArray.get(i).value()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public CardStack pop(Card card) {
        CardStack newCardStack = new CardStack(52);
        int found_idx = 0;
        for (int i = 0; i < cardArray.size(); i++){
            if(card.equals(cardArray.get(i))){
                ///cardArray.remove(i);
                //System.out.print("odobrana karta: " + card.value() + "\n");
                found_idx = i;
                break;
            }
        }
        System.out.print("found idx = " + found_idx + "\n");
        System.out.print("max size = " +  this.size() + "\n");

        while (found_idx <= this.size() ) {
            newCardStack.cardArray.add(this.pop());
            this.size -= 1;

            System.out.print("popol som kartu na indexe = " + found_idx + "\n");
            newCardStack.size++;
            System.out.print("novy stack ma size = " + newCardStack.size()+ "\n");
            found_idx++;
        }
        Collections.reverse(newCardStack.cardArray);
        System.out.print("-----vypis noveho stacku po pop-----\n");

        for (int i = 0; i < newCardStack.cardArray.size(); i++){
            System.out.print("item = " +newCardStack.cardArray.get(i).value() + "(" + newCardStack.cardArray.get(i).color() + ")" + "\n");
        }

        return newCardStack;
    }

    public boolean put(CardStack s) {
        if (this.size() == 0){
            return false;
        }

        int start_idx = this.size();
        int max_size = (this.size() + s.size());

        for (int i = start_idx; i < max_size; i++){
            this.cardArray.add(s.pop());
        }

        return true;
    }
}
