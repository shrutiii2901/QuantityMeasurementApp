public enum LengthUnit {

    FEET(1.0),              
    INCHES(1.0 / 12.0),       
    YARDS(3.0),                
    CENTIMETERS(0.393701 / 12.0); 

    private double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toFeet(double value) {
        return value * conversionFactor;
    }
}