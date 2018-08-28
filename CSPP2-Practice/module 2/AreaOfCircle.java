/**
Area of circle
*/
import java.util.Scanner;
public class AreaOfCircle{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double r = reader.nextDouble();
        System.out.println(area(r));
    }
    public static double area(double r){
        return pi() * r * r;
    }
    public static double pi(){
        return 3.14;
    }
}
