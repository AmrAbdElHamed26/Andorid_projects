package com.example.caffeapp;

public class Drinks {
    private String name ;
    private String description ;
    private int image ;


    public static final Drinks [] drinks = {
            new Drinks("Latte" , "A couple of espresso shots with steamed milk" , R.drawable.latte ),
            new Drinks("Cappuccino", "Espresso, hot milk, and a steamed milk foam",R.drawable.cappuccino),
            new Drinks("Filter", "Highest quality beans roasted and brewed fresh",R.drawable.filter)
    };


    private Drinks (String name , String description,int image){
        this.name = name ;
        this.description =description;
        this.image = image;
    }
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description ;
    }

    public int getImage() {
        return image;
    }

    public String toString(){
        return this.name ;
    }
}
