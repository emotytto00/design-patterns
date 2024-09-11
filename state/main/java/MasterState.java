public class MasterState implements State {
    @Override
    public void train(GameCharacter character) {
        character.increaseExperience(10);
        if (character.getExperience() >= 100) {
            character.setState(new GodState());
            System.out.println(character.getName() + " has reached God level!");
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        character.increaseHealth(15);
    }

    @Override
    public void fight(GameCharacter character) {
        character.decreaseHealth(20);
        character.increaseExperience(15);
    }
}
