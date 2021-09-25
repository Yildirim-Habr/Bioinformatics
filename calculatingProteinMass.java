import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class A {
    static void solve() {
		Scanner sc = new Scanner(System.in);
		String s = "";
		while (sc.hasNext()) {
			s += sc.next();
		}
		HashMap<Character, Double> pair = new HashMap<>();
		pair.put('A', 71.03711 );
		pair.put('C', 103.00919);
		pair.put('D', 115.02694);
		pair.put('E', 129.04259);
		pair.put('F', 147.06841);
		pair.put('G', 57.02146 );
		pair.put('H', 137.05891);
		pair.put('I', 113.08406);
		pair.put('K', 128.09496);
		pair.put('L', 113.08406);
		pair.put('M', 131.04049);
		pair.put('N', 114.04293);
		pair.put('P', 97.05276 );
		pair.put('Q', 128.05858);
		pair.put('R', 156.10111);
		pair.put('S', 87.03203 );
		pair.put('T', 101.04768);
		pair.put('V', 99.06841 );
		pair.put('W', 186.07931);
		pair.put('Y', 163.06333);
		Double res = 0.0;
		for (char chs : s.toCharArray()) {
			res += pair.get(chs);
		}
		out.printf("%.3f\n", res);
    }    

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int t;// = ni();
        t = 1;
        while (t-- > 0) solve(); 
        err.println("\nTime elapsed : " + (System.currentTimeMillis() - time) / 1000F + " s.\n");
        err.close(); out.close();
    }

    static int[] radixSort(int[] f){ return radixSort(f, f.length); }
    static int[] radixSort(int[] f, int n)
    {
        int[] to = new int[n];
        {
            int[] b = new int[65537];
            for(int i = 0;i < n;i++)b[1+(f[i]&0xffff)]++;
            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
            for(int i = 0;i < n;i++)to[b[f[i]&0xffff]++] = f[i];
            int[] d = f; f = to;to = d;
        }
        {
            int[] b = new int[65537];
            for(int i = 0;i < n;i++)b[1+(f[i]>>>16)]++;
            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
            for(int i = 0;i < n;i++)to[b[f[i]>>>16]++] = f[i];
            int[] d = f; f = to;to = d;
        }
        return f;
    }

    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static PrintWriter err = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.err)));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer token;
        
    static String ns() {
        while (token == null || !token.hasMoreTokens()) {
            try {
                token = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return token.nextToken();
    }
    static char nc() {
        return Character.valueOf(ns().charAt(0));
    }
    static int ni() {
        return Integer.parseInt(ns());
    }
    static double nd() {
        return Double.parseDouble(ns());
    }
    static long nl() {
        return Long.parseLong(ns());
    }
}
// Collections Arrays Math
// Vector HashSet TreeSet HashMap TreeMap ArrayDeque
