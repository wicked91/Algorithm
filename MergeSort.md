## MergeSort(boj 1427)

```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, size;
	static int arr[];

	public static void Divide(int startIndex, int endIndex) {
		if (endIndex - startIndex < 1)
			return;

		int midIndex = (startIndex + endIndex) / 2;
		Divide(startIndex, midIndex);
		Divide(midIndex + 1, endIndex);
		Conquer(startIndex, midIndex, endIndex);
	}

	public static void Conquer(int startIndex, int midIndex, int endIndex) {

		int Left = startIndex;
		int Right = midIndex + 1;
		int destIndex = 0;
		int Destination[] = new int[endIndex - startIndex + 1];

		while (Left <= midIndex && Right <= endIndex) {
			if (arr[Left] > arr[Right]) {
				Destination[destIndex++] = arr[Left++];
			} else {
				Destination[destIndex++] = arr[Right++];
			}
		}

		while (Left <= midIndex) {
			Destination[destIndex++] = arr[Left++];
		}

		while (Right <= endIndex) {
			Destination[destIndex++] = arr[Right++];
		}

		destIndex = 0;

		for (int i = startIndex; i <= endIndex; i++) {
			arr[i] = Destination[destIndex++];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		size = input.length();
		arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(input.charAt(i) + "");
		}
		Divide(0, size - 1);

		for (int i = 0; i < size; i++) {
			System.out.print(arr[i]);
		}
	}
}
```
