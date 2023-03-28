import java.util.*;
import java.io.*;

public class Burning_Midnight_Oil {

	static PrintWriter pw;
	static Scanner sc;

	public static void main(String[] args) throws Exception {
		pw = new PrintWriter(System.out);
		sc = new Scanner(System.in);

		int n = sc.nextInt(), k = sc.nextInt();

		int l = 1, r = n;

		int v = 0;

		while (l <= r) {

			int mid = (l + r) >> 1;

			long sum = 0, numK = 1;
			while (mid >= numK) {
				sum += mid / numK;
				numK *= k;
			}

			if (sum >= n) {
				v = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}

		pw.println(v);

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
