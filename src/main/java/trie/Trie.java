package trie;

import trie.node.RawTrieNode;
import trie.node.TrieNode;
import trie.node.TrieNodeDetails;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Trie<T>
{
    private TrieNode<T> root;
    private Map<TrieNode<T>, LinkedList<TrieNode<T>>> neighbours = new HashMap<>();
    private final boolean removeLoops;

    // the standard case will be to: visit the loop only once if it is a normal loop or self loop
    public Trie()
    {
        this(true);
    }

    public Trie(boolean removeLoops)
    {
        this.removeLoops = removeLoops;
    }

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

        if (!parentsAllChildren.contains(newNode))
            parentsAllChildren.add(newNode);

    }


    public TrieNode<T> createTrieNode(T newNode, int currentLevel, TrieNode<T> parentTrieNode)
    {
        TrieNode<T> trieNode;
        if(removeLoops)
            trieNode = new RawTrieNode<T>(newNode);
        else
            trieNode = new TrieNodeDetails<T>(newNode, currentLevel, (TrieNodeDetails<T>) parentTrieNode);

        if (!neighbours.containsKey(trieNode))
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

