package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Parallelogram extends Rectangle{

    public Parallelogram()
    {
        super();
        super.setId("Parallelogram X:" + super.getX() + " Y:" + super.getY());
        super.setV(true);
    }

    public Parallelogram(int x, int y, int w, int h, Color par_color)
    {
        super(x, y, w, h, par_color);
        super.setId("Parallelogram X:" + super.getX() + " Y:" + super.getY());
        super.setV(true);
    }
    @Override
    public void Show(GraphicsContext g, boolean visibility)
    {
        super.setV(visibility);
        if (visibility) {
            g.setFill(super.getColor());
            g.fillPolygon(new double[]{getX(), getX() + getW(),
                            getX() + getW() - (int) Math.round(getH() / 2.0 * Math.sqrt(3.0)),
                            getX() - (int) Math.round(getH() / 2.0 * Math.sqrt(3.0))},
                    new double[]{getY(), getY(), getY() + getH(), getY() + getH()}, 4);
        }
    }
}
