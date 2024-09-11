public class GameCharacter {
    private String name;
    private int experience;
    private int health;
    private State state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.state = new BeginnerState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getExperience() {
        return experience;
    }

    public void increaseExperience(int points) {
        this.experience += points;
        System.out.println(name + " gained " + points + " experience points.");
    }

    public int getHealth() {
        return health;
    }

    public void increaseHealth(int points) {
        this.health = Math.min(health + points, 100);
        System.out.println(name + " gained " + points + " health points.");
    }

    public void decreaseHealth(int points) {
        this.health -= points;
        System.out.println(name + " lost " + points + " health points.");
    }

    public void train() {
        state.train(this);
    }

    public void meditate() {
        state.meditate(this);
    }

    public void fight() {
        state.fight(this);
    }

    public void displayStatus() {
        System.out.println("Character: " + name + " | Experience: " + experience + " | Health: " + health + " | Current Level: " + state.getClass().getSimpleName());
    }

    public Object getState() {
        return state;
    }

    public String getName() {
        return name;
    }
}
