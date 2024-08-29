public class MainProgram {
    public static void main(String[] args) {
        Department headOffice = new Department("Head Office");
        Department itDepartment = new Department("IT Department");
        Department hrDepartment = new Department("HR Department");

        Employee Jaakko = new Employee("Jaakko", 5000);
        Employee Jorma = new Employee("Jorma", 6000);
        Employee Jooseppi = new Employee("Jooseppi", 5500);

        headOffice.add(itDepartment);
        headOffice.add(hrDepartment);
        itDepartment.add(Jaakko);
        itDepartment.add(Jorma);
        hrDepartment.add(Jooseppi);

        Department regionalOffice = new Department("Janitorial Services");
        headOffice.add(regionalOffice);
        Employee dave = new Employee("Jooseppi jr.", 10000);
        regionalOffice.add(dave);

        System.out.println("Total salary of the whole organization: €" + headOffice.getTotalSalary());

        StringBuilder builder = new StringBuilder();
        headOffice.printStructure(builder, 0);
        System.out.println(builder.toString());
    }
}