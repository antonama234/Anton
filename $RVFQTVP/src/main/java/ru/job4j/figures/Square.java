package ru.job4j.figures;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder picture = new StringBuilder();
        String ls = System.lineSeparator();
        picture.append("XXXXX");
        picture.append(ls);
        picture.append("X   X");
        picture.append(ls);
        picture.append("X   X");
        picture.append(ls);
        picture.append("X   X");
        picture.append(ls);
        picture.append("XXXXX");
        return picture.toString();
    }

    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square.draw());
    }
}
