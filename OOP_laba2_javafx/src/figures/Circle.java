package figures;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

    public class Circle {
        private final Point circle_center = new Point();
        private final int r;
        private final Color cir_color;
        private boolean v;
        private final String id;

        public Circle()
        {
            int x = (int) (Math.random() * 1300 + 300);
            int y = (int) (Math.random() * 880);
            this.circle_center.Set(x, y);
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
            this.v = true;
            id = "Circle " + "X: " + circle_center.GetX() + " Y: " + circle_center.GetY() + " R: " + this.r;
        }

        public Circle(int x, int y, int r, Color cir_color)
        {
            this.circle_center.Set(x, y);
            this.r = r;
            this.cir_color = cir_color;
            this.v = true;
            id = "Circle " + "X: " + circle_center.GetX() + " Y: " + circle_center.GetY() + " R: " + this.r;
        }

        public void Show(GraphicsContext g, boolean visibility)
        {
            this.v = visibility;
            if (v){
                g.setFill(cir_color);
                g.fillOval(circle_center.GetX() - r, circle_center.GetY() - r, r * 2, r * 2);
            }
        }

        public void MoveTo(int dx, int dy)
        {
            if ((dx > 0) && ((this.circle_center.GetX() + this.r + dx) > 1295))
                dx = 1295 - this.r - this.circle_center.GetX();
            else if ((dx < 0) && ((this.circle_center.GetX() + dx) < 0))
                dx = - this.circle_center.GetX() + this.r + 5;
            if ((dy > 0) && ((this.circle_center.GetY() + this.r + dy) > 875))
                dy = 875 - this.r - this.circle_center.GetY();
            else if ((dy < 0) && ((this.circle_center.GetY() + dy) < 0))
                dy = -this.circle_center.GetY() + this.r + 5;
            this.circle_center.Set(this.circle_center.GetX() + dx, this.circle_center.GetY() + dy);
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