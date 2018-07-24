package ru.job4j.figures;

public class Tringle implements Shape {
    @Override
    public String draw() {
        StringBuilder picture = new StringBuilder();
        picture.append("   X   " + "\n");
        picture.append("  XXX  " + "\n");
        picture.append(" XXXXX " + "\n");
        picture.append("XXXXXXX");
        return picture.toString();
    }

    public static void main(String[] args) {
        Tringle tringe = new Tringle();
        System.out.println(tringe.draw());
        }
    }
