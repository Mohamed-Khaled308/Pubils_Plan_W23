import java.io.*;
import java.util.*;

public class Nour_is_a_young_boy {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		long number = sc.nextLong();

		int even = 0, odd = 0, prime = 0;

		// we can get the first digit of the number by taking modulo 10 : firstDigit = n % 10
		// so we will check for the first digit after that we will divide the number by
		// 10 to get next digit

		while (number > 0) {
			
			long firstDigit = number % 10;

			if (firstDigit % 2 == 0) {
				even++;
			} else {
				odd++;
			}

			if (firstDigit == 2 || firstDigit == 3 || firstDigit == 5 || firstDigit == 7) {
				prime++;
			}
			
			number /= 10;
		}

		pw.println(even + " " + odd + " " + prime);

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
