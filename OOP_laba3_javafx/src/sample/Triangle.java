package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class Triangle {
    private final Point point_1;
    private final Point point_2;
    private final Point point_3;
    private final Color tr_color;
    private final String id;
    private boolean v;

    public Triangle()
    {
        int x_1 = (int) (Math.random() * 1300);
        System.out.println(x_1);
        int y_1 = (int) (Math.random() * 800);
        System.out.println(y_1);
        int x_2 = (int) (Math.random() * 1300);
        int y_2 = (int) (Math.random() * 800);
        int x_3 = (int) (Math.random() * 1300);
        int y_3 = (int) (Math.random() * 800);
        point_1 = new Point(x_1, y_1);
        point_2 = new Point(x_2, y_2);
        point_3 = new Point(x_3, y_3);
        Random rand = new Random();
        int r = rand.nextInt(254) + 1;
        int g = rand.nextInt(254) + 1;
        int b = rand.nextInt(254) + 1;
        this.tr_color = Color.rgb(r, g, b);
        this.v = true;
        id = "Triangle " + "X1: " + point_1.GetX() + " Y1: " + point_1.GetY();
    }

    public String getId()
    {
        return id;
    }

    public Triangle(Point point_1, Point point_2, Point point_3, Color tr_color)
    {
        this.point_1 = point_1;
        this.point_2 = point_2;
        this.point_3 = point_3;
        this.tr_color = tr_color;
        this.v = true;
        id = "Triangle " + "X1: " + point_1.GetX() + " Y1: " + point_1.GetY();
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color tr_color){
        this.point_1 = new Point(x1,y1);
        this.point_2 = new Point(x2, y2);
        this.point_3 = new Point(x3, y3);
        this.tr_color = tr_color;
        this.v = true;
        id = "Triangle " + "X1: " + point_1.GetX() + " Y1: " + point_1.GetY();
    }

    public void Show(GraphicsContext g, boolean visibility)
    {
        this.v = visibility;
        if(v)
        {
            g.setFill(tr_color);
            g.fillPolygon(new double[]{(double)point_1.GetX(), point_2.GetX(), point_3.GetX()}, new double[]{(double)point_1.GetY(), point_2.GetY(), point_3.GetY()}, 3);
        }
    }

    public void MoveTo(int dx, int dy) {
        this.point_1.Set(point_1.GetX() + dx, point_1.GetY() + dy);
        this.point_2.Set(point_2.GetX() + dx, point_2.GetY() + dy);
        this.point_3.Set(point_3.GetX() + dx, point_3.GetY() + dy);
        if (point_1.GetX() > 1295) {
            point_1.Set(1295, point_1.GetY());
            point_2.Set(point_2.GetX() - dx, point_2.GetY());
            point_3.Set(point_3.GetX() - dx, point_3.GetY());
        }
        if (point_1.GetY() > 875) {
            point_1.Set(point_1.GetX(), 875);
            point_2.Set(point_2.GetX(), point_2.GetY() - dy);
            point_3.Set(point_3.GetX(), point_3.GetY() - dy);
        }
        if (point_2.GetX() > 1295) {
            point_2.Set(1295, point_2.GetY());
            point_1.Set(point_1.GetX() - dx, point_1.GetY());
            point_3.Set(point_1.GetX() - dx, point_3.GetY());
        }
        if (point_2.GetY() > 875) {
            point_1.Set(point_1.GetX(), point_1.GetY() - dy);
            point_2.Set(point_2.GetX(), 875);
            point_3.Set(point_3.GetX(), point_3.GetY() - dy);
        }
        if (point_3.GetX() > 1295) {
            point_1.Set(point_1.GetX() - dx, point_1.GetY());
            point_3.Set(1295, point_3.GetY());
            point_2.Set(point_2.GetX() - dx, point_2.GetY());
        }
        if (point_3.GetY() > 875) {
            point_1.Set(point_1.GetX(), point_1.GetY() - dy);
            point_3.Set(point_3.GetX(), 875);
            point_2.Set(point_2.GetX(), point_2.GetY() - dy);
        }
        if (point_1.GetX() < 0) {
            point_1.Set(0, point_1.GetY());
            point_2.Set(point_2.GetX() - dx, point_2.GetY());
            point_3.Set(point_3.GetX() - dx, point_2.GetY());
        }
        if (point_1.GetY() < 0) {
            point_1.Set(point_1.GetX(), 0);
            point_2.Set(point_2.GetX(), point_2.GetY() - dy);
            point_3.Set(point_3.GetX(), point_3.GetY() - dy);
        }
    }

    public boolean getV()
    {
        return v;
    }

    public void setV(boolean v)
    {
        this.v = v;
    }


}
