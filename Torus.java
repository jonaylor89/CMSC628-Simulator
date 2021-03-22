
public class Torus {

    private static int maxFrames = 100;

    public int width;
    public int height;
    public int frame;

    private Node nodes[];

    public Torus(int N) {
        this.frame = 0;

        // Add nodes to torus
        this.nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            this.nodes[i] = new Node(5, this.height, this.width);
        }
    }

    public void run() {
        for (int i = 0; i < maxFrames; i++) {
            this.frame++;
            this.update();
        }
    }

    public void update() {
        // Update frame;
    }

}
