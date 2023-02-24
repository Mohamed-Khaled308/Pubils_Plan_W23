import java.io.*;
import java.util.*;

public class io {

	public static void main(String[] args) throws IOException {

		// From now on we will use elsagheer scanner because it's faster than java
		// predefined one
		// to use it you just need to copy and paste it under the main method and you
		// need to add these 2 words in the main class like this
		// public static void main(String[] args) """ throws IOException """

		Scanner sc = new Scanner(System.in);

//		sc.next(); // reads a string
//		sc.nextInt(); // reads an int
//		sc.nextLong(); // reads a long
//		sc.nextDouble(); // reads a double
//		sc.nextLine(); // reads the complete line from the input

		// for printing we will use PrintWriter since it's faster than System.out
		// PrintWriter is just a buffer (memory) that stores whatever you need to print
		// when you finish you should make the PrintWriter flush whatever you have
		// printed

		PrintWriter pw = new PrintWriter(System.out);
		pw.println("Hello World!");
		pw.flush();

	}

// copy from here

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

// to here

}
