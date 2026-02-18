
import java.util.Scanner;

public class QuantityMeasurementApp {

    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (getClass() != obj.getClass())
                return false;

            Feet other = (Feet) obj;

            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first value in feet: ");
            double value1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter second value in feet: ");
            double value2 = Double.parseDouble(scanner.nextLine());

            Feet feet1 = new Feet(value1);
            Feet feet2 = new Feet(value2);

            boolean result = feet1.equals(feet2);

            System.out.println("\nResult: " + result);

            if (result) {
                System.out.println("Equal (true)");
            } else {
                System.out.println("Not Equal (false)");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter numeric values only.");
        } finally {
            scanner.close();
        }
    }
}
