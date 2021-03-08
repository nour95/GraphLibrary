package trie.node;

import java.util.Objects;

public class RawTrieNode<T> implements TrieNode<T>
{

    private T data;
    private boolean visited; //todo may be already in the graph

    public RawTrieNode(T data)
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
