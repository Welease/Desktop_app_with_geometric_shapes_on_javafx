package sample;

public class Node {
    private Node next;
    private TFigure figure;

    public Node(TFigure figure) {
        this.figure = figure;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public TFigure getFigure() {
        return figure;
    }

    public void setFigure(TFigure figure) {
        this.figure = figure;
    }
}
