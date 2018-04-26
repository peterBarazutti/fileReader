import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {

    public String filePath;
    public Integer fromLine;
    public Integer toLine;

    public FilePartReader() {
        filePath = "very/wrong/filepath.txt";
        fromLine = -1;
        toLine = -1;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine){
        this.fromLine = fromLine;
        this.toLine = toLine;
        this.filePath = filePath;
        if (toLine < fromLine || fromLine < 1){
            throw new IllegalArgumentException("toLine is smaller than fromLine");
        }
    }

    public String read() throws IOException{

        String result = "";

            File f = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String readLine;

            while ((readLine = br.readLine()) != null) {
                result = result.concat(readLine + "\n");
            }

        return result;
    }

    public String readLines() throws IOException{
        String text;
        String result = "";

            text = read();
            String[] lines = text.split("\\r?\\n");
            for (int i = fromLine - 1; i < toLine; i++) {
                result = result.concat(lines[i] + "\n");
            }

        return result;
    }

}
