import java.io.*;
import java.util.*;

public class Following_Directions {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		int testCases = sc.nextInt();
		while (testCases-- > 0) { // testcases-- > 0 is the same as writing testcases-- inside the loop

			int length = sc.nextInt();
			String s = sc.next();

			int x = 0, y = 0; // initially we are at (0, 0)

			boolean flag = false;

			for (int i = 0; i < length; i++) {

				if (s.charAt(i) == 'U') { // if we go up the y coordinate will increase by 1
					y++;
				} else if (s.charAt(i) == 'R') { // if we go right the x coordinate will increase by 1
					x++;
				} else if (s.charAt(i) == 'D') { // if we go down the y coordinate will decrease by 1
					y--;
				} else { // if it's not 'U','R','D' it should be 'L' so decrease x by 1
					x--;
				}

				if (x == 1 && y == 1) { // we reached our goal
					flag = true;
					break;
				}

			}
			pw.println(flag ? "YES" : "NO");
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

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
