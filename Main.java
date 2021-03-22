
public class Main {

    private static int N = 16;
    private static int K = 5;
    private static double L = 1.0;
    private static double v = 100.0;
    private static double tStop = 0.0;
    private static double vrd = 1.27;
    private static double pm = 1.0;

    public static void main(String[] argv) {

        // Create Torus
        Torus torus = new Torus((int) Math.sqrt(N), (int) Math.sqrt(N));
        // Add nodes to torus
        torus.nodes = new Node[2];
        for (int i = 0; i < 2; i++) {
            torus.nodes[i] = new Node(K, (int) Math.sqrt(N), (int) Math.sqrt(N), false);
        }
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