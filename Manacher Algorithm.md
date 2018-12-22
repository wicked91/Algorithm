## Manacher Algorithm

```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int Answer;
	static int A[];
	static StringBuffer sb;

	public static void Manacher() {
		// right : 현재 회문이 끝나는 지점
		// center : 현재 회문의 중심점
		int right = 0, center = 0;

		for (int i = 0; i < sb.length(); i++) {
			// i > right의 경우 i는 회문 안에 속하는 지점이다. 따라서 i의 대칭점은 2 * center -i 가 된다.
			// 따라서 A[i]의 초기 값은 i와 right의 거리 VS i 대칭점의 회문길이(A[2 * center - i])가 된다. 
			if (i < right) {
				A[i] = Math.min(right - i, A[2 * center - i]);
			} 
			// i가 회문안에 없는 경우 A[i] = 0 이다.
			else {
				A[i] = 0;
			}

			// A[i]를 증가시켜가면서 회문의 반지름 거리를 늘려간다.
			while (i - A[i] - 1 >= 0 && i + A[i] + 1 < sb.length()
					&& sb.charAt(i - A[i] - 1) == sb.charAt(i + A[i] + 1)) {
				A[i]++;
			}

			// 현재 회문의 반지름 A[i] 와 회문의 중심 i을 더한 값이 right보다 크다면 right를 수정하고 중심을 바꾼다.
			if (right < i + A[i]) {
				right = i + A[i];
				center = i;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		sb = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			sb.append("#");
			sb.append(input.charAt(i));
		}
		sb.append("#");

		A = new int[sb.length()];
		Manacher();
		Answer = 0;
		for (int i = 0; i < sb.length(); i++) {
			Answer = Math.max(Answer, A[i]);
		}
		System.out.println(Answer);
	}
}```