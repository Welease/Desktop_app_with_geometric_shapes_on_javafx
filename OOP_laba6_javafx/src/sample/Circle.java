package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

    public class Circle extends TFigure{
        private final int r;
        private final Color cir_color;

        public Circle()
        {
            super((int) (Math.random() * 1300 + 300), (int) (Math.random() * 880));
            int x = super.getX();
            int y = super.getY();
            int rad = 440;
            if (rad > 880 - y)
                rad = 880 - y;
            if (rad > 1300 - x)
                rad = 1300 - x;
            if (rad > x)
                rad = x;
            if (rad > y)
                rad = y;
            this.r = (int) (Math.random() * rad);
            Random rand = new Random();
            int r = rand.nextInt(254) + 1;
            int g = rand.nextInt(254) + 1;
            int b = rand.nextInt(254) + 1;
            this.cir_color = Color.rgb(r, g, b);
            super.setV(true);
            super.setId("Circle " + "X: " + super.getX() + " Y: " + super.getY() + " R: " + this.r);
        }

        public Circle(int x, int y, int r, Color cir_color)
        {
            super(x, y);
            this.r = r;
            this.cir_color = cir_color;
            super.setV(true);
            super.setId("Circle " + "X: " + super.getX() + " Y: " + super.getY() + " R: " + this.r);
        }
        @Override
        public void Show(GraphicsContext g, boolean visibility)
        {
            super.setV(visibility);
            if (visibility){
                g.setFill(cir_color);
                g.fillOval(super.getX() - r, super.getY() - r, r * 2, r * 2);
            }
        }
        @Override
        public void MoveTo(int dx, int dy)
        {
            if ((dx > 0) && ((super.getX() + this.r + dx) > 1295))
                dx = 1295 - this.r - super.getX();
            else if ((dx < 0) && ((super.getX() + dx) < 0))
                dx = - super.getX() + this.r + 5;
            if ((dy > 0) && ((super.getY() + this.r + dy) > 875))
                dy = 875 - this.r - super.getY();
            else if ((dy < 0) && ((super.getY() + dy) < 0))
                dy = -super.getY() + this.r + 5;
            super.setX(super.getX() + dx);
            super.setY(super.getY() + dy);
        }



        public int getR()
        {
            return (this.r);
        }

        public Color getColor()
        {
            return (cir_color);
        }
    }