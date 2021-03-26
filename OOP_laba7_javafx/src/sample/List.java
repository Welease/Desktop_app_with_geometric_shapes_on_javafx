package sample;

import javafx.scene.canvas.GraphicsContext;

public class List {
    private Node head;
    private Node tail;

    public List()
    {
        this.head = null;
        this.tail = null;
        System.out.println("List created");
    }

    void add(TFigure f)
    {
        Node node = new Node(f);
        if (head == null)
        {
            head = node;
            node.setNext(tail);
        }
        else{
            tail.setNext(node);
            node.setNext(null);
        }
        tail = node;
    }

    void show(GraphicsContext gc){
        Node tmp = head;
        while(tmp != null){
            tmp.getFigure().Show(gc, tmp.getFigure().getV());
            tmp = tmp.getNext();
        }
    }

    void clear()
    {
        Node tmp = head;
        Node tmp1 = tmp.getNext();
        while (tmp1 != null)
        {
            tmp.setFigure(null);
            tmp.setNext(null);
            tmp = tmp1;
            tmp1 = tmp1.getNext();
        }
        System.gc();
    }

    void move(int dx, int dy)
    {
        Node tmp = head;
        while (tmp != null)
        {
            tmp.getFigure().MoveTo(dx, dy);
            tmp = tmp.getNext();
        }
    }
    public TFigure getF()
    {
        return tail.getFigure();
    }

    public Node getHead(){
        return this.head;
    }
}
