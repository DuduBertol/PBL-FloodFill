import Structures.Queue;
import Structures.Stack;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class FloodFill {
    private final Point startPoint;
    private BufferedImage image;
    private final Stack<Point> stack;
    private final Queue<Point> queue;
    private ImagePanel panel;

    public FloodFill(BufferedImage image, ImagePanel panel, int x, int y) {
        this.image = image;
        if (this.image == null){
            throw new IllegalArgumentException("tem nada aqui >:(");
        }

        this.panel = panel;
        startPoint = new Point(x, y);
        stack = new Stack<>();
        queue = new Queue<>();
    }

    private boolean isColorDifferent(int color1, int color2, int tolerance) {
        int r1 = (color1 >> 16) & 0xFF;
        int g1 = (color1 >> 8) & 0xFF;
        int b1 = color1 & 0xFF;

        int r2 = (color2 >> 16) & 0xFF;
        int g2 = (color2 >> 8) & 0xFF;
        int b2 = color2 & 0xFF;

        int difR = Math.abs(r1 - r2);
        int difG = Math.abs(g1 - g2);
        int difB = Math.abs(b1 - b2);

        return (difR + difG + difB) > tolerance;
    }

    public void stackFill() throws InterruptedException {
        int newColor = 0xFF00FF00;
        int oldColor = image.getRGB(startPoint.x, startPoint.y);

        int height = image.getHeight();
        int width = image.getWidth();

        if (oldColor == newColor) {
            return;
        }

        stack.push(startPoint);

        while (!stack.isEmpty()){
            Point point = stack.pop();
            int x = point.x;
            int y = point.y;

            //se ele bater na borda da tela ou achar uma cor diferente do fundo(borda do desenho)
            if (x < 0 || x >= width || y < 0 || y >= height || isColorDifferent(image.getRGB(x, y), oldColor, 30)) {
                continue;
            }

            image.setRGB(x, y, newColor);
            panel.repaint();
            Thread.sleep(1);

            // 4 pixels adjacentes
            stack.push(new Point(x + 1, y));
            stack.push(new Point(x-1, y));
            stack.push(new Point(x, y+1));
            stack.push(new Point(x, y-1));
        }

        try {
            ImageIO.write(image, "png", new File("assets/output.png"));
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public void queueFill() throws InterruptedException {
        int newColor = 0xFF00FF00;
        int oldColor = image.getRGB(startPoint.x, startPoint.y);

        int height = image.getHeight();
        int width = image.getWidth();

        if (oldColor == newColor) {
            return;
        }

        queue.enqueue(startPoint);

        while (!queue.isEmpty()){
            Point point = queue.dequeue();
            int x = point.x;
            int y = point.y;

            if (x < 0 || x >= width || y < 0 || y >= height || isColorDifferent(image.getRGB(x, y), oldColor, 30)) {
                continue;
            }

            image.setRGB(x, y, newColor);
            panel.repaint();
            Thread.sleep(1);

            queue.enqueue(new Point(x + 1, y));
            queue.enqueue(new Point(x-1, y));
            queue.enqueue(new Point(x, y+1));
            queue.enqueue(new Point(x, y-1));
        }

        try {
            ImageIO.write(image, "png", new File("assets/output.png"));
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}