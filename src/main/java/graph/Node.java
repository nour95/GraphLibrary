package graph;

import java.util.Objects;

/**
 * NDT (Node Data Type; type of the data content in the node)
 * EDT (Edge Data Type; type of the data content in the edge)
 */
public class Node<NDT>
{
    private NDT data;

    public Node(NDT data)
    {
        this.data = data;
    }

    public NDT getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "n" + data.toString() + "";
    }
}
