package dev.stephenpearson.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import dev.stephenpearson.model.Card;
import dev.stephenpearson.model.Deck;
import dev.stephenpearson.model.Rank;
import dev.stephenpearson.model.Suit;

public class DeckController {
	
	Map<Integer, Deck> decks;
	List<Card> gameStack = new Stack<>();
	
	public DeckController() {
		
		
		buildDecks(4);
		buildGameStack();
	
	}
	
	public void buildGameStack() {
		
		decks.forEach((I,D) -> gameStack.addAll(D.getCardsInDeck()));
		
		
	}
	
	public void printGameStackToConsole() {
		
		if(gameStack.isEmpty()) {
			System.out.println("The game stack is empty.");
		} else {
			gameStack.forEach(e -> System.out.println(e.getCardString()));
			System.out.println("Stack size is: " + gameStack.size());
		}

	}
	
	public void buildDecks(int numOfDecks) {
		decks = new HashMap<>();
		for(int d = 0; d < numOfDecks; d++) {
			decks.put(Integer.valueOf(d), new Deck());
		}
		
		
	}
	
	public Map<Integer, Deck> getDecks() {

		return decks;
	}

}