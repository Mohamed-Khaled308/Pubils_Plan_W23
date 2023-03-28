
import java.io.*;
import java.util.*;

public class Summarize_to_the_Power_of_Two {
	static PrintWriter pw;
	static Scanner sc;

	public static void main(String[] args) throws Exception {
		pw = new PrintWriter(System.out);
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		HashMap<Integer, Integer> hMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			hMap.put(arr[i], hMap.getOrDefault(arr[i], 0) + 1);
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			boolean keep = false;
			for (int j = 0; j < 31; j++) {
				int num = (1 << j) - arr[i];
				if (num == arr[i] && hMap.get(num) > 1 || num != arr[i] && hMap.containsKey(num)) {
					keep = true;
					break;
				}
			}
			if (!keep)
				res++;
		}
		pw.println(res);
		pw.flush();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String readAllLines(BufferedReader reader) throws IOException {
			StringBuilder content = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				content.append(line);
				content.append(System.lineSeparator());
			}

			return content.toString();
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}
