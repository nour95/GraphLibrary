package graph;

import java.util.Objects;

public class Edge<NT, D> implements EdgeWrapper<NT>
{
    private Node<NT> from;
    private Node<NT> to;
    private D data;

    public Edge(Node<NT> from, Node<NT> to) {
        this.from = from;
        this.to = to;
        this.data = null;
    }

    public Edge(Node<NT> from, Node<NT> to, D data)
    {
        this.from = from;
        this.to = to;
        this.data = data;
    }


    public Node<NT> getDestination() {
        return to;
    }

    public Node<NT> getSource() {
        return from;
    }

    public D getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?, ?> edge = (Edge<?, ?>) o;
        return from.equals(edge.from) && to.equals(edge.to) && data.equals(edge.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, data);
    }

    @Override
    public String toString()
    {
        if (from == null)
            return "edge: " + from + " -> " + to.toString();
        else
            return "edge: " + from.toString() + " -> " + to.toString();
    }
}
