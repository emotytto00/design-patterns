public class GodState implements State {
    @Override
    public void train(GameCharacter character) {
        System.out.println("Training is no longer necessary. You've become the ultimate being.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditation is no longer necessary. You've become the ultimate being.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting is no longer necessary. You've become the ultimate being.");
    }
}
