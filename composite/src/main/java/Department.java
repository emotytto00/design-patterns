import java.util.ArrayList;
import java.util.List;

class Department implements OrgComponent {
    private String name;
    private List<OrgComponent> components;

    public Department(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    @Override
    public void add(OrgComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrgComponent component) {
        components.remove(component);
    }

    @Override
    public double getTotalSalary() {
        double totalSalary = 0;
        for (OrgComponent component : components) {
            totalSalary += component.getTotalSalary();
        }
        return totalSalary;
    }

    @Override
    public void printStructure(StringBuilder builder, int indent) {
        for (int i = 0; i < indent; i++) builder.append("\t");
        builder.append("<department name=\"").append(name).append("\">\n");
        for (OrgComponent component : components) {
            component.printStructure(builder, indent + 1);
        }
        for (int i = 0; i < indent; i++) builder.append("\t");
        builder.append("</department>\n");
    }
}