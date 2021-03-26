package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class Triangle extends TFigure{
    private final Point point_2 = new Point();
    private final Point point_3 = new Point();
    private final Color tr_color;

    public Triangle() {
        super((int) (Math.random() * 1300), (int) (Math.random() * 800));
        int x_2 = (int) (Math.random() * 1300);
        int y_2 = (int) (Math.random() * 800);
        int x_3 = (int) (Math.random() * 1300);
        int y_3 = (int) (Math.random() * 800);
        point_2.Set(x_2, y_2);
        point_3.Set(x_3, y_3);
        Random rand = new Random();
        int r = rand.nextInt(254) + 1;
        int g = rand.nextInt(254) + 1;
        int b = rand.nextInt(254) + 1;
        this.tr_color = Color.rgb(r, g, b);
        super.setV(true);
        super.setId("Triangle " + "X1: " + super.getX() + " Y1: " + super.getY());
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color tr_color) {
        super(x1, y1);
        this.point_2.Set(x2, y2);
        this.point_3.Set(x3, y3);
        this.tr_color = tr_color;
        super.setV(true);
        super.setId("Triangle " + "X1: " + super.getX() + " Y1: " + super.getY());
    }

    public void Show(GraphicsContext g, boolean visibility) {
        super.setV(visibility);
        if (visibility) {
            g.setFill(tr_color);
            g.fillPolygon(new double[]{(double) super.getX(), point_2.GetX(), point_3.GetX()}, new double[]{(double) super.getY(), point_2.GetY(), point_3.GetY()}, 3);
        }
    }
    @Override
    public void MoveTo(int dx, int dy) {
        super.setX(super.getX() + dx);
        super.setY(super.getY() + dy);
        this.point_2.Set(point_2.GetX() + dx, point_2.GetY() + dy);
        this.point_3.Set(point_3.GetX() + dx, point_3.GetY() + dy);
        if (super.getX() > 1295) {
            super.setX(1295);
            point_2.Set(point_2.GetX() - 1295 - dx, point_2.GetY());
            point_3.Set(point_3.GetX() - dx, point_3.GetY());
        }
        if (super.getY() > 875) {
            super.setY(875);
            point_2.Set(point_2.GetX(), point_2.GetY() - dy);
            point_3.Set(point_3.GetX(), point_3.GetY() - dy);
        }
        if (point_2.GetX() > 1295) {
            point_2.Set(1295, point_2.GetY());
            super.setX(super.getX() - dx);
            point_3.Set(super.getX() - dx, point_3.GetY());
        }
        if (point_2.GetY() > 875) {
            super.setY(super.getY() - dy);
            point_2.Set(point_2.GetX(), 875);
            point_3.Set(point_3.GetX(), point_3.GetY() - dy);
        }
        if (point_3.GetX() > 1295) {
            super.setX(super.getX() - dx);
            point_3.Set(1295, point_3.GetY());
            point_2.Set(point_2.GetX() - dx, point_2.GetY());
        }
        if (point_3.GetY() > 875) {
            super.setY(super.getY() - dy);
            point_3.Set(point_3.GetX(), 875);
            point_2.Set(point_2.GetX(), point_2.GetY() - dy);
        }
        if (super.getX() < 0) {
            super.setX(0);
            point_2.Set(point_2.GetX() - dx, point_2.GetY());
            point_3.Set(point_3.GetX() - dx, point_2.GetY());
        }
        if (super.getY() < 0) {
            super.setY(0);
            point_2.Set(point_2.GetX(), point_2.GetY() - dy);
            point_3.Set(point_3.GetX(), point_3.GetY() - dy);
        }
    }
}

