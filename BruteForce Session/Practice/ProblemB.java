import java.io.*;
import java.util.*;

public class ProblemB {
	static Scanner sc;
	static PrintWriter pw;

	static int n, grade, tot, arr[];

	static int solveForMinSize(int idx, int sum, int cnt) {

		if (idx == n) {
			int currGrade = sum * 100 / tot;
			if (currGrade >= grade) {
				return cnt;
			} else {
				return n + 1;
			}
		}
		int take = solveForMinSize(idx + 1, sum + arr[idx], cnt + 1);
		int leave = solveForMinSize(idx + 1, sum, cnt);

		return Math.min(take, leave);
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);

		n = sc.nextInt();
		grade = sc.nextInt();
		arr = new int[n];
		tot = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			tot += arr[i];
		}

		int size = solveForMinSize(0, 0, 0);

		ArrayList<String> ans = new ArrayList<>();

		for (int msk = 0; msk < (1 << n); msk++) {
			if (Integer.bitCount(msk) == size) {
				String subset = "";
				int sum = 0;
				for (int i = 0; i < n; i++) {
					if ((msk & (1 << i)) != 0) {
						sum += arr[i];
						subset += (i + 1) + " ";
					}
				}
				int currGrade = sum * 100 / tot;
				if (currGrade >= grade) {
					ans.add(currGrade + " " + subset.trim());
				}
			}
		}

		pw.println(size + " " + ans.size());
		for (String s : ans) {
			pw.println(s);
		}

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
