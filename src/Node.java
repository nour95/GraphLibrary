public class Node<T>
{
    private T data;

    public Node(T data)
    {
        this.data = data;
    }

    @Override
    public String toString() {
        return "n" + data.toString() + "";
    }
}
