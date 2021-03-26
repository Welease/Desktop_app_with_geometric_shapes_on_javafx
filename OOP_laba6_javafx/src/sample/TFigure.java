package sample;

import javafx.scene.canvas.GraphicsContext;

abstract class TFigure {
    private int x, y;
    private String id;
    private boolean v;

    public TFigure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract void Show(GraphicsContext g, boolean visibility);

    abstract void MoveTo(int dx, int dy);

    public int getX()
    {
        return (this.x);
    }

    public int getY()
    {
        return (this.y);
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setV(boolean v)
    {
        this.v = v;
    }

    public boolean getV()
    {
        return this.v;
    }
    public String getId()
    {
        return id;
    }
}
