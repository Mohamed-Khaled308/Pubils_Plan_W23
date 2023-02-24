import java.io.*;
import java.util.*;

public class Count_Letters {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		String s = sc.next();

		// because we just have 26 characters of alphabet we can use a frequency array
		// frequency array is an array that contains the number of occurrences of each
		// character
		// since we have 26 character then the array size will be 26
		// index 0 -> 'a'
		// index 1 -> 'b'
		// .....
		// index 25 -> 'z'

		int[] frequencyArray = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// to get the right index for any character we can just subtract 'a' from c
			// for example
			// if c = 'a', then c - 'a' = 0;
			// if c = 'b', then c - 'a' = 1;
			// .....
			// if c = 'z', then c - 'a' = 25;

			frequencyArray[c - 'a']++; // increment the frequency of this character
		}

		// now the answer is just the frequency of each character in this array

		for (int i = 0; i < 26; i++) {
			pw.println(frequencyArray[i]);
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
