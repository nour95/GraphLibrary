package trie;

import java.util.Objects;

public class TrieNodeDetails<T> implements TrieNode<T>
{
    private T data;
    private int level; // level
    private TrieNodeDetails<T> parent;
    private boolean visited; //todo may be already in the graph

    public TrieNodeDetails(T data)
    {
        this.data = data;
    }

    public TrieNodeDetails(T data, int level, TrieNodeDetails<T> parent)
    {
        this.data = data;
        this.level = level;
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TrieNodeDetails<T> getParent() {
        return parent;
    }

    public void setParent(TrieNodeDetails<T> parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrieNodeDetails<?> trieNode = (TrieNodeDetails<?>) o;
        return data.equals(trieNode.data) && level == trieNode.level && parent.equals(trieNode.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, level, parent);
    }

    @Override
    public String toString()
    {
        String s = data.toString() + " at level " + level + " that has the parent: ";
        if (parent != null)
            s += parent.getData();
        else
            s += "null";

        return s;
    }
}
