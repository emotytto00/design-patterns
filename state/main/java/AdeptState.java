public class AdeptState implements State {
    @Override
    public void train(GameCharacter character) {
        character.increaseExperience(10);
        if (character.getExperience() >= 50) {
            character.setState(new MasterState());
            System.out.println(character.getClass().getSimpleName() + " has leveled up to Master!");
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        character.increaseHealth(20);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting is not available at the adept level.");
    }
}
