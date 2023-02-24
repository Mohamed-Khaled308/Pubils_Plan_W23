import java.io.*;
import java.util.*;

public class Boy_or_Girl {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		String s = sc.next();

		// we need to count the number of distinct characters
		// we can build the frequency array and check for ith character
		// if its frequency is not 0 so we add 1 to the number of distinct chars

		int[] frequenyArray = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			frequenyArray[c - 'a']++;
		}

		int distinct = 0;
		for (int i = 0; i < 26; i++) {
			if (frequenyArray[i] != 0) {
				distinct++;
			}
		}

		if (distinct % 2 == 1) {
			pw.println("IGNORE HIM!");
		} else {
			pw.println("CHAT WITH HER!");
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
