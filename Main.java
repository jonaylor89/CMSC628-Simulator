
import java.util.Arrays;

public class Main {

    private static int N = 10000;
    private static int K = 10;
    private static double L = 0.5214 * Math.sqrt(N);
    private static double v = 10.0;
    private static double T = 1.0;
    private static double tStop = 0.0;
    private static double vrd = 1.27;
    private static double pm = (T / (T + tStop));

    private static int NUM_OF_SIMULATIONS = 100;

    public static void main(String[] argv) {

        int simulations[] = new int[NUM_OF_SIMULATIONS];

        for (int i = 0; i < NUM_OF_SIMULATIONS; i++) {

            // Create Torus
            Torus torus = new Torus((int) Math.sqrt(N), (int) Math.sqrt(N));

            // Add nodes to torus
            torus.nodes = new Node[2];
            torus.nodes[0] = new Node(K, (int) Math.sqrt(N), (int) Math.sqrt(N), false);
            torus.nodes[1] = new Node(K, (int) Math.sqrt(N), (int) Math.sqrt(N), true);

            // for (int i = 0; i < 2; i++) {
            // torus.nodes[i] = new Node(K, (int) Math.sqrt(N), (int) Math.sqrt(N), false);
            // }

            // Run simulation
            int frames = torus.run();

            // Store result
            if (frames != -1) {
                simulations[i] = frames;
            }
        }

        double avg = Arrays.stream(simulations).average().orElse(Double.NaN);

        System.out.println("AVG: " + avg);

        System.out.println("Expected ET: " + hittingTime());
        System.out.println("Expected EM: " + meetingTime());
    }

    public static double hittingTime() {
        return (N / (2 * K * L)) * ((L / v) + tStop);
    }

    public static double meetingTime() {
        return hittingTime() / ((pm * vrd) + (2 * (1 - pm)));
    }
}