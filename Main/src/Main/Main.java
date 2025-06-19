package Main;
public class Main {
    public static void main(String[] args) {
        Human p1 = new Human(1, "Shubham");
        Human p2 = new Human(2, "Aditi");
        Human p3 = new Human(3, "Ravi");

        GuessGame game = new GuessGame();
        game.start(p1, p2, p3);    
    }
}