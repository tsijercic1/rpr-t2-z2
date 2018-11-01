package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private Double left, right;
    private Boolean leftInclude,rightInclude;

    public Interval() { }

    public Interval(double left, double right, boolean leftInclude, boolean rightInclude) {
        if(left>right)throw new IllegalArgumentException("Nekorektni parametri intervala!");
        this.left = left;
        this.right = right;
        this.leftInclude = leftInclude;
        this.rightInclude = rightInclude;
    }

    public Double getLeft() {
        return left;
    }

    public void setLeft(Double left) {
        this.left = left;
    }

    public Double getRight() {
        return right;
    }

    public void setRight(Double right) {
        this.right = right;
    }

    public Boolean isLeftInclude() {
        return leftInclude;
    }

    public void setLeftInclude(Boolean leftInclude) {
        this.leftInclude = leftInclude;
    }

    public Boolean isRightInclude() {
        return rightInclude;
    }

    public void setRightInclude(Boolean rightInclude) {
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
        temp = new Interval(0,0,false,false);
        if(Double.compare(i.getLeft(),i2.getLeft())<=0 && Double.compare(i2.getRight(),i.getRight())<=0 ){
            temp.setLeftInclude(i2.isLeftInclude());
            temp.setRightInclude(i2.isRightInclude());
            temp.setRight(i2.right);
            temp.setLeft(i2.left);

        }else if(Double.compare(i.getRight(),i2.getRight())<0 && Double.compare(i.getLeft(),i2.getRight())<0){
                temp.setLeft(i2.getLeft());
                temp.setRight(i.getRight());
                temp.setLeftInclude(i2.isLeftInclude());
                temp.setRightInclude(i.isRightInclude());
        }
        if(Double.compare(i2.getLeft(), i.getLeft()) == 0){
            temp.setLeftInclude(i.leftInclude && i2.leftInclude);
        }
        if( Double.compare(i.getRight(),i2.getRight())==0 ){
            temp.setRightInclude(i.rightInclude && i2.rightInclude);
        }

        return temp;
    }

    public Interval intersect(Interval i)
    {
        Interval temp=intersect(this, i);
        this.left=temp.left;
        this.right=temp.right;
        this.leftInclude = temp.leftInclude;
        this.rightInclude = temp.rightInclude;
        return this;
    }

    public boolean isIn(double v) {
        return (left<v&&v<right)||(Double.compare(v,left)==0 && leftInclude)||(Double.compare(v,right)==0 && rightInclude);
    }

    public boolean isNull() {
        if(left==null)return true;
        return false;
    }

    @Override
    public String toString() {
        if(isNull())return "()";
        String output="";
        if(leftInclude)output+="[";
        else output+="(";
        output+=left+","+right;
        if(rightInclude)output+="]";
        else output+=")";
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;

        Interval interval = (Interval) o;

        if (getLeft() != null ? !getLeft().equals(interval.getLeft()) : interval.getLeft() != null) return false;
        if (getRight() != null ? !getRight().equals(interval.getRight()) : interval.getRight() != null) return false;
        if (isLeftInclude() != null ? !isLeftInclude().equals(interval.isLeftInclude()) : interval.isLeftInclude() != null)
            return false;
        return isRightInclude() != null ? isRightInclude().equals(interval.isRightInclude()) : interval.isRightInclude() == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
