public class IntergerTest {


    public static void main(String[] a) {
        System.out.println(d(8, 9)); // correct move it
        System.out.println(d(-8, 9)); // incorrect dont movie
        System.out.println(d(8, -9)); // incorrect dont move
        System.out.println(d(-8, -9)); // incorrect dont move
    }

    public static boolean s(int i, int j) {
        return i > -1 && j > -1;
    }

    public static boolean d(int i, int j) {
        return i > -1 || j > -1;
    }
}
