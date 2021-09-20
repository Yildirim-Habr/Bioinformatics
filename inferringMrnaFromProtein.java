import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class A {
    static void solve() {
		int[] pts = new int[26];
		pts['V' - 'A']++;
		pts['V' - 'A']++;
		pts['V' - 'A']++;
		pts['V' - 'A']++;
		pts['A' - 'A']++;
		pts['A' - 'A']++;
		pts['A' - 'A']++;
		pts['A' - 'A']++;
		pts['D' - 'A']++;
		pts['D' - 'A']++;
		pts['E' - 'A']++;
		pts['E' - 'A']++;
		pts['G' - 'A']++;
		pts['G' - 'A']++;
		pts['G' - 'A']++;
		pts['G' - 'A']++;
		pts['F' - 'A']++;                 
		pts['F' - 'A']++;                 
		pts['L' - 'A']++;                 
		pts['L' - 'A']++;                 
		pts['S' - 'A']++;                 
		pts['S' - 'A']++;                 
		pts['S' - 'A']++;                 
		pts['S' - 'A']++;                 
		pts['Y' - 'A']++;                 
		pts['Y' - 'A']++;                 
		pts['C' - 'A']++;                 
		pts['C' - 'A']++;                 
		pts['W' - 'A']++;                  
		pts['L' - 'A']++;
		pts['L' - 'A']++;
		pts['L' - 'A']++;
		pts['L' - 'A']++;
		pts['P' - 'A']++;
		pts['P' - 'A']++;
		pts['P' - 'A']++;
		pts['P' - 'A']++;
		pts['H' - 'A']++;
		pts['H' - 'A']++;
		pts['Q' - 'A']++;
		pts['Q' - 'A']++;
		pts['R' - 'A']++;
		pts['R' - 'A']++;
		pts['R' - 'A']++;
		pts['R' - 'A']++;
		pts['I' - 'A']++;
		pts['I' - 'A']++;
		pts['I' - 'A']++;
		pts['M' - 'A']++;
		pts['T' - 'A']++;
		pts['T' - 'A']++;
		pts['T' - 'A']++;
		pts['T' - 'A']++;
		pts['N' - 'A']++;
		pts['N' - 'A']++;
		pts['K' - 'A']++;
		pts['K' - 'A']++;
		pts['S' - 'A']++;
		pts['S' - 'A']++;
		pts['R' - 'A']++;
		pts['R' - 'A']++;
		String s = ns();
		long res = 1L;
		for (char chs : s.toCharArray()) {
			res *= pts[chs - 'A'];
			res %= 1000000L;
		}
		res *= 3; res %= 1000000L;
		out.println(res);
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
