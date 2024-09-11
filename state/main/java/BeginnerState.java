public class BeginnerState implements State {
    @Override
    public void train(GameCharacter character) {
        character.increaseExperience(10);
        if (character.getExperience() >= 20) {
            character.setState(new AdeptState());
            System.out.println(character.getClass().getSimpleName() + " has leveled up to Adept!");
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditation is not available at the beginner level.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting is not available at the beginner level.");
    }
}
