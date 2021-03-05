public class Edge<T>
{
    private Node<T> from;
    private Node<T> to;

    public Edge(Node<T> from, Node<T> to) {
        this.from = from;
        this.to = to;
    }



    public Node<T> getDestination() {
        return to;
    }

    public Node<T> getSource() {
        return from;
    }

    @Override
    public String toString()
    {
        if (from == null)
            return "edge: " + from + " -> " + to.toString(); //todo
        else
            return "edge: " + from.toString() + " -> " + to.toString();
    }
}
