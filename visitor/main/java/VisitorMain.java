public class VisitorMain {
    public static void main(String[] args) {
        File file1 = new File("koulujuttu.txt", 10);
        File file2 = new File("siisti_kuva.jpg", 5);
        File file3 = new File("Batman_leffa.mp4", 10000000);
        File file4 = new File("mun_esitelmä.ppt", 20);

        Directory root = new Directory("root");
        Directory images = new Directory("images");
        Directory videos = new Directory("videos");

        images.addElement(file2);
        videos.addElement(file3);

        root.addElement(file1);
        root.addElement(file4);
        root.addElement(images);
        root.addElement(videos);

        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        root.accept(sizeCalculator);
        System.out.println("Total size of all files: " + sizeCalculator.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        System.out.println("Files matching '.txt':");
        for (File searchFile : searchVisitor.getMatchingFiles()) {
            System.out.println(" - " + searchFile.getName());

        SearchVisitor searchVisitor2 = new SearchVisitor(".mp4");
        root.accept(searchVisitor2);
        System.out.println("Files matching '.mp4':");
        for (File searchFile2 : searchVisitor2.getMatchingFiles()) {
                System.out.println(" - " + searchFile2.getName());
            }
        }
    }
}
