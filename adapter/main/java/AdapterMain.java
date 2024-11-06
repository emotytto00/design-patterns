public class AdapterMain {
    public static void main(String[] args) {
        NewDateInterface dateAdapter = new CalendarAdapter();

        dateAdapter.setDay(6);
        dateAdapter.setMonth(11);
        dateAdapter.setYear(2024);

        System.out.println("Initial Date: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());

        dateAdapter.advanceDays(10);

        System.out.println("Date After Advancing 10 Days: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());

        dateAdapter.advanceDays(25);

        System.out.println("Date After Advancing 25 More Days: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());
    }
}