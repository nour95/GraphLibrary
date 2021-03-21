package trie.node;

import java.util.Objects;

public class RawTrieNode<T> implements TrieNode<T>
{

    private T data;
    private int level; // level
    private TrieNodeDetails<T> parent;
    private boolean visited;

    public RawTrieNode(T data, int level, TrieNodeDetails<T> parent)
    {
        this.data = data;
        this.level = level;
        this.parent = parent;
        this.visited = false;

    }

    public RawTrieNode(T data) //todo delete this completely
    {
        this.data = data;
        visited = false;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public TrieNode<T> getParent() {
        return parent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RawTrieNode<?> trieNode = (RawTrieNode<?>) o;
        return data.equals(trieNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString()
    {
        String s = data.toString();
        return s;
    }
}
