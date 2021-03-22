
public class Torus {

    private static int maxFrames = 10_000;
    private static int nodeRadius = 5;

    public int width;
    public int height;
    public int frame;

    private Node nodes[];

    public Torus(int N) {
        this.frame = 0;

        // Add nodes to torus
        this.nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            this.nodes[i] = new Node(nodeRadius, this.height, this.width, false);
        }
    }

    /**
     * Run simulator
     * 
     * @return : number of frames it took for there to be an intersection
     */
    public int run() {
        for (int i = 0; i < maxFrames; i++) {
            this.frame++;
            boolean stop = this.update();

            if (stop) {
                return this.frame;
            }
        }
    }

    /**
     * Update nodes according to mobility model and check for intersections
     * 
     * @return : if there was an intersect in that frame
     */
    public boolean update() {
        // Update frame;
        for (int i = 0; i < this.nodes.length; i++) {
            for (int j = 0; j < this.nodes.length; j++) {
                boolean touching = intersecting(this.nodes[i], this.nodes[j]);

                if (touching) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean intersecting(Node n1, Node n2) {
        double nodeDist = dist(n1, n2);

        return nodeDist < nodeRadius;
    }

    private static double dist(Node n1, Node n2) {
        return Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2);
    }

}
