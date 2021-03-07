package graph;

import java.util.Objects;

/**
 * NDT (Node Data Type; type of the data content in the node)
 * EDT (Edge Data Type; type of the data content in the edge)
 */
public class Edge<NDT, EDT> implements EdgeWrapper<NDT>
{
    private Node<NDT> from;
    private Node<NDT> to;
    private EDT data;

    public Edge(Node<NDT> from, Node<NDT> to) {
        this.from = from;
        this.to = to;
        this.data = null;
    }

    public Edge(Node<NDT> from, Node<NDT> to, EDT data)
    {
        this.from = from;
        this.to = to;
        this.data = data;
    }


    public Node<NDT> getDestination() {
        return to;
    }

    public Node<NDT> getSource() {
        return from;
    }

    public EDT getData() {
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
