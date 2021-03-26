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

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;


public class Main extends Application {
    List list = null;
    Mass mass = null;
    @Override
    public void start(Stage primaryStage){
        final TFigure[] figures = new TFigure[900];
        final ComboItem[] mass_of_figures = new ComboItem[900];

        root.getChildren().add(cr_vbox);
        root.getChildren().add(canvas_panel);
        StackPane holder = new StackPane();
        holder.getChildren().add(canvas_panel);
        list_vbox.getChildren().addAll(list_label, create_list, add_fig_l, hide_fig_l, del_fig_l, move_x_label_l, move_l_x, move_y_label_l, move_l_y, move_l);
        mass_vbox.getChildren().addAll(mass_label, create_mass, add_fig_m, hide_fig_m, del_fig_m, move_x_label_m, move_m_x, move_y_label_m, move_m_y, move_m, list_vbox);
        holder.getChildren().addAll(mass_vbox);
        list_vbox.setAlignment(Pos.BOTTOM_LEFT);
        mass_vbox.setAlignment(Pos.BASELINE_RIGHT);
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

        move_vbox.getChildren().addAll(moving_label, to_move_combo_box, move_x_label, move_x,move_y_label, move_y, to_move,to_move_only, to_move_all);
        move_vbox.setAlignment(Pos.CENTER);
        move_vbox.setPadding(new Insets(0, 10, 10, 5));

        hide_vbox.getChildren().addAll(visibility_label, to_hide_combo_box,to_hide, to_hide_all);
        hide_vbox.setAlignment(Pos.CENTER);
        hide_vbox.setPadding(new Insets(0, 10, 5, 0));

        del_vbox.getChildren().addAll(del_label, to_del_combo_box,to_delete, del_all);
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
        el_vbox.setPadding(new Insets(3, 10, 5, 5));

        par_vbox.getChildren().addAll(par_label, par_x_label, par_x, par_y_label, par_y, par_w_label, par_w, par_height_label, par_h, par_create, par_create_random);
        par_vbox.setAlignment(Pos.CENTER);
        par_vbox.setPadding(new Insets(0, 10, 0, 10));

        int WIDTH = 1650;
        int HEIGHT = 890;
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("FigureDrawer");
        act_vbox.setStyle("-fx-background-color: gray");
        rec_vbox.setStyle("-fx-background-color: gray");
        primaryStage.setScene(scene);
        primaryStage.show();
        rec_create_random.setOnAction(e -> {
            figures[count_of_figure] = new Rectangle();
            figures[count_of_figure].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(figures[count_of_figure].getId(), 1);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_figure++;
        });

        tr_create_random.setOnAction(e -> {
            figures[count_of_figure] = new Triangle();
            figures[count_of_figure].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(figures[count_of_figure].getId(), 2);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_figure++;
        });

        cir_create_random.setOnAction(e ->{
            figures[count_of_figure] = new Circle();
            figures[count_of_figure].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(figures[count_of_figure].getId(), 3);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_figure++;
        });

        el_create_random.setOnAction(e ->{
            figures[count_of_figure] = new Ellipse();
            figures[count_of_figure].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(figures[count_of_figure].getId(), 4);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_figure++;
        });

        par_create_random.setOnAction(e ->{
            figures[count_of_figure] = new Parallelogram();
            figures[count_of_figure].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(figures[count_of_figure].getId(), 5);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_figure++;
        });

        rec_create.setOnAction(e ->
        {
            figures[count_of_figure] = new Rectangle((int)rec_x.getValue(), (int)rec_y.getValue(), (int) rec_w.getValue(), (int) rec_h.getValue(), colorPicker.getValue()) ;
            figures[count_of_figure].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(figures[count_of_figure].getId(), 1);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_figure++;
        });
        tr_create.setOnAction(e ->{
            figures[count_of_figure] = new Triangle((int)tr_x1.getValue(),(int)tr_y1.getValue(), (int)tr_x2.getValue(), (int)tr_y2.getValue(), (int)tr_x3.getValue(), (int)tr_y3.getValue(),colorPicker.getValue());
            figures[count_of_figure].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(figures[count_of_figure].getId(), 2);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_figure++;
        });

        cir_create.setOnAction(e -> {
            figures[count_of_figure] = new Circle((int)cir_x.getValue(), (int) cir_y.getValue(), (int) cir_r.getValue(), colorPicker.getValue());
            figures[count_of_figure].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(figures[count_of_figure].getId(), 3);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_figure++;
        });

        el_create.setOnAction(e -> {
                figures[count_of_figure] = new Ellipse((int) el_x.getValue(), (int) el_y.getValue(), (int) el_r1.getValue(), (int) el_r2.getValue(), colorPicker.getValue());
                figures[count_of_figure].Show(canvas_panel.getGraphicsContext2D(), true);
                mass_of_figures[count_of_figure] = new ComboItem(figures[count_of_figure].getId(), 4);
                to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
                count_of_figure++;
        });

        par_create.setOnAction(e -> {
            figures[count_of_figure] = new Parallelogram((int) par_x.getValue(), (int) par_y.getValue(), (int) par_w.getValue(), (int) par_h.getValue(), colorPicker.getValue());
            figures[count_of_figure].Show(canvas_panel.getGraphicsContext2D(), true);
            mass_of_figures[count_of_figure] = new ComboItem(figures[count_of_figure].getId(), 5);
            to_move_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_hide_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            to_del_combo_box.getItems().add(mass_of_figures[count_of_figure]);
            count_of_figure++;
        });

        to_hide.setOnAction(e -> {
            int i;
            String ans = ((to_hide_combo_box.getValue())).getKey();
            for (i = 0; i < count_of_figure; i++) {
                if (figures[i].getId().equals(ans)) {
                    clearCanvas(canvas_panel.getGraphicsContext2D());
                    figures[i].setV(!figures[i].getV());
                    drawEverything(canvas_panel.getGraphicsContext2D(), figures);
                }
            }
        });

        to_move.setOnAction(e -> {
            int i;
            String ans = to_move_combo_box.getValue().getKey();

            if (mass_of_figures[0] != null) {
                    for (i = 0; i < count_of_figure; i++) {
                        if (figures[i].getId().equals(ans)) {
                            clearCanvas(canvas_panel.getGraphicsContext2D());
                            figures[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
                            drawEverything(canvas_panel.getGraphicsContext2D(), figures);
                        }

                    }
            }
        });

        to_move_all.setOnAction(e ->{
            int i;
                clearCanvas(canvas_panel.getGraphicsContext2D());
                for (i = 0; i < count_of_figure; i++) {
                        figures[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
                }
                drawEverything(canvas_panel.getGraphicsContext2D(), figures);
        });

        to_move_only.setOnAction(e ->{
            int i;
            clearCanvas(canvas_panel.getGraphicsContext2D());
            for (i = 0; i < count_of_figure; i++) {
                if (to_move_only.getValue() == figures[i].getClass())
                    figures[i].MoveTo((int) move_x.getValue(), (int) move_y.getValue());
            }
            drawEverything(canvas_panel.getGraphicsContext2D(), figures);
        });

        to_delete.setOnAction(e -> {
            int i;
            String ans = to_del_combo_box.getValue().getKey();
                for (i = 0; i < count_of_figure; i++) {
                    if (figures[i].getId().equals(ans)) {
                        clearCanvas(canvas_panel.getGraphicsContext2D());
                        del_from_mass_r(figures, i);
                        to_move_combo_box.getItems().remove(mass_of_figures[i]);
                        to_hide_combo_box.getItems().remove(mass_of_figures[i]);
                        to_del_combo_box.getItems().remove(mass_of_figures[i]);
                        del_from_mass(mass_of_figures, i);
                        count_of_figure--;
                        drawEverything(canvas_panel.getGraphicsContext2D(), figures);
                    }
                }
        });

        to_hide_all.setOnAction(e -> {
            hideEverything(canvas_panel.getGraphicsContext2D(), figures);
        });

        del_all.setOnAction(e ->{
            free(figures, count_of_figure);
        });

        create_list.setOnAction(e ->{
            list = new List();
        });

        add_fig_l.setOnAction(e ->{
            //Random ran = new Random();
            int rand = ((int) (Math.random() * 5));
            if (list != null) {
                switch (rand) {
                    case (1):
                        list.add(new Rectangle());
                        break;
                    case (2):
                        list.add(new Triangle());
                        break;
                    case (3):
                        list.add(new Circle());
                        break;
                    case (4):
                        list.add(new Ellipse());
                        break;
                    case (5):
                        list.add(new Parallelogram());
                        break;
                }
                list.getF().Show(canvas_panel.getGraphicsContext2D(), true);
            }
            else {
                System.out.println("Create list at first");
            }
        });

        hide_fig_l.setOnAction(e ->{
            Node tmp = list.getHead();
            clearCanvas(canvas_panel.getGraphicsContext2D());
            while (tmp != null)
            {
                tmp.getFigure().setV(!tmp.getFigure().getV());
                tmp = tmp.getNext();
            }
            drawEverything(canvas_panel.getGraphicsContext2D(), figures);
            list.show(canvas_panel.getGraphicsContext2D());
        });

        del_fig_l.setOnAction(e ->{
            list.clear();
            clearCanvas(canvas_panel.getGraphicsContext2D());
            drawEverything(canvas_panel.getGraphicsContext2D(), figures);
        });

        move_l.setOnAction(e ->{
            clearCanvas(canvas_panel.getGraphicsContext2D());
            list.move((int)move_l_x.getValue(), (int) move_l_y.getValue());
            drawEverything(canvas_panel.getGraphicsContext2D(), figures);
            list.show(canvas_panel.getGraphicsContext2D());
        });

        create_mass.setOnAction(e ->{
            mass = new Mass(5);
            System.out.println("Array is created");
        });

        add_fig_m.setOnAction(e ->{
            int rand = ((int) (Math.random() * 5));
            if (mass != null) {
                switch (rand) {
                    case (1):
                        mass.add(new Rectangle());
                        break;
                    case (2):
                        mass.add(new Triangle());
                        break;
                    case (3):
                        mass.add(new Circle());
                        break;
                    case (4):
                        mass.add(new Ellipse());
                        break;
                    case (5):
                        mass.add(new Parallelogram());
                        break;
                }
                mass.show(canvas_panel.getGraphicsContext2D());
            }
            else {
                System.out.println("Create array at first");
            }
        });

        hide_fig_m.setOnAction(e ->{
            clearCanvas(canvas_panel.getGraphicsContext2D());
            mass.changeV();
            drawEverything(canvas_panel.getGraphicsContext2D(), figures);
            mass.show(canvas_panel.getGraphicsContext2D());
        });

        del_fig_m.setOnAction(e ->{
            clearCanvas(canvas_panel.getGraphicsContext2D());
            mass.delete();
            drawEverything(canvas_panel.getGraphicsContext2D(), figures);
        });

        move_m.setOnAction(e ->{
            clearCanvas(canvas_panel.getGraphicsContext2D());
            mass.move((int)move_m_x.getValue(), (int) move_m_y.getValue());
            drawEverything(canvas_panel.getGraphicsContext2D(), figures);
            mass.show(canvas_panel.getGraphicsContext2D());
        });
    }

    public void del_from_mass_r(TFigure[] m, int ind)
    {
        if (299 - ind >= 0) System.arraycopy(m, ind + 1, m, ind, 299 - ind);
        m[299] = null;
    }

    public void del_from_mass(ComboItem [] m, int ind)
    {
        if (899 - ind >= 0) System.arraycopy(m, ind + 1, m, ind, 899 - ind);
        m[899] = null;
    }

    public void hideEverything(GraphicsContext gc, TFigure [] figures)
    {
        int i;
        clearCanvas(canvas_panel.getGraphicsContext2D());
        for (i = 0; i < count_of_figure; i++) {
            figures[i].setV(!figures[i].getV());
        }
        drawEverything(gc, figures);
    }

    public void clearCanvas(GraphicsContext gc){
        gc.clearRect(canvas_panel.getLayoutX(), canvas_panel.getLayoutY(), canvas_panel.getWidth(), canvas_panel.getHeight());
    }

    public void drawEverything(GraphicsContext gc, TFigure [] figures)
    {
        if (figures[0] == null)
            System.out.println("mass is empty");
        clearCanvas(gc);
        if (figures[0] != null) {
            int i;
            for (i = 0; i < count_of_figure; i++) {
                figures[i].Show(gc, figures[i].getV());
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void free(TFigure [] figures, int count_of_figure)
    {
        for (int i = 0; i < count_of_figure; i++)
        {
            figures[i] = null;
        }
        System.gc();
        drawEverything(canvas_panel.getGraphicsContext2D(), figures);
    }

    int count_of_figure = 0;
    Group root = new Group();
    HBox cr_vbox = new HBox();
    VBox act_vbox = new VBox();
    VBox rec_vbox = new VBox();
    VBox move_vbox = new VBox();
    VBox hide_vbox = new VBox();
    VBox del_vbox = new VBox();
    VBox el_vbox = new VBox();
    VBox par_vbox = new VBox();
    VBox list_vbox = new VBox();
    VBox mass_vbox = new VBox();

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
    Button del_all = new Button("Delete all");

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
    ComboBox<Class>  to_move_only= new ComboBox<Class>();
    Label move_x_label_l = new Label("dx:                               ");
    Label move_y_label_l = new Label("dy:                               ");
    Label move_x_label_m = new Label("dx:                               ");
    Label move_y_label_m = new Label("dy:                               ");



    Label list_label = new Label("        List");
    Label mass_label = new Label("Array       ");
    Button create_list =new Button("Create list");
    Button add_fig_l = new Button("Add figure");
    Button hide_fig_l = new Button("Hide/Show figures");
    Button del_fig_l =new Button("Delete");
    Spinner move_l_x = new Spinner(-1300, 1300, 0);
    Spinner move_l_y = new Spinner(-880, 880, 0);
    Button move_l = new Button("Move figures");

    Button create_mass =new Button("Create mass");
    Button add_fig_m = new Button("Add figure");
    Button hide_fig_m = new Button("Hide/Show figures");
    Button del_fig_m =new Button("Delete");
    Spinner move_m_x = new Spinner(-1300, 1300, 0);
    Spinner move_m_y = new Spinner(-880, 880, 0);
    Button move_m = new Button("Move figures");

    Label visibility_label = new Label("  Visibility layers:               ");
    Button to_hide = new Button("Hide / Show");
    Label emt1 = new Label(" ");
    Label emt2 = new Label(" ");
    Label emt3 = new Label(" ");
    ColorPicker colorPicker = new ColorPicker();
}

