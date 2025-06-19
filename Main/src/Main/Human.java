package Main;

public class Human {
    private String name;
    private int id;
    private int guess;

    public Human(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getGuess() {
        return this.guess;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

	public void makeGuess() {
		this.guess = (int) (Math.random() * 10);
        System.out.println(this.name + " guessed: " + this.guess);
		
	}
}
