package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

    public class Circle extends TFigure{
        private  int r;
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
        public void setR(int r)
        {
            this.r = r;
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