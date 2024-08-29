public class Main {
    public static void main(String[] args) {
        UIFactory factoryA = new FactoryA();
        Button buttonA = factoryA.createButton("Click me");
        TextField textFieldA = factoryA.createTextField("Enter text");
        Checkbox checkboxA = factoryA.createCheckbox("Check this box");

        buttonA.display();
        textFieldA.display();
        checkboxA.display();

        buttonA.setText("You won't dare to click me");
        buttonA.display();

        UIFactory factoryB = new FactoryB();
        Button buttonB = factoryB.createButton("Don't click me");
        TextField textFieldB = factoryB.createTextField("Don't type here");
        Checkbox checkboxB = factoryB.createCheckbox("Don't check this box");

        buttonB.display();
        textFieldB.display();
        checkboxB.display();

        textFieldB.setText("New text who dis?");
        textFieldB.display();
    }
}
