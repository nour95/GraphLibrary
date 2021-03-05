import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

//https://algorithms.tutorialhorizon.com/weighted-graph-implementation-java/
public class Graph<T>
{
    private int nodeNumber;
    private Node<T> root;
    private Map<Node<T>, LinkedList<Edge<T>>> adjacencyMap; //todo may convert this to map<node, list>

    public Graph() {} // todo remove this

    public Graph(Node<T> root, int nodeNumber)
    {
        this.root = root;
        this.nodeNumber = nodeNumber;
        adjacencyMap = new HashMap<>(nodeNumber);

//        //initialize adjacency lists for all the nodes
//        for (int i = 0; i <nodeNumber ; i++)
//        {
//            adjacencyList[i] = new LinkedList<>();
//        }
    }

    //for directed graph
    public void addEdge(Node<T> source, Node<T> destination)
    {
        Edge<T> edge = new Edge<>(source, destination);

        if (adjacencyMap.containsKey(source)) // old key
            adjacencyMap.get(source).add(edge);
        else // new key
        {
            LinkedList<Edge<T>> newList  = new LinkedList<>();
            newList.add(edge);
            adjacencyMap.put(source, newList);
        }

    }


    //for debugging
    public void printGraph()
    {
        Set<Node<T>> nodeSet  = adjacencyMap.keySet();
        for (Node<T> node : nodeSet)
        {
            LinkedList<Edge<T>> list = adjacencyMap.get(node);
            for (int j = 0; j < list.size() ; j++)
            {
                System.out.println("node-" + node + " is connected to " +
                        list.get(j).getDestination());  //todo toString methods
            }
        }
    }

    public Node<T> getRoot()
    {
        return root;
    }


    public boolean isLeaf(Node<T> node) //todo maybe just have a boolean inside the node class to tell if it is a leaf or not
    {
        if (adjacencyMap.get(node) == null)
            return true;
        else if (adjacencyMap.get(node).size() == 0) //this will never happen probably
            return true;
        else
            return false;
    }

    public LinkedList<Edge<T>> edgesComingOutOfNode(Node<T> node)
    {
        return adjacencyMap.get(node);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Set<Node<T>> keys = adjacencyMap.keySet();
        LinkedList<Edge<T>> list;

        for (Node<T> node : keys)
        {
            list = adjacencyMap.get(node);

            for (Edge<T> data : list)
                sb.append(data).append("\n");;
        }

        return sb.toString();
    }















}
