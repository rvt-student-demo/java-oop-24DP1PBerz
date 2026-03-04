package rvt.box;

public class Box implements Packable{
    private double maxWeight;
    private double combinedWeight;

    public Box(double maxWeight){
        this.maxWeight = maxWeight;
        this.combinedWeight = 0;
    }

    public double weight() {
        return this.combinedWeight;
    }

    public void add(Packable packable){
        if(this.combinedWeight + packable.weight() <= this.maxWeight){
            this.combinedWeight += packable.weight();
        }
    }

    public String toString(){
        return "Box:" + this.combinedWeight + " items, total weight "+ this.combinedWeight + " kg";
    }
}

