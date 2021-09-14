import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class A {
    static void solve() {
		HashMap<String, String> vocab = new HashMap<>();
		vocab.put("AUU", "I"); 
		vocab.put("AUC", "I"); 
		vocab.put("AUA", "I"); 
		vocab.put("AUG", "M"); 
		vocab.put("ACU", "T"); 
		vocab.put("ACC", "T"); 
		vocab.put("ACA", "T"); 
		vocab.put("ACG", "T"); 
		vocab.put("AAU", "N"); 
		vocab.put("AAC", "N"); 
		vocab.put("AAA", "K"); 
		vocab.put("AAG", "K"); 
		vocab.put("AGU", "S"); 
		vocab.put("AGC", "S"); 
		vocab.put("AGA", "R"); 
		vocab.put("AGG", "R"); 
		vocab.put("UUU", "F");    
		vocab.put("UUC", "F");    
		vocab.put("UUA", "L");    
		vocab.put("UUG", "L");    
		vocab.put("UCU", "S");    
		vocab.put("UCC", "S");    
		vocab.put("UCA", "S");    
		vocab.put("UCG", "S");    
		vocab.put("UAU", "Y");    
		vocab.put("UAC", "Y");    
		vocab.put("UAA", "Stop"); 
		vocab.put("UAG", "Stop");
		vocab.put("UGU", "C");    
		vocab.put("UGC", "C");    
		vocab.put("UGA", "Stop");
		vocab.put("UGG", "W");    
		vocab.put("CUU", "L"); 
		vocab.put("CUC", "L"); 
		vocab.put("CUA", "L"); 
		vocab.put("CUG", "L"); 
		vocab.put("CCU", "P"); 
		vocab.put("CCC", "P"); 
		vocab.put("CCA", "P"); 
		vocab.put("CCG", "P"); 
		vocab.put("CAU", "H"); 
		vocab.put("CAC", "H"); 
		vocab.put("CAA", "Q"); 
		vocab.put("CAG", "Q"); 
		vocab.put("CGU", "R"); 
		vocab.put("CGC", "R"); 
		vocab.put("CGA", "R"); 
		vocab.put("CGG", "R"); 
		vocab.put("GUU", "V");
		vocab.put("GUC", "V");
		vocab.put("GUA", "V");
		vocab.put("GUG", "V");
		vocab.put("GCU", "A");
		vocab.put("GCC", "A");
		vocab.put("GCA", "A");
		vocab.put("GCG", "A");
		vocab.put("GAU", "D");
		vocab.put("GAC", "D");
		vocab.put("GAA", "E");
		vocab.put("GAG", "E");
		vocab.put("GGU", "G");
		vocab.put("GGC", "G");
		vocab.put("GGA", "G");
		vocab.put("GGG", "G");
		String s = ns();
		for (int i = 0; i < s.length(); i += 3) {
			String nowProt = vocab.get(s.substring(i, i + 3));
			if (nowProt == "Stop") return;
			out.print(nowProt);
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
