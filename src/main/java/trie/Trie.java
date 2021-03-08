package trie;

public interface Trie<T>
{
    void addInitialEdge(T initDataWithoutHead);
    void add(TrieNode<T> newNode, TrieNode<T> parentNode);
    TrieNode<T> createTrieNode(T newNode, int currentLevel, TrieNode<T> parentTrieNode);
    TrieNode<T> getRoot();

}
