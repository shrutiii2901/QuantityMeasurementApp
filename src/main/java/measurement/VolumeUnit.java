
public enum VolumeUnit implements IMeasurable {

    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double toLitre;

    VolumeUnit(double toLitre) {
        this.toLitre = toLitre;
    }

    public double convertToBaseUnit(double value) {
        return value * toLitre;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toLitre;
    }
}