package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ring {
    private final Circle ex_cir;
    private  final Circle in_cir;
    private boolean v;
    private final String id;

    public Ring()
    {
        ex_cir = new Circle();
        in_cir = new Circle(ex_cir.getX(), ex_cir.getY(),(int) (Math.random() * ex_cir.getR()), Color.WHITE);
        this.v = true;
        this.id = "Ring X: " + ex_cir.getX() + "Y: " + ex_cir.getY() + "R: " + ex_cir.getR();
    }

    public Ring(int x, int y, int ex_r, int in_r, Color ring_color)
    {
        ex_cir = new Circle(x, y, ex_r, ring_color);
        in_cir = new Circle(x, y, in_r, Color.WHITE);
        this.v = true;
        this.id = "Ring X: " + x + "Y: " + y + "R: " + ex_r;
    }

    public void Show(GraphicsContext g, boolean visibility)
    {
        ex_cir.Show(g, visibility);
        in_cir.Show(g, visibility);
    }

    public void MoveTo(int dx, int dy)
    {
        if (ex_cir.getX() + dx - ex_cir.getR()< 0) {
            ex_cir.setCircle_center(ex_cir.getR() + 15, ex_cir.getY() + dy);
            in_cir.setCircle_center(ex_cir.getR() + 15, in_cir.getY() + dy);
            if (ex_cir.getY() + dy - ex_cir.getR() > 0)
                return;
        }
        if (ex_cir.getY() + dy - ex_cir.getR() < 0) {
            ex_cir.setCircle_center(ex_cir.getX() + dx, ex_cir.getR());
            in_cir.setCircle_center(in_cir.getX() + dx, ex_cir.getR());
            return;
        }
        if (ex_cir.getX() + dx + ex_cir.getR() > 1295)
            dx = 1295 - ex_cir.getR() - ex_cir.getX();
        if (ex_cir.getY() + ex_cir.getR() + dy > 880)
            dy = 880 - ex_cir.getR() - ex_cir.getY();
        ex_cir.setCircle_center(ex_cir.getX() + dx, ex_cir.getY() + dy);
        in_cir.setCircle_center(in_cir.getX() + dx, in_cir.getY() + dy);
    }

    public String getId()
    {
        return id;
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
