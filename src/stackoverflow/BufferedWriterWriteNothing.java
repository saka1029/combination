package stackoverflow;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedWriterWriteNothing {

    public static void main(String[] args) throws IOException {
        Path pathTest = Paths.get("saveFile.txt");
        BufferedWriter writer = Files.newBufferedWriter(pathTest);
                writer.write("Testing");
                writer.newLine();
                writer.write("Testing 2");
    }
}
