import java.util.*;

public class SwordGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Sword Game!");
        System.out.print("Please choose a card (A, 1, 2, 3, 4, 5, 6, 7, 8, 9, J, Q, K): ");
        String selectedCard = scanner.nextLine().toUpperCase();

        Set<String> cardSet = initializeCards();

        System.out.println("\nSelected card: " + selectedCard);

        Random random = new Random();
        int cardCount = 0;

        // Game loop
        while (true) {
            cardCount++;

            // Player 1 draws a card
            String player1Card = getRandomCard(cardSet, random);
            System.out.println("\nPlayer 1's card: " + player1Card);
            if (player1Card.startsWith(selectedCard)) {
                System.out.println("\nPlayer 1 wins!");
                break;
            }

            // Player 2 draws a card
            String player2Card = getRandomCard(cardSet, random);
            System.out.println("Player 2's card: " + player2Card);
            if (player2Card.startsWith(selectedCard)) {
                System.out.println("\nPlayer 2 wins!");
                break;
            }
        }

        System.out.println("Total number of cards drawn: " + cardCount);
        scanner.close();
    }

    // Initializes the full set of 52 cards
    public static Set<String> initializeCards() {
        Set<String> cards = new HashSet<>();
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
        for (String rank : ranks) {
            for (String suit : suits) {
                cards.add(rank + "-" + suit);
            }
        }
        return cards;
    }

    // Randomly selects a card from the remaining set
    public static String getRandomCard(Set<String> cardSet, Random random) {
        List<String> cardList = new ArrayList<>(cardSet);
        String selectedCard = cardList.get(random.nextInt(cardList.size()));
        cardSet.remove(selectedCard); // Remove drawn card so it won't be drawn again
        return selectedCard;
    }
}
