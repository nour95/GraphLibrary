package trie.node;

public interface TrieNode<T>
{
    public void setVisited(boolean visited);

    public T getData();
    public TrieNode<T> getParent();

    public boolean isVisited();


    //todo have get parent too
}
