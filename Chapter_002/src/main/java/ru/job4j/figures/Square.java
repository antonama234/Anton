package ru.job4j.figures;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder picture = new StringBuilder();
        picture.append("XXXXX" + "\n");
        picture.append("X   X" + "\n");
        picture.append("X   X" + "\n");
        picture.append("X   X" + "\n");
        picture.append("XXXXX");
        return picture.toString();
    }

    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square.draw());
    }
}
