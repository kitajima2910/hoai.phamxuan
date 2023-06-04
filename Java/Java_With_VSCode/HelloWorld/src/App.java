import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.print("Enter my name: ");
        String name = scanner.nextLine();

        System.out.print("Enter my age: ");
        int age = Integer.valueOf(scanner.nextLine());

        // Hiển thị Tiếng Việt
        try(PrintWriter consoleOut = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8))) {
            consoleOut.println(convertToBinary(name, "UTF-8") + " - " + age);
        }
    }

    private static String convertToBinary(String input, String encoding) 
      throws UnsupportedEncodingException {
        byte[] encoded_input = Charset.forName(encoding)
        .encode(input)
        .array();  
        return IntStream.range(0, encoded_input.length)
            .map(i -> encoded_input[i])
            .mapToObj(e -> Integer.toBinaryString(e ^ 255))
            .map(e -> String.format("%1$" + Byte.SIZE + "s", e).replace(" ", "0"))
            .collect(Collectors.joining(" "));
    }
}
