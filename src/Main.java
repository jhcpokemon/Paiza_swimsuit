import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(mul("38"));
    }

    public static int mul(String data) {
        int base = Integer.parseInt(data);
        BigDecimal full = BigDecimal.ONE;
        for (int i = base; i > 1; i--) {
            full = full.multiply(BigDecimal.valueOf(i));
        }
        if (String.valueOf(full).length() > 9) {
            BigDecimal cutHead = reverse(full);
            int length = String.valueOf(cutHead).length();
            if (length >= 9) {
                BigDecimal div = new BigDecimal(String.valueOf(Math.pow(10,length-9)));
                cutHead = cutHead.divide(div,0, RoundingMode.DOWN);
            }
            cutHead = reverse(cutHead);
            return Integer.valueOf(String.valueOf(cutHead));
        }else {
            return Integer.valueOf(String.valueOf(full));
        }
    }

    public static BigDecimal reverse(BigDecimal number) {
        String s = String.valueOf(number);
        s = new StringBuilder(s).reverse().toString();
        s = s.replaceAll("^0*","");
        return new BigDecimal(s);
    }
}
