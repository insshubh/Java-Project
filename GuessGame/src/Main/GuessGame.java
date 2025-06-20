package Main;

public class GuessGame {
    public void start(Human... players) {
        int target = (int) (Math.random() * 10);
        System.out.println("Target number is: " + target);
        int i = 0;
        boolean winnerFound = false;
        while (i < 10) {
        for (Human p : players) {
            p.makeGuess();
            if (p.getGuess() == target) {
                System.out.println("🎉 " + p.getName() + " (ID: " + p.getId() + ") guessed correctly!");
                winnerFound = true;
                break;
            }
        }
        i +=1;
        if (!winnerFound) {
            System.out.println("No winners this round. Try again!");
        }
        if(winnerFound == true) {
        	break;
        }
        }
    }
}

