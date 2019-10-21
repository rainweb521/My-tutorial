package com.rain.demo1;

public class Beverage1 {
    private String description ;
    private boolean milk ;
    private boolean soy ;
    private boolean mocha ;
    private boolean whip ;

    private double milkCost;
    private double sonyCost;
    private double mochaCost;
    private double whipCost;
    public double cost(){
        double money = 0.0;
        if (isMilk()){
            money += milkCost;
        }
        if (isMocha()){
            money += mochaCost;
        }
        if (isSoy()){
            money += sonyCost;
        }
        if (isWhip()){
            money += whipCost;
        }
        return money;
    }
    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    public void setWhip(boolean whip) {
        this.whip = whip;
    }

    public boolean isMilk() {
        return milk;
    }

    public boolean isMocha() {
        return mocha;
    }

    public boolean isSoy() {
        return soy;
    }

    public boolean isWhip() {
        return whip;
    }

    public String getDescription() {
        return description;
    }

}
