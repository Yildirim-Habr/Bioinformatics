import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class A {
	static void bfs1 (Map<Integer, Vector<Integer>> link, int[] arr, int grup, int i) {		
		Deque<Integer> antre = new ArrayDeque<>();
		antre.addLast(i);
		while (!antre.isEmpty()) {
			int now = antre.pollFirst();
			arr[now] = grup;
			if (link.containsKey(now)) for (int x : link.get(now)) {
				if (arr[x] == 0) antre.addLast(x);
			}
		}
	}
    static void solve() {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		Map<Integer, Vector<Integer>> link = new HashMap<>();
		while (sc.hasNext()) {
			int a = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());
			if (!link.containsKey(a)) link.put(a, new Vector<>());link.get(a).add(b);
			if (!link.containsKey(b)) link.put(b, new Vector<>());link.get(b).add(a);
		}
		int[] arr = new int[n + 1];
		int grup = 1;
		for (int i = 1; i <= n; i++) {
			if (arr[i] == 0) {
				bfs1(link, arr, grup, i);
				grup++;
			}
		}
		grup--;
		out.println(grup - 1);
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
