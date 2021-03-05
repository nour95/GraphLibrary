import java.util.LinkedList;

public class Finder<T>
{

    private Trie<Edge<T>> trie = new Trie<>();

    public void runFinder(Graph<T> graph, int depth)
    {
        // set a destination to this edge ..
        Node<T> root = graph.getRoot();
        Edge<T> initialEdgeWithoutHead = new Edge<>(null, root);


        trie.addInitialEdge(initialEdgeWithoutHead); //todo
        TrieNode<Edge<T>> source = trie.getRoot();

        findAllPaths(graph, depth, 1, initialEdgeWithoutHead, source);
    }


    private void findAllPaths(Graph<T> graph, int depth,  int currentLevel, Edge<T> parentEdge, TrieNode<Edge<T>> parentTrieNode)
    {
        if(depth == 0)
            return;
        if(graph.isLeaf(parentEdge.getDestination())) //todo // and maybe move it to the edge class parentEdge.getDestination().isLeaf
            return;

        //LinkedList<Edge<T>> x = graph.edgesComingOutOfNode(parentEdge.getDestination());
        for (Edge<T> outGoingEdge : graph.edgesComingOutOfNode(parentEdge.getDestination())) // todo and think where to put it
        {

            //Node<Edge<T>> childNode = new Node<Edge<T>>(outGoingEdge);
            TrieNode<Edge<T>> childTrieNode = trie.createTrieNode(outGoingEdge, currentLevel, parentTrieNode); //

            trie.add(childTrieNode, parentTrieNode);
            findAllPaths(graph, depth - 1, currentLevel + 1, outGoingEdge, childTrieNode);

        }





    }

    public Trie<Edge<T>> getTrie()
    {
        return trie;
    }


}
