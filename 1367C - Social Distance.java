import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        InputReader sc = new InputReader(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(),k=sc.nextInt();
            String s=sc.next();
            int count=0;
            LinkedList<Integer> ll=new LinkedList<>();
            ll.add(1-k-1);
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1')ll.add(i+1);
            }
            ll.add(n+k+1);
            int one=ll.removeFirst();
            int two;
            while(!ll.isEmpty()){
                two=ll.removeFirst();
                int tempOne=one+k+1;
                int temptwo=two-k-1;
                if(temptwo>=tempOne){
                    count+=(int)Math.ceil((temptwo-tempOne+1)/(k+1.0));
                }
                one=two;
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
}
/*********************************************************************************
 ----------------------------------SOLUTION END-----------------------------------
 *********************************************************************************/
class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public InputReader(InputStream stream) {
        this.stream = stream;
    }
    public int read() {
        if (numChars==-1) throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try { numChars = stream.read(buf); }
            catch (IOException e) { throw new InputMismatchException(); }

            if(numChars <= 0) return -1;
        }
        return buf[curChar++];
    }
    public String nextLine() {
        String str = "";
        try { str = br.readLine(); }
        catch (IOException e) { e.printStackTrace(); }
        return str;
    }
    public int nextInt() {
        int c = read();
        while(isSpaceChar(c)) c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if(c<'0'||c>'9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c));
        return res * sgn;
    }
    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c));
        return res * sgn;
    }
    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') return res * Math.pow(10, nextInt());
            if (c < '0' || c > '9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9') throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }
    public String readString() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        StringBuilder res = new StringBuilder();
        do { res.appendCodePoint(c);c = read();}
        while (!isSpaceChar(c));
        return res.toString();
    }
    public boolean isSpaceChar(int c) {
        if (filter != null) return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
    public String next() { return readString();}
    public interface SpaceCharFilter { public boolean isSpaceChar(int ch);}
}