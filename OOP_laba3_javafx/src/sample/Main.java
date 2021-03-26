package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        final Rectangle[] rectangles = new Rectangle[300];
        final Circle[] circles = new Circle[300];
        final Triangle[] triangles = new Triangle[300];
        final ComboItem[] mass_of_figures = new ComboItem[900];
        final Ring[] rings = new Ring[300];
        final MyFigure[] myFigures = new MyFigure[300];

        root.getChildren().add(cr_vbox);
        root.getChildren().add(canvas_panel);
        StackPane holder = new StackPane();
        holder.getChildren().add(canvas_panel);
        cr_vbox.getChildren().addAll(rec_vbox,holder, act_vbox);

        act_vbox.getChildren().addAll(ring_vbox, rab_vbox, move_vbox, hide_vbox, del_vbox);
        rec_x.setMaxSize(150, 8);
        rec_y.setMaxSize(150, 8);
        rec_w.setMaxSize(150, 8);
        rec_h.setMaxSize(150, 8);
        tr_x1.setMaxSize(150, 8);
        tr_y1.setMaxSize(150, 8);
        tr_x2.setMaxSize(150, 8);
        tr_y2.setMaxSize(150, 8);
        tr_y3.setMaxSize(150, 8);
        tr_x3.setMaxSize(150, 8);
        cir_x.setMaxSize(150, 8);
        cir_y.setMaxSize(150, 8);
        cir_r.setMaxSize(150, 8);
        move_x.setMaxSize(150, 8);
        move_y.setMaxSize(150, 8);
        ring_x.setMaxSize(150, 8);
        ring_y.setMaxSize(150, 8);
        ex_r.setMaxSize(150, 8);
        in_r.setMaxSize(150, 8);
        rab_x.setMaxSize(150, 8);
        rab_y.setMaxSize(150, 8);
        rab_size.setMaxSize(150, 8);

        rec_vbox.getChildren().add(rec_label);
        rec_vbox.getChildren().add(rec_x_label);
        rec_vbox.getChildren().add(rec_x);
        rec_vbox.getChildren().add(rec_y_label);
        rec_vbox.getChildren().add(rec_y);
        rec_vbox.getChildren().add(rec_w_label);
        rec_vbox.getChildren().add(rec_w);
        rec_vbox.getChildren().add(rec_h_label);
        rec_vbox.getChildren().add(rec_h);
        rec_vbox.getChildren().add(rec_create);
        rec_vbox.getChildren().add(rec_create_random);
        rec_vbox.getChildren().addAll(emt3,triangle_label, tr_x1_label, tr_x1, tr_y1_label, tr_y1, tr_x2_label, tr_x2, tr_y2_label, tr_y2, tr_x3_label, tr_x3, tr_y3_label, tr_y3, tr_create, tr_create_random);
        rec_vbox.getChildren().addAll(emt2,circle_label, cir_x_label, cir_x, cir_y_label, cir_y, cir_r_label, cir_r, cir_create, cir_create_random);
        rec_vbox.getChildren().addAll(emt1, color_label, colorPicker);
        rec_vbox.setPadding(new Insets(5, 10,10,10));

        move_vbox.getChildren().addAll(moving_label, to_move_combo_box, move_x_label, move_x,move_y_label, move_y, to_move);
        move_vbox.setAlignment(Pos.CENTER);
        move_vbox.setPadding(new Insets(10, 10, 10, 10));

        hide_vbox.getChildren().addAll(visibility_label, to_hide_combo_box, e4, to_hide);
        hide_vbox.setAlignment(Pos.BASELINE_RIGHT);
        hide_vbox.setPadding(new Insets(10, 10, 10, 0));

        del_vbox.getChildren().addAll(del_label, to_del_combo_box, e5, to_delete);
        del_vbox.setAlignment(Pos.BASELINE_RIGHT);
        del_vbox.setPadding(new Insets(10, 10, 10, 0));
        to_move_combo_box.setMaxSize(150, 8);
        to_del_combo_box.setMaxSize(150, 8);
        to_hide_combo_box.setMaxSize(150, 8);
        to_move_combo_box.setPromptText("Choose figure...");
        to_hide_combo_box.setPromptText("Choose figure...");
        to_del_combo_box.setPromptText("Choose figure...");

        ring_vbox.getChildren().addAll(ring_label, ring_x_label, ring_x, ring_y_label, ring_y, ex_r_label, ex_r, in_r_label, in_r, ring_create, ring_create_random);
        ring_vbox.setAlignment(Pos.CENTER);
        ring_vbox.setPadding(new Insets(5, 10, 10, 5));

        rab_vbox.getChildren().addAll(rab_label, rab_x_label, rab_x, rab_y_label, rab_y, rab_size_label, rab_size, rab_create, rab_create_random);
        rab_vbox.setAlignment(Pos.CENTER);
        rab_vbox.setPadding(new Insets(5, 10, 10, 10));

        int WIDTH = 1650;
        int HEIGHT = 880;
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("FigureDrawer");
        act_vbox.setStyle("-fx-background-color: gray");
        rec_vbox.setStyle("-fx-background-color: gray");
        primaryStage.setScene(scene);
        primaryStage.show();
            rec_create_random.setOnAction(e -> {
                rectangles[count_of_rec] = new Rectangle();
                rectangles[count_of_rec].Show(canvas_panel.getGraphicsContext2D(), true);
                mass_of_figures[count_of_figure] = new ComboItem(rectangles[count_of_rec].getId(), 1);
                to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                count_of_figure++;
                count_of_rec++;
            });

            tr_create_random.setOnAction(e -> {
                triangles[count_of_tr] = new Triangle();
                triangles[count_of_tr].Show(canvas_panel.getGraphicsContext2D(), true);
                mass_of_figures[count_of_figure] = new ComboItem(triangles[count_of_tr].getId(), 2);
                to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                count_of_tr++;
                count_of_figure++;
            });

            cir_create_random.setOnAction(e ->{
                circles[count_of_cir] = new Circle();
                circles[count_of_cir].Show(canvas_panel.getGraphicsContext2D(), true);
                mass_of_figures[count_of_figure] = new ComboItem(circles[count_of_cir].getId(), 3);
                to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                count_of_figure++;
                count_of_cir++;
            });

            ring_create_random.setOnAction(e ->{
                rings[count_ot_rings] = new Ring();
                rings[count_ot_rings].Show(canvas_panel.getGraphicsContext2D(), true);
                mass_of_figures[count_of_figure] = new ComboItem(rings[count_ot_rings].getId(), 4);
                to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                count_of_figure++;
                count_ot_rings++;
            });

            rab_create_random.setOnAction(e ->{
                myFigures[count_of_rab] = new MyFigure();
                myFigures[count_of_rab].Show(canvas_panel.getGraphicsContext2D(), true);
                mass_of_figures[count_of_figure] = new ComboItem(myFigures[count_of_rab].getId(), 5);
                to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                count_of_figure++;
                count_of_rab++;
            });

            rec_create.setOnAction(e ->
            {
                rec_point.Set((int)rec_x.getValue(), (int)rec_y.getValue());
                rectangles[count_of_rec] = new Rectangle(rec_point, (int) rec_w.getValue(), (int) rec_h.getValue(), colorPicker.getValue()) ;
                rectangles[count_of_rec].Show(canvas_panel.getGraphicsContext2D(), true);
                mass_of_figures[count_of_figure] = new ComboItem(rectangles[count_of_rec].getId(), 1);
                to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                count_of_figure++;
                count_of_rec++;
            });
            tr_create.setOnAction(e ->{
                tr_point1.Set((int)tr_x1.getValue(), (int)tr_y1.getValue());
                tr_point2.Set((int)tr_x2.getValue(), (int)tr_y2.getValue());
                tr_point3.Set((int)tr_x3.getValue(), (int)tr_y3.getValue());
                triangles[count_of_tr] = new Triangle(tr_point1, tr_point2, tr_point3, colorPicker.getValue());
                triangles[count_of_tr].Show(canvas_panel.getGraphicsContext2D(), true);
                mass_of_figures[count_of_figure] = new ComboItem(triangles[count_of_tr].getId(), 2);
                to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                count_of_tr++;
                count_of_figure++;
            });

            cir_create.setOnAction(e -> {
                cir_point.Set((int)cir_x.getValue(), (int) cir_y.getValue());
                circles[count_of_cir] = new Circle(cir_point, (int) cir_r.getValue(), colorPicker.getValue());
                circles[count_of_cir].Show(canvas_panel.getGraphicsContext2D(), true);
                mass_of_figures[count_of_figure] = new ComboItem(circles[count_of_cir].getId(), 3);
                to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                count_of_cir++;
                count_of_figure++;
            });

            ring_create.setOnAction(e -> {
                if ((int)in_r.getValue() < (int)ex_r.getValue()) {
                    rings[count_ot_rings] = new Ring((int) ring_x.getValue(), (int) ring_y.getValue(), (int) ex_r.getValue(), (int) in_r.getValue(), colorPicker.getValue());
                    rings[count_ot_rings].Show(canvas_panel.getGraphicsContext2D(), true);
                    mass_of_figures[count_of_figure] = new ComboItem(rings[count_ot_rings].getId(), 4);
                    to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                    to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                    to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                    count_ot_rings++;
                    count_of_figure++;
                }
                else{
                    System.out.println("Error, please check your input data");
                }
            });

            rab_create.setOnAction(e -> {
                myFigures[count_of_rab] = new MyFigure((int) rab_x.getValue(), (int) rab_y.getValue(), (int) rab_size.getValue(), colorPicker.getValue());
                myFigures[count_of_rab].Show(canvas_panel.getGraphicsContext2D(), true);
                mass_of_figures[count_of_figure] = new ComboItem(myFigures[count_of_rab].getId(), 5);
                to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                count_of_rab++;
                count_of_figure++;
            });




            to_hide.setOnAction(e -> {
                int ind;
                int i;
                String ans = ((to_hide_combo_box.getValue())).getKey();
                for (ind = 0; ind < count_of_figure; ind++) {
                    if (mass_of_figures[ind].getKey().equals(ans)) {
                        break;
                    }
                }
                if (mass_of_figures[ind].getValue() == 1) {
                    for (i = 0; i < count_of_rec; i++) {
                        if (rectangles[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            rectangles[i].setV(!rectangles[i].getV());
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, rings, myFigures);
                        }
                    }
                }
                else if (mass_of_figures[ind].getValue() == 2) {
                    for (i = 0; i < count_of_tr; i++) {
                        if (triangles[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            triangles[i].setV(!triangles[i].getV());
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, rings, myFigures);
                        }
                    }
                }
                else if (mass_of_figures[ind].getValue() == 3) {
                    for (i = 0; i < count_of_cir; i++) {
                        if (circles[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            circles[i].setV(!circles[i].getV());
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, rings, myFigures);
                        }
                    }
                }
                else if (mass_of_figures[ind].getValue() == 4) {
                    for (i = 0; i < count_ot_rings; i++) {
                        if (rings[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            rings[i].setV(!rings[i].getV());
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, rings, myFigures);
                        }
                    }
                }
                else if (mass_of_figures[ind].getValue() == 5) {
                    for (i = 0; i < count_of_rab; i++) {
                        if (myFigures[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            myFigures[i].setV(!myFigures[i].getV());
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, rings, myFigures);
                        }
                    }
                }
            });

           to_move.setOnAction(e -> {
                //Object item;
                int ind;
                int i;
                String ans = to_move_combo_box.getValue().getKey();
                for (ind = 0; ind < count_of_figure; ind++)
                {
                    if (mass_of_figures[ind].getKey().equals(ans)) {
                        break;
                    }
                }
                if (mass_of_figures[ind] != null)
                {
                    if (mass_of_figures[ind].getValue() == 1)
                    {
                        for (i = 0; i < count_of_rec; i++)
                        {
                            if (rectangles[i].getId().equals(ans)) {
                                clearCanvas(canvas_panel.getGraphicsContext2D());
                                rectangles[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
                                drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles,triangles, rings, myFigures);
                            }

                        }
                    }
                    if (mass_of_figures[ind].getValue() == 2)
                    {
                        for (i = 0; i < count_of_tr; i++)
                        {
                            if (triangles[i].getId().equals(ans)) {
                                clearCanvas(canvas_panel.getGraphicsContext2D());
                                triangles[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
                                drawEverything(canvas_panel.getGraphicsContext2D(),rectangles,circles,triangles, rings, myFigures);
                            }
                        }
                    }
                    if (mass_of_figures[ind].getValue() == 3)
                    {
                        for (i = 0; i < count_of_cir; i++)
                        {
                            if (circles[i].getId().equals(ans)) {
                                clearCanvas(canvas_panel.getGraphicsContext2D());
                                circles[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
                                drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, rings, myFigures);
                            }
                        }
                    }
                    if (mass_of_figures[ind].getValue() == 4)
                    {
                        for (i = 0; i < count_ot_rings; i++)
                        {
                            if (rings[i].getId().equals(ans)) {
                                clearCanvas(canvas_panel.getGraphicsContext2D());
                                rings[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
                                drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, rings, myFigures);
                            }
                        }
                    }
                    if (mass_of_figures[ind].getValue() == 5)
                    {
                        for (i = 0; i < count_of_rab; i++)
                        {
                            if (myFigures[i].getId().equals(ans)) {
                                clearCanvas(canvas_panel.getGraphicsContext2D());
                                myFigures[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
                                drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, rings, myFigures);
                            }
                        }
                    }
                }

            });

            to_delete.setOnAction(e -> {
                int ind;
                int i;
                String ans = to_del_combo_box.getValue().getKey();
                for (ind = 0; ind < count_of_figure; ind++) {
                    if (mass_of_figures[ind].getKey().equals(ans)) {
                        break;
                    }
                }
                if (mass_of_figures[ind].getValue() == 1) {
                    for (i = 0; i < count_of_rec; i++) {
                        if (rectangles[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            del_from_mass_r(rectangles, i);
                            to_move_combo_box.getItems().remove(mass_of_figures[ind]);
                            to_hide_combo_box.getItems().remove(mass_of_figures[ind]);
                            to_del_combo_box.getItems().remove(mass_of_figures[ind]);
                            del_from_mass(mass_of_figures, ind);
                            count_of_figure--;
                            count_of_rec--;
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles,triangles, rings, myFigures);
                        }
                    }
                }
                else if (mass_of_figures[ind].getValue() == 2) {
                    for (i = 0; i < count_of_tr; i++) {
                        if (triangles[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            del_from_mass_t(triangles, i);
                            to_move_combo_box.getItems().remove(mass_of_figures[ind]);
                            to_hide_combo_box.getItems().remove(mass_of_figures[ind]);
                            to_del_combo_box.getItems().remove(mass_of_figures[ind]);
                            del_from_mass(mass_of_figures, ind);
                            count_of_figure--;
                            count_of_tr--;
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles,triangles, rings, myFigures);
                        }
                    }
                }
                else if (mass_of_figures[ind].getValue() == 3) {
                    for (i = 0; i < count_of_cir; i++) {
                        if (circles[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            del_from_mass_c(circles, i);
                            to_move_combo_box.getItems().remove(mass_of_figures[ind]);
                            to_hide_combo_box.getItems().remove(mass_of_figures[ind]);
                            to_del_combo_box.getItems().remove(mass_of_figures[ind]);
                            del_from_mass(mass_of_figures, ind);
                            count_of_figure--;
                            count_of_cir--;
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles,triangles, rings, myFigures);
                        }
                    }
                }
                else if (mass_of_figures[ind].getValue() == 4) {
                    for (i = 0; i < count_ot_rings; i++) {
                        if (rings[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            del_from_mass_ri(rings, i);
                            to_move_combo_box.getItems().remove(mass_of_figures[ind]);
                            to_hide_combo_box.getItems().remove(mass_of_figures[ind]);
                            to_del_combo_box.getItems().remove(mass_of_figures[ind]);
                            del_from_mass(mass_of_figures, ind);
                            count_of_figure--;
                            count_ot_rings--;
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles,triangles, rings, myFigures);
                        }
                    }
                }
                else if (mass_of_figures[ind].getValue() == 5) {
                    for (i = 0; i < count_of_rab; i++) {
                        if (myFigures[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            del_from_mass_m(myFigures, i);
                            to_move_combo_box.getItems().remove(mass_of_figures[ind]);
                            to_hide_combo_box.getItems().remove(mass_of_figures[ind]);
                            to_del_combo_box.getItems().remove(mass_of_figures[ind]);
                            del_from_mass(mass_of_figures, ind);
                            count_of_figure--;
                            count_of_rab--;
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles,triangles, rings, myFigures);
                        }
                    }
                }
            });
        }

        public void del_from_mass_r(Rectangle [] m, int ind)
        {
            if (299 - ind >= 0) System.arraycopy(m, ind + 1, m, ind, 299 - ind);
            m[299] = null;
        }

        public void del_from_mass_t(Triangle [] m, int ind)
        {
            if (299 - ind >= 0) System.arraycopy(m, ind + 1, m, ind, 299 - ind);
            m[299] = null;
        }

        public void del_from_mass_c(Circle [] m, int ind)
        {
            if (299 - ind >= 0) System.arraycopy(m, ind + 1, m, ind, 299 - ind);
            m[299] = null;
        }
        public void del_from_mass_ri(Ring [] m, int ind)
        {
            if (299 - ind >= 0) System.arraycopy(m, ind + 1, m, ind, 299 - ind);
            m[299] = null;
        }

        public void del_from_mass(ComboItem [] m, int ind)
        {
            if (899 - ind >= 0) System.arraycopy(m, ind + 1, m, ind, 899 - ind);
            m[899] = null;
        }

        public void del_from_mass_m(MyFigure[] m, int ind){
            if (299 - ind >= 0) System.arraycopy(m, ind + 1, m, ind, 299 - ind);
            m[299] = null;
        }

    public void clearCanvas(GraphicsContext gc){
        gc.clearRect(canvas_panel.getLayoutX(), canvas_panel.getLayoutY(), canvas_panel.getWidth(), canvas_panel.getHeight());
    }
    public void drawEverything(GraphicsContext gc, Rectangle [] rectangles, Circle [] circles, Triangle [] triangles, Ring [] rings, MyFigure [] myFigures)
    {
        int i;
        for (i = 0; i < count_of_rec; i++)
        {
            rectangles[i].Show(gc, rectangles[i].getV());
        }
        for (i = 0; i < count_of_tr; i++)
        {
            triangles[i].Show(gc, triangles[i].getV());
        }
        for (i = 0; i < count_of_cir; i++)
        {
            circles[i].Show(gc, circles[i].getV());
        }
        for (i = 0; i < count_ot_rings; i++)
        {
            rings[i].Show(gc, rings[i].getV());
        }
        for (i = 0; i < count_of_rab; i++)
        {
            myFigures[i].Show(gc, myFigures[i].getV());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    int count_of_figure = 0;
    int count_of_rec = 0;
    int count_of_cir = 0;
    int count_of_tr = 0;
    int count_ot_rings = 0;
    int count_of_rab = 0;
    Point cir_point = new Point();
    Point rec_point = new Point();
    Point tr_point1 = new Point();
    Point tr_point2 = new Point();
    Point tr_point3 = new Point();
    Group root = new Group();
    HBox cr_vbox = new HBox();
    VBox act_vbox = new VBox();
    VBox rec_vbox = new VBox();
    VBox move_vbox = new VBox();
    VBox hide_vbox = new VBox();
    VBox del_vbox = new VBox();
    VBox ring_vbox = new VBox();
    VBox rab_vbox = new VBox();

    Canvas canvas_panel = new Canvas(1300,880);
    Spinner rec_x = new Spinner(0, 1300, 0);
    Spinner rec_y = new Spinner(0, 880, 0);
    Spinner rec_w = new Spinner(0, 1300, 0);
    Spinner rec_h = new Spinner(0, 880, 0);

    Spinner tr_x1 = new Spinner(0, 1300, 0);
    Spinner tr_x2 = new Spinner(0, 1300, 0);
    Spinner tr_x3 = new Spinner(0, 1300, 0);
    Spinner tr_y1 = new Spinner(0, 880, 0);
    Spinner tr_y2 = new Spinner(0, 880, 0);
    Spinner tr_y3 = new Spinner(0, 880, 0);

    Spinner cir_x = new Spinner(0, 1300, 0);
    Spinner cir_y = new Spinner(0, 880, 0);
    Spinner cir_r = new Spinner(0, 440, 0);

    Spinner ring_x = new Spinner(0, 1300, 0);
    Spinner ring_y = new Spinner(0, 880, 0);
    Spinner ex_r = new Spinner(0, 440, 0);
    Spinner in_r = new Spinner(0, 439, 0);

    Spinner rab_x = new Spinner(0, 1300, 0);
    Spinner rab_y = new Spinner(0, 880, 0);
    Spinner rab_size = new Spinner(0, 440, 0);

    ComboBox<ComboItem> to_move_combo_box = new ComboBox<>();
    Spinner move_x = new Spinner(-1300, 1300, 0);
    Spinner move_y = new Spinner(-880, 880, 0);

    ComboBox<ComboItem> to_hide_combo_box = new ComboBox<>();

    ComboBox<ComboItem> to_del_combo_box = new ComboBox<>();
    Label rec_label = new Label("Rectangle");
    Label rec_x_label = new Label("X:");
    Label rec_y_label = new Label("Y:");
    Label rec_w_label = new Label("Width: ");
    Label rec_h_label = new Label("Height:");
    Button rec_create = new Button("Create rectangle");
    Button rec_create_random = new Button("Random rectangle");
    Label triangle_label = new Label("Triangle");
    Label tr_x1_label = new Label("X1:");
    Label tr_y1_label = new Label("Y1:");
    Label tr_x2_label = new Label("X2:");
    Label tr_y2_label = new Label("Y2:");
    Label tr_x3_label = new Label("X3:");
    Label tr_y3_label = new Label("Y3:");
    Button tr_create = new Button("Create triangle");
    Button tr_create_random = new Button("Random triangle");

    Label circle_label = new Label("Circle");
    Label cir_x_label = new Label("X:");
    Label cir_y_label = new Label("Y:");
    Label cir_r_label = new Label("R:");
    Button cir_create = new Button("   Create circle   ");
    Button cir_create_random = new Button("   Random circle   ");

    Label ring_label = new Label("Ring                             ");
    Label ring_x_label = new Label("X:                                ");
    Label ring_y_label = new Label("Y:                                ");
    Label ex_r_label = new Label("External R                   ");
    Label in_r_label = new Label("Internal R                    ");
    Button ring_create = new Button("Create ring");
    Button ring_create_random = new Button("Random ring");

    Label rab_label = new Label("My figure                     ");
    Label rab_x_label = new Label("X:                                ");
    Label rab_y_label = new Label("Y:                                ");
    Label rab_size_label = new Label("Size:                            ");
    Button rab_create = new Button("Create my figure");
    Button rab_create_random = new Button("Random my figure");

    Label color_label = new Label("  Color State:  ");

    Label del_label = new Label("Deleting layers:              ");
    Button to_delete = new Button("Delete");


    Label moving_label = new Label("    Moving layers:             ");
    Label move_x_label = new Label("dx:                               ");
    Label move_y_label = new Label("dy:                               ");
    Button to_move = new Button("     Move     ");

    Label visibility_label = new Label("  Visibility layers:               ");
    Button to_hide = new Button("Hide / Show");
    Label emt1 = new Label(" ");
    Label emt2 = new Label(" ");
    Label emt3 = new Label(" ");
    Label e4 = new Label(" ");
    Label e5 = new Label(" ");
    ColorPicker colorPicker = new ColorPicker();
}
