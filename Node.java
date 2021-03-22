
import java.util.Random;

public class Node {

    public int x;
    public int y;
    public int radius;
    public boolean isStatic;
    
    private int maxHeight;
    private int maxWidth;

    public Node(int radius, int maxHeight, int maxWidth, boolean isStatic) {
        Random random = new Random();

        this.x = random.nextInt(maxWidth);
        this.y = random.nextInt(maxHeight);
        this.radius = radius;

        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;

        this.isStatic = isStatic;
    }

    public void update() {
        if (this.isStatic) {
            return;
        }

        // Move the node
    }
}
