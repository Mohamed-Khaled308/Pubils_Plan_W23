
import java.io.*;
import java.util.*;

public class Minimize_the_error {
	static PrintWriter pw;
	static Scanner sc;

	public static void main(String[] args) throws Exception {
		pw = new PrintWriter(System.out);
		sc = new Scanner(System.in);
		int n = sc.nextInt(), k1 = sc.nextInt(), k2 = sc.nextInt();
		int k = k1 + k2;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int[] a = sc.nextIntArray(n); // I added this method to the scanner to read an int array
		int[] b = sc.nextIntArray(n);
		for (int i = 0; i < n; i++)
			pq.add(Math.abs(a[i] - b[i]));
		long res = 0;
		while (k > 0 && !pq.isEmpty() && pq.peek() > 0) {
			int num = pq.poll();
			num--;
			k--;
			pq.add(num);
		}
		while (!pq.isEmpty()) {
			int num = pq.poll();
			res += 1l * num * num;
		}
		if (k % 2 == 1)
			res++;
		pw.println(res);
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
