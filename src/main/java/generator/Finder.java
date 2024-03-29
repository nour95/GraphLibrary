package generator;

import graph.Edge;
import graph.Graph;
import graph.Node;
import trie.node.TrieNode;
import trie.Trie;

public class Finder<NT, D>
{

    private Trie<Edge<NT, D>> trie;

    public Finder(boolean removeLoops)
    {
        this.trie = new Trie<>(removeLoops);
    }


    //todo have this as atatic method that take the type
    public void runFinder(Graph<NT, D> graph, Edge<NT, D> initialEdgeWithoutHead, int depth)
    {
        // set a destination to this edge ..
        Node<NT> root = graph.getRoot();

        trie.addInitialEdge(initialEdgeWithoutHead);
        TrieNode<Edge<NT, D>> source = trie.getRoot();

        findAllPaths(graph, depth, 1, initialEdgeWithoutHead, source);
    }


    private void findAllPaths(Graph<NT, D> graph, int depth, int currentLevel, Edge<NT, D> parentEdge, TrieNode<Edge<NT, D>> parentTrieNode)
    {
        if(depth == 0)
            return;
        if(graph.isLeaf(parentEdge.getDestination())) //todo // and maybe move it to the edge class parentEdge.getDestination().isLeaf
            return;

        //LinkedList<Edge<T>> x = graph.edgesComingOutOfNode(parentEdge.getDestination());
        for (Edge<NT, D> outGoingEdge : graph.edgesComingOutOfNode(parentEdge.getDestination())) // todo and think where to put it
        {

            //Node<Edge<T>> childNode = new Node<Edge<T>>(outGoingEdge);
            TrieNode<Edge<NT, D>> childTrieNode = trie.createTrieNode(outGoingEdge, currentLevel, parentTrieNode); //

            trie.add(childTrieNode, parentTrieNode);
            findAllPaths(graph, depth - 1, currentLevel + 1, outGoingEdge, childTrieNode);

        }

    }








    public Trie<Edge<NT, D>> getTrie()
    {
        return trie;
    }


}
