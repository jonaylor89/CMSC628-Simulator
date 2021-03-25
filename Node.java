
import java.util.Random;

public class Node {

    public int x;
    public int y;
    public int radius;
    public int speed;
    public boolean isStatic;

    private int maxHeight;
    private int maxWidth;

    private Random rand;

    public Node(int radius, int speed, int maxHeight, int maxWidth, boolean isStatic) {
        this.rand = new Random();

        this.x = this.rand.nextInt(maxWidth);
        this.y = this.rand.nextInt(maxHeight);

        this.radius = radius;
        this.speed = speed;

        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;

        this.isStatic = isStatic;
    }

    public void update() {
        if (this.isStatic) {
            return;
        }

        // move the node
        int direction = this.rand.nextInt(4);
        switch (direction) {
            case 0: // UP
                this.y += this.speed;
                break;
            case 1: // RIGHT
                this.x += this.speed;
                break;
            case 2: // DOWN
                this.y -= this.speed;
                break;
            case 3: // LEFT
                this.x -= this.speed;
                break;
        }

        // check bounds
        if (this.x > this.maxWidth) {
            this.x = 0;
        }

        if (this.x < 0) {
            this.x = this.maxWidth;
        }

        if (this.y > this.maxHeight) {
            this.y = 0;
        }

        if (this.y < 0) {
            this.y = this.maxHeight;
        }

    }
}
