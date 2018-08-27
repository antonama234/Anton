package ru.job4j.figures;

public class Tringle implements Shape {
    @Override
    public String draw() {
        StringBuilder picture = new StringBuilder();
        String ls = System.lineSeparator();
        picture.append("   X   ");
        picture.append(ls);
        picture.append("  XXX  ");
        picture.append(ls);
        picture.append(" XXXXX ");
        picture.append(ls);
        picture.append("XXXXXXX");
        return picture.toString();
    }

    public static void main(String[] args) {
        Tringle tringe = new Tringle();
        System.out.println(tringe.draw());
        }
    }
