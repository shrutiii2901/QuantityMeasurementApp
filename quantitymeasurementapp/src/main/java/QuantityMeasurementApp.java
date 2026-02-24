import java.util.Scanner;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first value:");
        double v1 = sc.nextDouble();

        System.out.println("Enter first unit (FEET/INCHES/YARDS/CENTIMETERS):");
        LengthUnit u1 = LengthUnit.valueOf(sc.next().toUpperCase());

        System.out.println("Enter second value:");
        double v2 = sc.nextDouble();

        System.out.println("Enter second unit (FEET/INCHES/YARDS/CENTIMETERS):");
        LengthUnit u2 = LengthUnit.valueOf(sc.next().toUpperCase());

        QuantityLength q1 = new QuantityLength(v1, u1);
        QuantityLength q2 = new QuantityLength(v2, u2);

        System.out.println("Equal : " + q1.equals(q2));

        sc.close();
    }
}