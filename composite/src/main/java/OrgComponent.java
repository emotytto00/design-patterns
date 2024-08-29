public interface OrgComponent {
    void add(OrgComponent component);
    void remove(OrgComponent component);
    double getTotalSalary();
    void printStructure(StringBuilder builder, int indent);
}