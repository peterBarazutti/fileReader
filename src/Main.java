import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("example.txt", 1,2);
        try {
            System.out.println(fpr.read());
        } catch (IOException e) {
            System.out.println("File cannot be found.");;
        }

        try {
            System.out.println(fpr.readLines());
        } catch (Exception e) {
            System.out.println("Vmi nem jó");
        }

        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        try {
            System.out.println(fwa.wordsByABC());
            System.out.println(fwa.wordsContainingSubString("ine"));
            System.out.println(fwa.wordsArePalindrome());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
