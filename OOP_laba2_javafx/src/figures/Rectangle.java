package figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Rectangle{
    private final Point rec_start_point = new Point();
    private final int width;
    private final int height;
    private final Color rec_color;
    private boolean v;
    private final String id;

    public Rectangle()
    {
        int x = (int) (Math.random() * 1300);
        int y = (int) (Math.random() * 880);
        this.rec_start_point.Set(x, y);
        this.width = (int) (Math.random() * (1300 - x));
        this.height = (int) (Math.random() * (800 - y));
        Random rand = new Random();
        int r = rand.nextInt(254) + 1;
        int g = rand.nextInt(254) + 1;
        int b = rand.nextInt(254) + 1;
        this.rec_color = Color.rgb(r, g, b);
        id = "Rectangle " + "X: " + rec_start_point.GetX() + " Y: " + rec_start_point.GetY();
        this.v = true;
    }
    public Rectangle(int x, int y, int width, int height, Color rec_color)
    {
        this.rec_start_point.Set(x, y);
        this.width = width;
        this.height = height;
        this.rec_color = rec_color;
        this.v = true;
        id = "Rectangle " + "X: " + rec_start_point.GetX() + " Y: " + rec_start_point.GetY();
    }

    public void Show(GraphicsContext g, boolean visibility)
    {
        this.v = visibility;
        if (v){
            g.setFill(rec_color);
            g.fillRect(rec_start_point.GetX(), rec_start_point.GetY(), width, height);
        }
    }

    public void MoveTo(int dx, int dy)
    {
        if ((dx > 0) && ((this.rec_start_point.GetX() + this.width + dx) > 1295))
            dx = 1295 - this.width - this.rec_start_point.GetX();
        else if ((dx < 0) && ((this.rec_start_point.GetX() + dx) < 0))
            dx = - this.rec_start_point.GetX() + 5;
        if ((dy > 0) && ((this.rec_start_point.GetY() + this.height + dy) > 875))
            dy = 840 - this.height - this.rec_start_point.GetY();
        else if ((dy < 0) && ((this.rec_start_point.GetY() + dy) < 0))
            dy = -this.rec_start_point.GetY() + 5;
        rec_start_point.Set(rec_start_point.GetX() + dx, rec_start_point.GetY() + dy);
    }

    public boolean getV()
    {
        return v;
    }

    public void setV(boolean v)
    {
        this.v = v;
    }

    public String getId()
    {
        return id;
    }

}