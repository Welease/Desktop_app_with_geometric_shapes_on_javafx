package figures;

public class Point {
    private int x;
    private int y;

    public Point()
    {
        //System.out.println("point created without parameters");
    }

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void Set(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int GetX()
    {
        return this.x;
    }
    public int GetY()
    {
        return this.y;
    }

}

