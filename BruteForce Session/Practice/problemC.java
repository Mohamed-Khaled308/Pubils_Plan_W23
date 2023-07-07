
import java.io.*;
import java.util.*;

public class problemC {

	static Scanner sc;
	static PrintWriter pw;

	static int n, arr[][], ans[][]; // arr[i][0] , arr[i][1]
	static boolean flag;

	static void solve(int msk, int prevVal, int idx) {

		if (flag) {
			return;
		}

		if (Integer.bitCount(msk) == n) {
			flag = true;
			for (int i = 0; i < n; i++) {
				pw.println(ans[i][0] + 1 + " " + (ans[i][1] == 0 ? "a" : "b"));
			}
		}

		for (int i = 0; i < n; i++) {
			if ((msk & (1 << i)) == 0) {
				if (prevVal == 0 || arr[i][0] == prevVal) {
					ans[idx][0] = i;
					ans[idx][1] = 0;
					solve(msk | (1 << i), arr[i][1], idx + 1);
				}
				if (prevVal == 0 || arr[i][1] == prevVal) {
					ans[idx][0] = i;
					ans[idx][1] = 1;
					solve(msk | (1 << i), arr[i][0], idx + 1);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);

		n = sc.nextInt();
		arr = new int[n][2];
		ans = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i] = new int[] { sc.nextInt(), sc.nextInt() };
		}

		flag = false;

		solve(0, 0, 0);

		pw.flush();
	}

	static class Scanner {

		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String file) throws IOException {
			br = new BufferedReader(new FileReader(file));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
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

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

	}

}
