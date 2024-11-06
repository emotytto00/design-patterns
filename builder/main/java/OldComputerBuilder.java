public class OldComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OldComputerBuilder() {
        this.computer = new Computer();
    }

    public void buildProcessor() {
        computer.setProcessor("Intel Pentium 4");
    }

    public void buildRAM() {
        computer.setRAM(1);
    }

    public void buildHardDrive() {
        computer.setHardDrive("25 GB HDD");
    }

    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Intel Graphics");
    }

    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows XP");
    }

    public Computer getComputer() {
        return this.computer;
    }
}
