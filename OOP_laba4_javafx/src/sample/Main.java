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
        final Ellipse[] ellipses = new Ellipse[300];
        final Parallelogram[]  parallelograms = new Parallelogram[300];

        root.getChildren().add(cr_vbox);
        root.getChildren().add(canvas_panel);
        StackPane holder = new StackPane();
        holder.getChildren().add(canvas_panel);
        cr_vbox.getChildren().addAll(rec_vbox,holder, act_vbox);

        act_vbox.getChildren().addAll(el_vbox, par_vbox, move_vbox, hide_vbox, del_vbox);
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
        el_x.setMaxSize(150, 8);
        el_y.setMaxSize(150, 8);
        el_r1.setMaxSize(150, 8);
        el_r2.setMaxSize(150, 8);
        par_x.setMaxSize(150, 8);
        par_y.setMaxSize(150, 8);
        par_w.setMaxSize(150, 8);
        par_h.setMaxSize(150, 8);
        to_move_only.setMaxSize(150, 8);
        to_move_only.setPromptText("To move only...");

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

        move_vbox.getChildren().addAll(moving_label, to_move_combo_box, move_x_label, move_x,move_y_label, move_y, to_move, turn_el);
        move_vbox.setAlignment(Pos.CENTER);
        move_vbox.setPadding(new Insets(0, 10, 10, 5));

        hide_vbox.getChildren().addAll(visibility_label, to_hide_combo_box,to_hide);
        hide_vbox.setAlignment(Pos.CENTER);
        hide_vbox.setPadding(new Insets(0, 10, 5, 0));

        del_vbox.getChildren().addAll(del_label, to_del_combo_box,to_delete);
        del_vbox.setAlignment(Pos.CENTER);
        del_vbox.setPadding(new Insets(0, 10, 5, 0));
        to_move_combo_box.setMaxSize(150, 8);
        to_del_combo_box.setMaxSize(150, 8);
        to_hide_combo_box.setMaxSize(150, 8);
        to_move_combo_box.setPromptText("Choose figure...");
        to_hide_combo_box.setPromptText("Choose figure...");
        to_del_combo_box.setPromptText("Choose figure...");
        to_move_only.getItems().addAll(Rectangle.class, Circle.class, Triangle.class, Ellipse.class, Parallelogram.class);

        el_vbox.getChildren().addAll(el_label, el_x_label, el_x, el_y_label, el_y, r1_label, el_r1, r2_label, el_r2, el_create, el_create_random);
        el_vbox.setAlignment(Pos.CENTER);
        el_vbox.setPadding(new Insets(30, 10, 5, 5));

        par_vbox.getChildren().addAll(par_label, par_x_label, par_x, par_y_label, par_y, par_w_label, par_w, par_height_label, par_h, par_create, par_create_random);
        par_vbox.setAlignment(Pos.CENTER);
        par_vbox.setPadding(new Insets(0, 10, 10, 10));

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

        el_create_random.setOnAction(e ->{
            ellipses[count_ot_el] = new Ellipse();
            ellipses[count_ot_el].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(ellipses[count_ot_el].getId(), 4);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_figure++;
            count_ot_el++;
        });

        par_create_random.setOnAction(e ->{
            parallelograms[count_of_par] = new Parallelogram();
            parallelograms[count_of_par].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(parallelograms[count_of_par].getId(), 5);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_figure++;
            count_of_par++;
        });

        rec_create.setOnAction(e ->
        {
            rectangles[count_of_rec] = new Rectangle((int)rec_x.getValue(), (int)rec_y.getValue(), (int) rec_w.getValue(), (int) rec_h.getValue(), colorPicker.getValue()) ;
            rectangles[count_of_rec].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(rectangles[count_of_rec].getId(), 1);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_figure++;
            count_of_rec++;
        });
        tr_create.setOnAction(e ->{
            triangles[count_of_tr] = new Triangle((int)tr_x1.getValue(), (int)tr_y1.getValue(), (int)tr_x2.getValue(), (int)tr_y2.getValue(), (int)tr_x3.getValue(), (int)tr_y3.getValue(), colorPicker.getValue());
            triangles[count_of_tr].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(triangles[count_of_tr].getId(), 2);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_tr++;
            count_of_figure++;
        });

        cir_create.setOnAction(e -> {
            circles[count_of_cir] = new Circle((int)cir_x.getValue(), (int) cir_y.getValue(), (int) cir_r.getValue(), colorPicker.getValue());
            circles[count_of_cir].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(circles[count_of_cir].getId(), 3);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_cir++;
            count_of_figure++;
        });

        el_create.setOnAction(e -> {
                ellipses[count_ot_el] = new Ellipse((int) el_x.getValue(), (int) el_y.getValue(), (int) el_r1.getValue(), (int) el_r2.getValue(), colorPicker.getValue());
                ellipses[count_ot_el].Show(canvas_panel.getGraphicsContext2D(), true);
                mass_of_figures[count_of_figure] = new ComboItem(ellipses[count_ot_el].getId(), 4);
                to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                count_ot_el++;
                count_of_figure++;
        });

        par_create.setOnAction(e -> {
            parallelograms[count_of_par] = new Parallelogram((int) par_x.getValue(), (int) par_y.getValue(), (int) par_w.getValue(), (int)par_h.getValue(),colorPicker.getValue());
            parallelograms[count_of_par].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(parallelograms[count_of_par].getId(), 5);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_par++;
            count_of_figure++;
        });

        turn_el.setOnAction(e ->{
            int ind;
            int i;
            String ans = to_move_combo_box.getValue().getKey();
            for (ind = 0; ind < count_of_figure; ind++)
            {
                if (mass_of_figures[ind].getKey().equals(ans)) {
                    break;
                }
            }
            if (mass_of_figures[ind] != null) {
                    for (i = 0; i < count_ot_el; i++) {
                        if (ellipses[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            ellipses[i].turn();
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles, triangles, ellipses, parallelograms);
                        }

                    }
            }

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
                        drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, ellipses, parallelograms);
                    }
                }
            }
            else if (mass_of_figures[ind].getValue() == 2) {
                for (i = 0; i < count_of_tr; i++) {
                    if (triangles[i].getId().equals(ans)) {
                        clearCanvas(canvas_panel.getGraphicsContext2D());
                        triangles[i].setV(!triangles[i].getV());
                        drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, ellipses, parallelograms);
                    }
                }
            }
            else if (mass_of_figures[ind].getValue() == 3) {
                for (i = 0; i < count_of_cir; i++) {
                    if (circles[i].getId().equals(ans)) {
                        clearCanvas(canvas_panel.getGraphicsContext2D());
                        circles[i].setV(!circles[i].getV());
                        drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, ellipses, parallelograms);
                    }
                }
            }
            else if (mass_of_figures[ind].getValue() == 4) {
                for (i = 0; i < count_ot_el; i++) {
                    if (ellipses[i].getId().equals(ans)) {
                        clearCanvas(canvas_panel.getGraphicsContext2D());
                        ellipses[i].setV(!ellipses[i].getV());
                        drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, ellipses, parallelograms);
                    }
                }
            }
            else if (mass_of_figures[ind].getValue() == 5) {
                for (i = 0; i < count_of_par; i++) {
                    if (parallelograms[i].getId().equals(ans)) {
                        clearCanvas(canvas_panel.getGraphicsContext2D());
                        parallelograms[i].setV(!parallelograms[i].getV());
                        drawEverything(canvas_panel.getGraphicsContext2D(), rectangles,circles,triangles, ellipses, parallelograms);
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
            if (mass_of_figures[ind] != null) {
                if (mass_of_figures[ind].getValue() == 1) {
                    for (i = 0; i < count_of_rec; i++) {
                        if (rectangles[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            rectangles[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles, triangles, ellipses, parallelograms);
                        }

                    }
                }
                if (mass_of_figures[ind].getValue() == 2) {
                    for (i = 0; i < count_of_tr; i++) {
                        if (triangles[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            triangles[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles, triangles, ellipses, parallelograms);
                        }
                    }
                }
                if (mass_of_figures[ind].getValue() == 3) {
                    for (i = 0; i < count_of_cir; i++) {
                        if (circles[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            circles[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles, triangles, ellipses, parallelograms);
                        }
                    }
                }
                if (mass_of_figures[ind].getValue() == 4) {
                    for (i = 0; i < count_ot_el; i++) {
                        if (ellipses[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            ellipses[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles, triangles, ellipses, parallelograms);
                        }
                    }
                }
                if (mass_of_figures[ind].getValue() == 5) {
                    for (i = 0; i < count_of_par; i++) {
                        if (parallelograms[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            parallelograms[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
                            drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles, triangles, ellipses, parallelograms);
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
                        drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles,triangles, ellipses, parallelograms);
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
                        drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles,triangles, ellipses, parallelograms);
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
                        drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles,triangles, ellipses, parallelograms);
                    }
                }
            }
            else if (mass_of_figures[ind].getValue() == 4) {
                for (i = 0; i < count_ot_el; i++) {
                    if (ellipses[i].getId().equals(ans)) {
                        clearCanvas(canvas_panel.getGraphicsContext2D());
                        del_from_mass_ri(ellipses, i);
                        to_move_combo_box.getItems().remove(mass_of_figures[ind]);
                        to_hide_combo_box.getItems().remove(mass_of_figures[ind]);
                        to_del_combo_box.getItems().remove(mass_of_figures[ind]);
                        del_from_mass(mass_of_figures, ind);
                        count_of_figure--;
                        count_ot_el--;
                        drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles,triangles, ellipses, parallelograms);
                    }
                }
            }
            else if (mass_of_figures[ind].getValue() == 5) {
                for (i = 0; i < count_of_par; i++) {
                    if (parallelograms[i].getId().equals(ans)) {
                        clearCanvas(canvas_panel.getGraphicsContext2D());
                        del_from_mass_m(parallelograms, i);
                        to_move_combo_box.getItems().remove(mass_of_figures[ind]);
                        to_hide_combo_box.getItems().remove(mass_of_figures[ind]);
                        to_del_combo_box.getItems().remove(mass_of_figures[ind]);
                        del_from_mass(mass_of_figures, ind);
                        count_of_figure--;
                        count_of_par--;
                        drawEverything(canvas_panel.getGraphicsContext2D(), rectangles, circles,triangles, ellipses, parallelograms);
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
    public void del_from_mass_ri(Ellipse [] m, int ind)
    {
        if (299 - ind >= 0) System.arraycopy(m, ind + 1, m, ind, 299 - ind);
        m[299] = null;
    }

    public void del_from_mass(ComboItem [] m, int ind)
    {
        if (899 - ind >= 0) System.arraycopy(m, ind + 1, m, ind, 899 - ind);
        m[899] = null;
    }

    public void del_from_mass_m(Parallelogram[] m, int ind){
        if (299 - ind >= 0) System.arraycopy(m, ind + 1, m, ind, 299 - ind);
        m[299] = null;
    }


    public void clearCanvas(GraphicsContext gc){
        gc.clearRect(canvas_panel.getLayoutX(), canvas_panel.getLayoutY(), canvas_panel.getWidth(), canvas_panel.getHeight());
    }

        public void drawEverything(GraphicsContext gc, Rectangle [] rectangles, Circle [] circles, Triangle [] triangles, Ellipse[] ellipses, Parallelogram[] parallelograms)
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
            for (i = 0; i < count_ot_el; i++)
            {
                ellipses[i].Show(gc, ellipses[i].getV());
            }
            for (i = 0; i < count_of_par; i++)
            {
                parallelograms[i].Show(gc, parallelograms[i].getV());
            }
        }

    public static void main(String[] args) {
        launch(args);
    }
    int count_of_figure = 0;
    int count_of_rec = 0;
    int count_of_cir = 0;
    int count_of_tr = 0;
    int count_ot_el = 0;
    int count_of_par = 0;
    Group root = new Group();
    HBox cr_vbox = new HBox();
    VBox act_vbox = new VBox();
    VBox rec_vbox = new VBox();
    VBox move_vbox = new VBox();
    VBox hide_vbox = new VBox();
    VBox del_vbox = new VBox();
    VBox el_vbox = new VBox();
    VBox par_vbox = new VBox();

    Canvas canvas_panel = new Canvas(1300,880);
    Button turn_el = new Button("Turn el");
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

    Spinner el_x = new Spinner(0, 1300, 0);
    Spinner el_y = new Spinner(0, 880, 0);
    Spinner el_r1 = new Spinner(0, 440, 0);
    Spinner el_r2 = new Spinner(0, 440, 0);

    Spinner par_x = new Spinner(0, 1300, 0);
    Spinner par_y = new Spinner(0, 880, 0);
    Spinner par_w = new Spinner(0, 1300, 0);
    Spinner par_h = new Spinner(0, 880, 0);

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
    Button to_hide_all = new Button("To hide all");

    Label circle_label = new Label("Circle");
    Label cir_x_label = new Label("X:");
    Label cir_y_label = new Label("Y:");
    Label cir_r_label = new Label("R:");
    Button cir_create = new Button("   Create circle   ");
    Button cir_create_random = new Button("   Random circle   ");

    Label el_label = new Label("Ellipse                           ");
    Label el_x_label = new Label("X:                                ");
    Label el_y_label = new Label("Y:                                ");
    Label r1_label = new Label("R2                               ");
    Label r2_label = new Label("R1:                              ");
    Button el_create = new Button("Create ellipse");
    Button el_create_random = new Button("Random ellipse");

    Label par_label = new Label("Parallelogram                     ");
    Label par_x_label = new Label("X:                                ");
    Label par_y_label = new Label("Y:                                ");
    Label par_w_label = new Label("Width:                            ");
    Label par_height_label = new Label("Height:                             ");
    Button par_create = new Button("Create parallelogram");
    Button par_create_random = new Button("Rand parallelogram");

    Label color_label = new Label("  Color State:  ");

    Label del_label = new Label("Deleting layers:              ");
    Button to_delete = new Button("Delete");


    Label moving_label = new Label("    Moving layers:             ");
    Label move_x_label = new Label("dx:                               ");
    Label move_y_label = new Label("dy:                               ");
    Button to_move = new Button("     Move     ");
    Button to_move_all = new Button("Move all figures");
    Button to_move_rec = new Button("Move rectangles");
    ComboBox<Class>  to_move_only= new ComboBox<Class>();

    Label visibility_label = new Label("  Visibility layers:               ");
    Button to_hide = new Button("Hide / Show");
    Label emt1 = new Label(" ");
    Label emt2 = new Label(" ");
    Label emt3 = new Label(" ");
    ColorPicker colorPicker = new ColorPicker();
}
