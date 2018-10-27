package calc;

/**
 * Created by gorchakov on 10.10.2018.
 */
public class Calculator {

    public double division(String a, String b) {
        return Double.parseDouble(a) / Double.parseDouble(b);
    }

    public double sum(String a, String b) {
        return Double.parseDouble(a) + Double.parseDouble(b);
    }

    public double difference(String a, String b) {
        return Double.parseDouble(a) - Double.parseDouble(b);
    }

    public double multiplication(String a, String b) {
        return Double.parseDouble(a) * Double.parseDouble(b);
    }

}
