import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println(LocalDateTime.now(ZoneId.of("Asia/Seoul")).toString().substring(0,10));
	}
}
		