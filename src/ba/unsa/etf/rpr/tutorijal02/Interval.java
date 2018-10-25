package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double left, right;
    private boolean leftInclude,rightInclude;

    public Interval(double left, double right, boolean leftInclude, boolean rightInclude) {
        this.left = left;
        this.right = right;
        this.leftInclude = leftInclude;
        this.rightInclude = rightInclude;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getRight() {
        return right;
    }

    public void setRight(double right) {
        this.right = right;
    }

    public boolean isLeftInclude() {
        return leftInclude;
    }

    public void setLeftInclude(boolean leftInclude) {
        this.leftInclude = leftInclude;
    }

    public boolean isRightInclude() {
        return rightInclude;
    }

    public void setRightInclude(boolean rightInclude) {
        this.rightInclude = rightInclude;
    }

    public static Interval intersect(Interval i, Interval i2) {
        Interval temp;
        if(Double.compare(i.getLeft(),i2.getLeft()) > 0)
        {
            temp=i;
            i=i2;
            i2=temp;
        }
        if(Double.compare(i2.getLeft(),i.getLeft())<=0 &&
                Double.compare(i.getRight(),i2.getRight())<=0 ){

        }
    }


    public boolean isIn(double v) {

    }

    public boolean isNull() {
    }
}
