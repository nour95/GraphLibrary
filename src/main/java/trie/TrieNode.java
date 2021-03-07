package trie;

public class TrieNode<T>
{
    private T data;
    private int level; // level
    private TrieNode<T> parent;


    public TrieNode(T data, int level, TrieNode<T> parent)
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

    public TrieNode<T> getParent() {
        return parent;
    }

    public void setParent(TrieNode<T> parent) {
        this.parent = parent;
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
