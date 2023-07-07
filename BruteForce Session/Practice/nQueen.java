import java.io.*;
import java.util.*;

public class nQueen {

	static Scanner sc;
	static PrintWriter pw;

	static int n, row[], col[], d1[], d2[];

	static int solve(int currRow) {
		if (currRow == n) {
			return 1;
		}

		int ans = 0;
		
		for (int column = 0; column < n; column++) {
			if (row[currRow] == 0 && col[column] == 0 && d1[n + currRow - column] == 0 && d2[currRow + column] == 0) {
				row[currRow] = 1;
				col[column] = 1;
				d1[n + currRow - column] = 1;
				d2[currRow + column] = 1;
				
				ans += solve(currRow + 1);
				
				row[currRow] = 0;
				col[column] = 0;
				d1[n + currRow - column] = 0;
				d2[currRow + column] = 0;
				
			}
		}
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);

		n = sc.nextInt();
		row = new int[n];
		col = new int[n];
		d1 = new int[2 * n];
		d2 = new int[2 * n];

		pw.println(solve(0));

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
