import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Power {
    public static void main(String[] args) {
        Power p = new Power();
        System.out.println(p.pow(2, 50));
        System.out.println(p.powRecursion(2, 50));
    }

    public long pow (int number, int power) {
        long result = 1L;
        for (int i=1; i <= power; i++) {
            result *= number;
        }
        return result;
    }

    public long powRecursion (int number, int power) {
        if (power == 1) {
            return number;
        } else {
            return number*powRecursion(number, power-1);
        }
    }

}
