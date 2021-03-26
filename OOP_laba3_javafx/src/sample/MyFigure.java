package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyFigure {
    private final Circle body;
    private final Circle tail;
    private final Circle eye1;
    private final Circle eye2;
    private final Rectangle tooth1;
    private final Rectangle tooth2;
    private final Triangle nose;
    private final Triangle ear1;
    private final Triangle ear2;
    private final Triangle foot2;
    private final String id;
    private boolean v;

    MyFigure(){
        body = new Circle();
        int rad = 220;
        if (rad > 880 - body.getY())
            rad = 880 - body.getY();
        if (rad > 1300 - body.getX())
            rad = 1300 - body.getX();
        if (rad > body.getX())
            rad = body.getX();
        if (rad > body.getY())
            rad = body.getY();
        this.body.setR((int) (Math.random() * rad));
        if (body.getY() - body.getR() - body.getR() < 0)
        {
            body.setCircle_center(body.getX(), body.getY() + body.getR());
        }
        if (body.getY() + body.getR() > 1300)
        {
            body.setCircle_center(body.getX(), body.getY() - body.getR());
        }
        tail = new Circle(body.getX() - body.getR() + body.getR()/5, body.getY() + body.getR() - body.getR()/3, body.getR()/3, body.getColor());
        eye1 = new Circle(body.getX() + body.getR() / 3, body.getY() - body.getR()/20, body.getR()/ 15, Color.BLACK);
        eye2 = new Circle(body.getX() + body.getR() - body.getR()/3, body.getY() - body.getR()/20, body.getR()/ 15, Color.BLACK);
        tooth1 = new Rectangle(body.getX() + body.getR() / 2 - body.getR()/10, body.getY() + body.getR()/4, body.getR()/10, body.getR()/6,Color.WHITE);
        tooth2 = new Rectangle(body.getX() + body.getR() - body.getR()/2, body.getY() + body.getR()/4, body.getR()/10, body.getR()/6,Color.WHITE);
        nose = new Triangle(body.getX() + body.getR()/3 + body.getR()/4, body.getY() + body.getR()/7, body.getX() + body.getR()/5 + body.getR()/4, body.getY() + body.getR()/7, body.getX() + body.getR()/4 + body.getR()/4, body.getY() + body.getR()/4, Color.BLACK);
        ear1 = new Triangle(body.getX() + body.getR()/4, body.getY() - body.getR() - body.getR(), body.getX() + body.getR()/11, body.getY() - body.getR() + body.getR()/3, body.getX() + body.getR()/15, body.getY() - body.getR() - body.getR(),body.getColor());
        ear2 = new Triangle(body.getX() + body.getR()/2, body.getY() - body.getR() - body.getR(), body.getX() + body.getR()/7, body.getY() - body.getR() + body.getR()/3, body.getX() + body.getR()/3, body.getY() - body.getR() - body.getR(),body.getColor());
        foot2 = new Triangle(body.getX() - body.getR()/8 + body.getR()/6, body.getR() + body.getY(), body.getX() + body.getR() - body.getR()/5, body.getY() + body.getR() - body.getR()/4, body.getX() + body.getR() + body.getR()/6 - body.getR()/5, body.getY() + body.getR(), body.getColor());
        id = "Rabbit " + "X:" + body.getX() + " Y:" + body.getY();
        v = true;
    }

    MyFigure(int x, int y, int size, Color color){
        body = new Circle(x, y, size, color);
        tail = new Circle(body.getX() - body.getR() + body.getR()/5, body.getY() + body.getR() - body.getR()/3, body.getR()/3, body.getColor());
        eye1 = new Circle(body.getX() + body.getR() / 3, body.getY() - body.getR()/20, body.getR()/ 15, Color.BLACK);
        eye2 = new Circle(body.getX() + body.getR() - body.getR()/3, body.getY() - body.getR()/20, body.getR()/ 15, Color.BLACK);
        tooth1 = new Rectangle(body.getX() + body.getR() / 2 - body.getR()/10, body.getY() + body.getR()/4, body.getR()/10, body.getR()/6,Color.WHITE);
        tooth2 = new Rectangle(body.getX() + body.getR() - body.getR()/2, body.getY() + body.getR()/4, body.getR()/10, body.getR()/6,Color.WHITE);
        nose = new Triangle(body.getX() + body.getR()/3 + body.getR()/4, body.getY() + body.getR()/7, body.getX() + body.getR()/5 + body.getR()/4, body.getY() + body.getR()/7, body.getX() + body.getR()/4 + body.getR()/4, body.getY() + body.getR()/4, Color.BLACK);
        ear1 = new Triangle(body.getX() + body.getR()/4, body.getY() - body.getR() - body.getR(), body.getX() + body.getR()/11, body.getY() - body.getR() + body.getR()/3, body.getX() + body.getR()/15, body.getY() - body.getR() - body.getR(),body.getColor());
        ear2 = new Triangle(body.getX() + body.getR()/2, body.getY() - body.getR() - body.getR(), body.getX() + body.getR()/7, body.getY() - body.getR() + body.getR()/3, body.getX() + body.getR()/3, body.getY() - body.getR() - body.getR(),body.getColor());
        foot2 = new Triangle(body.getX() - body.getR()/8 + body.getR()/6, body.getR() + body.getY(), body.getX() + body.getR() - body.getR()/5, body.getY() + body.getR() - body.getR()/4, body.getX() + body.getR() + body.getR()/6 - body.getR()/5, body.getY() + body.getR(), body.getColor());
        id = "Rabbit " + "X:" + body.getX() + " Y:" + body.getY();
        v = true;
    }

    public void Show(GraphicsContext g, boolean visibility)
    {
        body.Show(g, visibility);
        tail.Show(g, visibility);
        eye1.Show(g, visibility);
        eye2.Show(g, visibility);
        tooth1.Show(g, visibility);
        tooth2.Show(g, visibility);
        nose.Show(g, visibility);
        ear1.Show(g, visibility);
        ear2.Show(g, visibility);
        foot2.Show(g, visibility);
    }

    public void MoveTo(int dx, int dy)
    {
        if (((dx > 0) && ((body.getX() + body.getR() - body.getR()/5) > 1295)) ||
            ((dx < 0) && (body.getX() - body.getR() + body.getR()/5 + tail.getR() + dx) < 0) ||
                ((dy > 0) && ((body.getR() + body.getY()+ dy) > 875)) ||
                ((dy < 0) && ((body.getY() - body.getR()/20 + dy) < 0)))
        {
            return;
        }
        body.MoveTo(dx, dy);
        tail.MoveTo(dx, dy);
        eye1.MoveTo(dx, dy);
        eye2.MoveTo(dx, dy);
        tooth1.MoveTo(dx, dy);
        tooth2.MoveTo(dx, dy);
        nose.MoveTo(dx, dy);
        ear1.MoveTo(dx, dy);
        ear2.MoveTo(dx, dy);
        foot2.MoveTo(dx, dy);
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
