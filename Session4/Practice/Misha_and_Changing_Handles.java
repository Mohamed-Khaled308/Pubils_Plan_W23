
import java.io.*;
import java.util.*;

public class Misha_and_Changing_Handles {
	static PrintWriter pw;
	static Scanner sc;

	public static void main(String[] args) throws Exception {
		pw = new PrintWriter(System.out);
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<String, String> hMap1 = new HashMap<>(), hMap2 = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String u = sc.next(), v = sc.next();
			if (!hMap2.containsKey(u)) {
				hMap1.put(u, v);
				hMap2.put(v, u);
			} else {
				hMap1.put(hMap2.get(u), v);
				hMap2.put(v, hMap2.get(u));
				hMap2.remove(u);
			}
		}
		pw.println(hMap1.size());
		for (String u : hMap1.keySet()) {
			pw.println(u + " " + hMap1.get(u));
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
