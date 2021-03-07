package graph;

import java.util.*;

//https://algorithms.tutorialhorizon.com/weighted-graph-implementation-java/
/**
 * NDT (Node Data Type; type of the data content in the node)
 * EDT (Edge Data Type; type of the data content in the edge)
 */
public class Graph<NDT, EDT>
{
    private int nodeNumber;
    private Node<NDT> root;
    private Map<Node<NDT>, LinkedList<Edge<NDT, EDT>>> adjacencyMap;

    public Graph(Node<NDT> root, int nodeNumber)
    {
        this.root = root;
        this.nodeNumber = nodeNumber;
        adjacencyMap = new HashMap<>(nodeNumber);
    }

    // TODO: addEdge(Edge<NDT, EDT>)

    //for directed graph
    public void addEdge(Node<NDT> source, Node<NDT> destination)
    {
        addEdge(source, destination, null);
    }

    public void addEdge(Node<NDT> source, Node<NDT> destination, EDT data)
    {
        Edge<NDT, EDT> edge = new Edge<>(source, destination, data);

        if (adjacencyMap.containsKey(source)) // old key
            adjacencyMap.get(source).add(edge);
        else // new key
        {
            LinkedList<Edge<NDT, EDT>> newList  = new LinkedList<>();
            newList.add(edge);
            adjacencyMap.put(source, newList);
        }

    }




    public Node<NDT> getRoot()
    {
        return root;
    }


    public boolean isLeaf(Node<NDT> node) //todo maybe just have a boolean inside the node class to tell if it is a leaf or not
    {
        if (adjacencyMap.get(node) == null)
            return true;
        else if (adjacencyMap.get(node).size() == 0) //this will never happen probably
            return true;
        else
            return false;
    }

    public List<Edge<NDT, EDT>> edgesComingOutOfNode(Node<NDT> node)
    {
        return adjacencyMap.get(node);
    }

    public Set<Node<NDT>> getNodes() { return adjacencyMap.keySet(); }

    //for debugging
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Set<Node<NDT>> keys = adjacencyMap.keySet();
        LinkedList<Edge<NDT, EDT>> list;

        for (Node<NDT> node : keys)
        {
            list = adjacencyMap.get(node);

            for (Edge<NDT, EDT> data : list)
                sb.append(data).append("\n");;
        }

        return sb.toString();
    }















}
