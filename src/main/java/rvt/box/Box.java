package rvt.box;

import java.util.ArrayList;

public class Box implements Packable{
    private int maxWeight;
    ArrayList<Packable> packables;

    public Box(int maxWeight){
        this.maxWeight = maxWeight;
        this.packables = new ArrayList<>();
    }

    public double weight() {
        double weight = 0;
        for (Packable packable: packables) {
            weight += packable.weight();
        }
        return weight;
    }

    public void add(Packable item){
        double itemweight = item.weight();
        if(weight() + itemweight <= this.maxWeight){
            packables.add(item);
        }
    }

    public String toString(){
        return "Box:" + packables.size() + " items, total weight "+ weight() + " kg";
    }
}

