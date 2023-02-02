package com.java.HeadFirstJava.Array;

public class Dog {
    String name;
    public static void main(String[] args){
        //创建Dog对象
        Dog dog1 = new Dog();
        dog1.name = "Bart";
        dog1.bark();

        //创建Dog数组
        Dog[] myDogs = new Dog[3];
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        //通过数组引用存取Dog变量
        myDogs[0].name = "Fred";
        myDogs[1].name = "Alice";
        System.out.println("last dog's name is " + myDogs[2].name);

        //逐个对Dog执行bark()
        int x = 0;
        while (x < myDogs.length){
            myDogs[x].bark();
            x++;
        }
    }

    public void bark(){
        System.out.println(name + " say Ruff!");
    }

}

