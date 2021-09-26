import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class A {
	static class Data {
		String name = "";
		String strand = "";
		Data (String name, String strand) {
			this.name = name;
			this.strand = strand;
		}
	}
	static void tambahCekEkor (String strand, String name, HashMap<String, Vector<String>> cekEkor, Vector<Data> peserta) {
		String suffix = strand.substring(strand.length() - 3);
		if (cekEkor.get(suffix) == null) {
			cekEkor.put(suffix, new Vector<>());
		}
		cekEkor.get(suffix).add(name);
		peserta.add(new Data(name, strand));

	}
    static void solve() {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Vector<String>> cekEkor = new HashMap<>();
		Vector<Data> peserta = new Vector<>();
		String name = sc.next().substring(1);
		while (sc.hasNext()) {
			boolean last = true;
			String strand = "";
			while (sc.hasNext()) {
				String masuk = sc.next();
				if (masuk.charAt(0) == '>') {
					tambahCekEkor(strand, name, cekEkor, peserta);
					name = masuk.substring(1);
					last = false;
					break;
				}
				strand += masuk;
			}
			if (last) {
				tambahCekEkor(strand, name, cekEkor, peserta);
			}
		}
		for (Data x : peserta) {
			String preffix = x.strand.substring(0, 3);
			if (cekEkor.get(preffix) != null) {
				for (String s : cekEkor.get(preffix)) {
					if (s != x.name) out.println(s + " " + x.name);
				}
			}	
		}
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
