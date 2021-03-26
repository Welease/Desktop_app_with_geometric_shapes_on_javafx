package sample;

import javafx.scene.canvas.GraphicsContext;

import java.util.Arrays;

public class Mass {
    private TFigure [] mass;
    private int i = 0;
    Mass(int quantity)
    {
        mass = new TFigure[quantity];
        System.out.println("Array created");
    }
    public void add(TFigure f)
    {
        if (i == mass.length)
        {
            mass = Arrays.copyOf(mass, mass.length + 5);
        }
        mass[i++] = f;
    }

    public void delete()
    {
        Arrays.fill(mass, null);
        System.gc();
    }

    public void show(GraphicsContext g)
    {
        for (int k =0; k < mass.length; k++)
        {
            mass[k].Show(g, mass[k].getV());
        }
    }

    public void move(int dx, int dy)
    {
        for (int k = 0; k < mass.length; k++)
        {
            if (mass[k] != null) {
                mass[k].MoveTo(dx, dy);
            }
        }
    }

    public void changeV()
    {
        for (int k = 0; k < mass.length; k++)
        {
            if (mass[k] != null) {
                mass[k].setV(!mass[k].getV());
            }
        }
    }
}
