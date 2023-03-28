
import java.util.*;
import java.io.*;

public class Productive_Meeting {

	static Scanner sc;
	static PrintWriter pw;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();

			PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.talks - a.talks);

			for (int i = 1; i <= n; i++) {
				int talks = sc.nextInt();
				if (talks > 0)
					pq.add(new Pair(talks, i));
			}

			StringBuilder sb = new StringBuilder();
			int cntResult = 0;

			while (pq.size() > 1) {
				Pair one = pq.poll(), two = pq.poll();
				one.talks--;
				two.talks--;
				cntResult++;
				sb.append(one.idx + " " + two.idx + "\n");
				if (one.talks > 0) {
					pq.add(one);
				}
				if (two.talks > 0) {
					pq.add(two);
				}
			}
			pw.println(cntResult);
			pw.print(sb);
		}

		pw.flush();
	}

	static class Pair {

		int talks, idx;

		public Pair(int t, int i) {
			talks = t;
			idx = i;
		}

		public String toString() {
			return "(" + talks + ", " + idx + ")";
		}

//		public int compareTo(Pair o) {
//
//			return o.talks - talks;
//		}
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
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public long[] nextlongArray(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public Long[] nextLongArray(int n) throws IOException {
			Long[] a = new Long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public Integer[] nextIntegerArray(int n) throws IOException {
			Integer[] a = new Integer[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}