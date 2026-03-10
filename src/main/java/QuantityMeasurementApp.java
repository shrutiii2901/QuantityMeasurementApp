public class QuantityMeasurementApp {

    public static void main(String[] args) {

       
        // Weight Equality
        

        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println(w1.equals(w2));

        QuantityWeight w3 = new QuantityWeight(2.20462, WeightUnit.POUND);

        System.out.println(w1.equals(w3));

        
        // Conversion
        

        System.out.println(w1.convertTo(WeightUnit.GRAM));

        QuantityWeight w4 = new QuantityWeight(2.0, WeightUnit.POUND);

        System.out.println(w4.convertTo(WeightUnit.KILOGRAM));

        
        // Addition
        

        QuantityWeight w5 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w6 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println(w5.add(w6));

        System.out.println(w5.add(w6, WeightUnit.GRAM));

        QuantityWeight w7 = new QuantityWeight(1.0, WeightUnit.POUND);
        QuantityWeight w8 = new QuantityWeight(453.592, WeightUnit.GRAM);

        System.out.println(w7.add(w8, WeightUnit.POUND));
    }
}