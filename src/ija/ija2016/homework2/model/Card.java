package ija.ija2016.homework2.model;

public class Card {

    private int value;
    private Color c;
    private boolean isFaceUp;

    public Card(Card.Color c, int value) throws CardException{
        if (value < 1 || value > 13){
            throw new CardException("TOO HIGH");
        }
        this.value = value;
        this.c = c;
        this.isFaceUp = false;
    }

    public Card.Color color() {
        return this.c;
    }


    public int value(){
        return this.value;
    }

    @Override
    public String toString() {

        String result_string = "";
        result_string += enumToString();
        result_string += "(";
        result_string += color();
        result_string += ")";

        return result_string;
    }

    public String enumToString() {
        switch (this.value){
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(this.value);
        }
    }


    public boolean isTurnedFaceUp() {
        //System.out.print("is Face in func = " + this.isFaceUp + "\n");
        return this.isFaceUp;
    }

    public boolean turnFaceUp() {
        if (this.isFaceUp) {
            return false;
        }
        return this.isFaceUp = true;
    }

    public boolean similarColorTo(Card card) {
        // todo
        if (card.c == Color.DIAMONDS || card.c == Color.HEARTS){
            if (this.c == Color.DIAMONDS || this.c == Color.HEARTS){
                return true;
            }
        }
        if (card.c == Color.SPADES || card.c == Color.CLUBS){
            if (this.c == Color.SPADES || this.c == Color.CLUBS){
                return true;
            }
        }
        return false;
    }

    public int compareValue(Card card) {
        if(card.value() == this.value()){
            return 0;
        }
        if (card.value() > this.value()){
            return card.value() - this.value();
        }
        return this.value() - card.value();
    }

    public enum Color {

        CLUBS("C"),
        HEARTS("H"),
        DIAMONDS("D"),
        SPADES("S");

        private String value;

        private Color(String value){
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }


    @Override
    public boolean equals(Object o){
        if(o instanceof Card){
            Card object = (Card) o;
            if(object.value == this.value && object.c == this.c){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 17 + this.c.hashCode();
        hash = hash * 31 + this.value;

        return hash;
    }
}