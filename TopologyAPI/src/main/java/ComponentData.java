
public class ComponentData {
    private double defaultNum;
    private int min;
    private int max;

    public ComponentData(double defaultNum, int min, int max) {
        this.defaultNum = defaultNum;
        this.min = min;
        this.max = max;
    }

    public double getDefaultNum() {
        return defaultNum;
    }

    public void setDefaultNum(double defaultNum) {
        this.defaultNum = defaultNum;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
