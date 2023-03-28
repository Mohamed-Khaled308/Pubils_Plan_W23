import java.util.*;
import java.io.*;

public class Binary_Search {
	static PrintWriter pw;
	static Scanner sc;
	static final int mod = (int) 1e9 + 7;

	static int findFirstOcc(int num, int[] arr) {
		int idx = -1;
		int l = 0, r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] == num) {
				idx = mid;
			}
			if (arr[mid] >= num) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return idx;
	}

	static int findLastOcc(int num, int[] arr) {
		int idx = -1;
		int l = 0, r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] == num) {
				idx = mid;
			}
			if (arr[mid] <= num) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return idx;
	}

	public static void main(String[] args) throws Exception {
		pw = new PrintWriter(System.out);
		sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = sc.nextIntArray(n);
		int target = sc.nextInt();

		pw.println(findFirstOcc(target, arr));

		pw.println(findLastOcc(target, arr));

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
