
import java.io.*;
import java.util.*;

public class Ball_in_Berland {
	static PrintWriter pw;
	static Scanner sc;
	static final int mod = (int) 1e9 + 7;

	public static void main(String[] args) throws Exception {
		pw = new PrintWriter(System.out);
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt(), b = sc.nextInt(), k = sc.nextInt();
			int[] cntA = new int[a + 1], cntB = new int[b + 1]; // we can use a hashmap as a frequency array here
			int[] A = sc.nextIntArray(k);
			int[] B = sc.nextIntArray(k);
			for (int i = 0; i < k; i++) {
				cntA[A[i]]++;
				cntB[B[i]]++;
			}
			long res = 0;
			for (int i = 0; i < k; i++) {
				res += k - cntA[A[i]] - cntB[B[i]] + 1;
			}
			pw.println(res / 2); // we divided by two because we counted every pair twice
		}
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
