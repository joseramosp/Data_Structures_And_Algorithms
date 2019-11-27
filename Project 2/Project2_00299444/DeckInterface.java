public interface DeckInterface
{
    //return the top card on the deck
    public Card draw();
   
    public void shuffle();     
    
    //the number of cards remaining in the deck
    public int size();
}
