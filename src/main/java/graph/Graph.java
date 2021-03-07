package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

//https://algorithms.tutorialhorizon.com/weighted-graph-implementation-java/
public class Graph<NT, D>
{
    private int nodeNumber;
    private Node<NT> root;
    private Map<Node<NT>, LinkedList<Edge<NT, D>>> adjacencyMap;

    public Graph() {} // todo remove this

    public Graph(Node<NT> root, int nodeNumber)
    {
        this.root = root;
        this.nodeNumber = nodeNumber;
        adjacencyMap = new HashMap<>(nodeNumber);
    }

    //for directed graph
    public void addEdge(Node<NT> source, Node<NT> destination)
    {
        addEdge(source, destination, null);
    }

    public void addEdge(Node<NT> source, Node<NT> destination, D data)
    {
        Edge<NT, D> edge = new Edge<>(source, destination, data);

        if (adjacencyMap.containsKey(source)) // old key
            adjacencyMap.get(source).add(edge);
        else // new key
        {
            LinkedList<Edge<NT, D>> newList  = new LinkedList<>();
            newList.add(edge);
            adjacencyMap.put(source, newList);
        }

    }




    public Node<NT> getRoot()
    {
        return root;
    }


    public boolean isLeaf(Node<NT> node) //todo maybe just have a boolean inside the node class to tell if it is a leaf or not
    {
        if (adjacencyMap.get(node) == null)
            return true;
        else if (adjacencyMap.get(node).size() == 0) //this will never happen probably
            return true;
        else
            return false;
    }

    public LinkedList<Edge<NT, D>> edgesComingOutOfNode(Node<NT> node)
    {
        return adjacencyMap.get(node);
    }



    //for debugging
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Set<Node<NT>> keys = adjacencyMap.keySet();
        LinkedList<Edge<NT, D>> list;

        for (Node<NT> node : keys)
        {
            list = adjacencyMap.get(node);

            for (Edge<NT, D> data : list)
                sb.append(data).append("\n");;
        }

        return sb.toString();
    }















}
