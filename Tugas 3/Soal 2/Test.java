public class Test {
    public static void main(String[] args) {

        Shape s = new Shape("yellow", true);
        System.out.println(s);

        Circle c = new Circle(2.0, "blue", false);
        System.out.println(c);
        System.out.println("Area = " + c.getArea());
        System.out.println("Perimeter = " + c.getPerimeter());

        Rectangle r = new Rectangle(2.0, 3.0, "green", true);
        System.out.println(r);
        System.out.println("Area = " + r.getArea());
        System.out.println("Perimeter = " + r.getPerimeter());

        Square sq = new Square(4.0, "red", true);
        System.out.println(sq);
        System.out.println("Area = " + sq.getArea());
        System.out.println("Perimeter = " + sq.getPerimeter());

    }
}