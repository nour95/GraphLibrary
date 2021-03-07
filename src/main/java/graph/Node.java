package graph;

import java.util.Objects;

public class Node<D>
{
    private D data;

    public Node(D data)
    {
        this.data = data;
    }

    public D getData() {
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
