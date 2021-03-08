package trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class TrieWithLoops<T> implements Trie<T>
{
    private TrieNode<T> root;
    private Map<TrieNode<T>, LinkedList<TrieNode<T>>> neighbours = new HashMap<>();

    // can't be a map because we may have duplicate nodes
    /*
    d0:            e0
    d1:        e1     e2
    d2:      e1 e3

    idea 1: have a list of lists (the lists represent the nodes of the trie) and the index of the list represent the depth.
    idea 2: have and id inside each node, this id can represent the depth in the array and aparent to distinguish between them

     */

    public void addInitialEdge(T initDataWithoutHead)
    {
        root = createTrieNode(initDataWithoutHead, 0, null);
    }



    public void add(TrieNode<T> newNode, TrieNode<T> parentNode)
    {
        LinkedList<TrieNode<T>> parentsAllChildren = neighbours.get(parentNode);

        if (parentsAllChildren == null) {
            System.out.println("That is wired");
            return;
        }

        parentsAllChildren.add(newNode);

    }


    public TrieNode<T> createTrieNode(T newNode, int currentLevel, TrieNode<T> parentTrieNode)
    {
        TrieNodeDetails<T> trieNode = new TrieNodeDetails<T>(newNode, currentLevel, (TrieNodeDetails<T>) parentTrieNode);
        neighbours.put(trieNode, new LinkedList<TrieNode<T>>());
        return trieNode;
    }

    public TrieNode<T> getRoot() {
        return root;
    }





    @Override
    public String toString()
    {

        StringBuilder sb = new StringBuilder();
        Set<TrieNode<T>> keys = neighbours.keySet();

        LinkedList<TrieNode<T>> list;
        for (TrieNode<T> key : keys)
        {
            sb.append("children of '" + key + "' are : \n");
            list = neighbours.get(key);
            if (list == null || list.size() == 0) {
                sb.append("list is empty \n");
            }

            for (TrieNode<T> child : list)
            {
                sb.append(child.toString() + "\n");
            }

            sb.append("************\n");


        }





        return sb.toString();

    }
}
