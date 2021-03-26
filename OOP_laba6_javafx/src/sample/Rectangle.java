package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Rectangle extends TFigure{
    private final int width;
    private final int height;
    private final Color rec_color;

    public Rectangle()
    {
        super((int) (Math.random() * 1300), (int) (Math.random() * 880));
        int x = super.getX();
        int y = super.getY();
        this.width = (int) (Math.random() * (1300 - x));
        this.height = (int) (Math.random() * (800 - y));
        Random rand = new Random();
        int r = rand.nextInt(254) + 1;
        int g = rand.nextInt(254) + 1;
        int b = rand.nextInt(254) + 1;
        this.rec_color = Color.rgb(r, g, b);
        super.setId("Rectangle " + "X: " + super.getX() + " Y: " + super.getY());
        super.setV(true);
    }
    public Rectangle(int x, int y, int width, int height, Color rec_color)
    {
        super(x, y);
        this.width = width;
        this.height = height;
        this.rec_color = rec_color;
        super.setV(true);
        super.setId("Rectangle " + "X: " + super.getX() + " Y: " + super.getY());
    }
    @Override
    public void Show(GraphicsContext g, boolean visibility)
    {
        super.setV(visibility);
        if (visibility){
            g.setFill(rec_color);
            g.fillRect(super.getX(),super.getY(), width, height);
        }
    }
    @Override
    public void MoveTo(int dx, int dy)
    {
        if ((dx > 0) && ((super.getX() + this.width + dx) > 1295))
            dx = 1295 - this.width - super.getX();
        else if ((dx < 0) && ((super.getX() + dx) < 0))
            dx = - super.getX() + 5;
        if ((dy > 0) && ((super.getY() + this.height + dy) > 875))
            dy = 840 - this.height - super.getY();
        else if ((dy < 0) && ((super.getY() + dy) < 0))
            dy = -super.getY() + 5;
        super.setX(super.getX() + dx);
        super.setY(super.getY() + dy);
    }
    public Color getColor()
    {
        return (rec_color);
    }
    public int getW()
    {
        return (this.width);
    }
    public int getH()
    {
        return (this.height);
    }
}