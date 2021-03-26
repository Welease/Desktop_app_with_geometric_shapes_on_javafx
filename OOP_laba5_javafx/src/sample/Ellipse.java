package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellipse extends Circle{
    private int r2;

    Ellipse()
    {
        super();
        this.r2 = (int)(Math.random() * 220);
        super.setId("Ellipse X:" + super.getX() + " Y:" + super.getY());
        super.setV(true);
    }

    Ellipse(int x, int y, int r1, int r2, Color col)
    {
        super(x, y, r1, col);
        this.r2 = r2;
        super.setId("Ellipse X:" + super.getX() + " Y:" + super.getY());
        super.setV(true);
    }

    public void turn()
    {
        int a = r2;
        this.r2 = super.getR();
        super.setR(a);
    }

    @Override
    public void Show(GraphicsContext g, boolean visibility)
    {
        super.setV(visibility);
        if (visibility) {
            g.setFill(super.getColor());
            g.fillOval(getX() - (getR() / 2.0) - Math.abs(this.r2 - getR()), getY() - (this.r2 / 2.0) + Math.abs(getR() - this.r2), getR(), r2);
        }
    }
}
