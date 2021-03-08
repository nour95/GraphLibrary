package org.example;

import graph.Edge;
import graph.Graph;
import graph.Node;
import trie.Trie;
import trie.TrieNoLoops;
import trie.TrieWithLoops;

public class GraphGenerator
{

    public Graph<Integer, Object> createAGraph()
    {
        Node<Integer> source = new Node<>(1);

        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n100 = new Node<>(100);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n8 = new Node<>(8);
        Node<Integer> n9 = new Node<>(9);
        Node<Integer> n10 = new Node<>(10);
        Node<Integer> n11 = new Node<>(11);
        Node<Integer> n12 = new Node<>(12);
        Node<Integer> n15 = new Node<>(15);

        Graph<Integer, Object> graph = new Graph<>(source, 12);
        graph.addEdge(source, n2);
        graph.addEdge(source, n100);

        graph.addEdge(n2, n5);
        graph.addEdge(n2, n2);
        graph.addEdge(n2, n4);

        graph.addEdge(n4, n6); // end node

        graph.addEdge(n5, n4);
        graph.addEdge(n5, n8);
        graph.addEdge(n5, n10);

        graph.addEdge(n10, n11);
        graph.addEdge(n10, n12);

        graph.addEdge(n11, n8);
        graph.addEdge(n12, n8);

        graph.addEdge(n8, n9);
        graph.addEdge(n9, n15);


        return graph;
    }

    public void find()
    {
        Graph<Integer, Object> graph = createAGraph();
        System.out.println(graph);

        System.out.println("-----------------");

        Finder<Integer, Object> finder = new Finder<>( new TrieNoLoops<>() );

        Edge<Integer, Object> initEdge = new Edge<>(null, graph.getRoot());
        finder.runFinder(graph, initEdge, 4); //todo or 7

        Trie<Edge<Integer, Object>> trieWithLoops = finder.getTrie();

        System.out.println("all pathes: ");
        System.out.println(trieWithLoops);

    }

    public static void main(String[] args) {
        GraphGenerator generator =  new GraphGenerator();
        generator.find();
    }


}
