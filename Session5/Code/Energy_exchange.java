import java.io.*;

import java.util.*;

public class Energy_exchange {

	static Scanner sc;
	static PrintWriter pw;

	public static void main(String[] args) throws IOException {
		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		int n = sc.nextInt(), k = sc.nextInt();
		int[] arr = sc.nextIntArray(n);
		double max = 0;

		for (int x : arr) {
			max = Math.max(max, x);
		}

		double l = 0, r = max;

		double ans = 0;

		while (r - l > 1e-7) {

			double mid = (l + r) / 2;

			double extra = 0, need = 0;
			for (int x : arr) {
				if (x >= mid) {
					extra += x - mid;
				} else {
					need += mid - x;
				}
			}

			extra -= extra * k / 100;

			if (extra >= need) {
				ans = mid;
				l = mid + 1e-7;
			} else {
				r = mid - 1e-7;
			}

		}

		System.out.printf("%.7f", ans);
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
