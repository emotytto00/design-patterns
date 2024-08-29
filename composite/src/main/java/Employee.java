class Employee implements OrgComponent {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void add(OrgComponent component) {
        throw new UnsupportedOperationException("Cannot add to an employee.");
    }

    @Override
    public void remove(OrgComponent component) {
        throw new UnsupportedOperationException("Cannot remove from an employee.");
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public void printStructure(StringBuilder builder, int indent) {
        for (int i = 0; i < indent; i++) builder.append("\t");
        builder.append("<employee name=\"").append(name).append("\" salary=\"").append(salary).append("\" />\n");
    }
}