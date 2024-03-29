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



    //---------------------------------

    // methods for modbat:
    public LinkedList<TrieNode<T>> getChildren(TrieNode<T> parent)
    {
        return neighbours.get(parent);
    }


    public void markAsVisit(TrieNode<T> node2)
    {
        TrieNodeDetails<T> node = (TrieNodeDetails) node2; //todo

        if (isLeaf(node))
        {
            node.setVisited(true); // set the leaf

            // set the leaf's parent:
            TrieNode<T> parent = node.getParent();


        }
    }

    public boolean hasUnVisitedChildren(TrieNode<T> node)
    {
        // a more efficient way is store the number of unvisited children in the trieNode (-1 if unknown to be calculated later), 0 if no more unvisited children
        // and decrese the number each time we set a leaf. and so on until we reach the source
        return false;
    }

    public boolean isLeaf(TrieNode<T> node)
    {
        return  (neighbours.get(node) == null) || neighbours.get(node).isEmpty(); //todo not sure about the null thing
    }


    public TrieNode<T> findUnvisitedNode(TrieNode<T> parent)
    {
        LinkedList<TrieNode<T>> childrenList =  neighbours.get(parent);

        for (TrieNode<T> node : childrenList)
        {
            if (! node.isVisited())
                return node;
            //todo else remove from list ?? increase effeicincy

        }


        return null;
    }


    public void markVisitedUpToTheFirstParentWithUnvisitedNode(TrieNode<T> child)
    {
        child.setVisited(true);

        for (TrieNode<T> currentNode = child.getParent() ; findUnvisitedNode(currentNode) == null ; currentNode = currentNode.getParent() )
        {
            currentNode.setVisited(true);
        }


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

