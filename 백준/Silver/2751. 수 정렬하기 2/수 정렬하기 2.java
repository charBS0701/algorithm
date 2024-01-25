import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[2_000_001];

		for (int n = 0; n < N; n++) {
			arr[Integer.parseInt(br.readLine()) + 1_000_000] = true;
		}

		int count = 0;
		for (int n = 0; n < arr.length; n++) {
			if (arr[n] != true)
				continue;
			else {
				bw.write(n - 1_000_000 + "\n");
				count++;
				if (count == N)
					break;
			}
		}
        bw.flush();
        bw.close();
	}
}