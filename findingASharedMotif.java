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
		sc.next();
		int flow = 0;
		TreeMap<String, Integer> subString = new TreeMap<>();
		while (sc.hasNext()) {
			flow++;
			HashMap<String, Boolean> substringYgUdah = new HashMap<>();
			String s = "";
			while (sc.hasNext()) {
				String masuk = sc.next();
				if (masuk.charAt(0) == '>') break;
				s += masuk;
			}	
			if (flow == 1) {				 
				for (int i = 0; i < s.length(); i++) {
					String walk = "";
					for (int j = i; j >= 0; j--) {
						walk = s.charAt(j) + walk;
						subString.put(walk, 1);
					}
				}	
			}
			{
				for (int i = 0; i < s.length(); i++) {
					String walk = "";
					for (int j = i; j >= 0; j--) {
						walk = s.charAt(j) + walk;
						if (!substringYgUdah.containsKey(walk)) {
							if (subString.containsKey(walk)) subString.put(walk, subString.get(walk) + 1);
							substringYgUdah.put(walk, true);
						}
					}
				}	
			}
		}
		String res = "";
		while (!subString.isEmpty()) {
			String s = subString.firstKey();
			// err.println(" >> " + subString.get(s));
			if (subString.get(s) == flow) {			
				if (s.length() > res.length()) {
					res = s;
				}	
			}
			subString.pollFirstEntry();
		}
		out.println(res);
    }    

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int t;// = ni();
        t = 1;
        while (t-- > 0) solve(); 
        err.println("Time elapsed : " + (System.currentTimeMillis() - time) / 1000F + " s.");
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
