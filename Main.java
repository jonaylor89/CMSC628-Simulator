
public class Main {

    private static double N = 10.0;
    private static double K = 5.0;
    private static double L = 1.0;
    private static double v = 100.0;
    private static double tStop = 0.0;
    private static double vrd = 1.27;
    private static double pm = 1.0;

    public static void main(String[] argv) {

        // Create Torus
        Torus torus = new Torus(100);
        torus.run();

        System.out.println("Expected ET " + hittingTime());
        System.out.println("Expected EM " + meetingTime());
    }

    public static double hittingTime() {
        return (N / (2 * K * L)) * ((L / v) + tStop);
    }

    public static double meetingTime() {
        return hittingTime() / ((pm * vrd) + (2 * (1 - pm)));
    }
}