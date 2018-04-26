import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileWordAnalyzer {

    FilePartReader fp;

    public FileWordAnalyzer(FilePartReader fp) {
        this.fp = fp;
    }

    public ArrayList<String> wordsByABC() throws IOException{
        String[] words = fp.readLines().split("\\W+");
        Arrays.sort(words);
        return new ArrayList<>(Arrays.asList(words));
    }

    public ArrayList wordsContainingSubString(String subString) throws IOException{
        String[] words = fp.readLines().split("\\W+");
        return Arrays.stream(words).filter(x -> x.contains(subString)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList wordsArePalindrome() throws IOException{
        String[] words = fp.readLines().split("\\W+");
        return Arrays.stream(words).filter(x -> x.equals(new StringBuffer(x).reverse().toString())).collect(Collectors.toCollection(ArrayList::new));
    }
}
