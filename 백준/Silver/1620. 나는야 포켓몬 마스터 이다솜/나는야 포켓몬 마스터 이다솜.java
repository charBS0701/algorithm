import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNM = br.readLine().split(" ");
        int N = Integer.parseInt(inputNM[0]);
        int M = Integer.parseInt(inputNM[1]);

        Map<String, Integer> nameToNumber = new HashMap<>();
        Map<Integer, String> numberToName = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            nameToNumber.put(pokemon, i);
            numberToName.put(i, pokemon);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String question = br.readLine();

            if (Character.isDigit(question.charAt(0))) {
                // If the first character is a digit, it's a number.
                int number = Integer.parseInt(question);
                sb.append(numberToName.get(number)).append("\n");
            } else {
                // Otherwise, it's a name.
                sb.append(nameToNumber.get(question)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
