import java.util.*;
import java.io.*;

public class Sum_of_range {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		int size = sc.nextInt(), queries = sc.nextInt();

		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		// prefixSum array is an array that we build from the original array
		// every number at index i in this array represents the sum of numbers from
		// index 0 to i from the original array
		// for example:
		// arr = [3, 5, 2]
		// prefSum = [3, 3 + 5, 3 + 5 + 2] = [3, 8, 10]

		long[] prefixSum = new long[size];

		// this is how we build it
		prefixSum[0] = arr[0];
		for (int i = 1; i < size; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}

		// now we will answer the queries in O(1) time per query

		while (queries-- > 0) {
			int l = sc.nextInt(), r = sc.nextInt();
			l--; // we subtract 1 to be 0 indexed
			r--; // we subtract 1 to be 0 indexed
			
			long sumOfRange = 0;
			
			if(l == 0) { // special case because we don't need to subtract anything
				sumOfRange = prefixSum[r];
			}else { 
				sumOfRange = prefixSum[r] - prefixSum[l - 1];
			}
			
			pw.println(sumOfRange);
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
