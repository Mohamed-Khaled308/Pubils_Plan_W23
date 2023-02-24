import java.io.*;
import java.util.*;

public class Pangram {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		int length = sc.nextInt();
		String s = sc.next();
		
		// since the string may contain uppercase letters we can transform them to lowercase
		// to be easy to check
		
		s = s.toLowerCase();

		// we need to check whether we have all the 26 characters or not
		// we can build the frequency array and make sure that the frequency of every
		// character is not 0

		int[] frequenyArray = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			frequenyArray[c - 'a']++;
		}

		boolean flag = true;
		for (int i = 0; i < 26; i++) {
			flag &= frequenyArray[i] != 0;
		}

		pw.println(flag ? "YES" : "NO");

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
