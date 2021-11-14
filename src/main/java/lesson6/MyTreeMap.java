package lesson6;

import java.util.NoSuchElementException;

public class MyTreeMap <K extends Comparable<K>, V>{
    private Node root;
    private class Node{
        K key;
        V value;
        Node left;
        Node right;
        int size;
        int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.size = 1;
            this.height = 0;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node node) {
        if(node == null){
            return 0;
        }
        return node.size;
    }

    public int height(){
        return height(root) ;
    }

    private int height(Node node) {
        if(node == null){
            return 0;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    private void checkKeyNotNull(K key){
        if(key == null){
            throw new IllegalArgumentException("Key is null");
        }
    }

    public boolean contains(K key){
        return get(key) != null;
    }

    public V get(K key){
        checkKeyNotNull(key);
        return get(root, key);
    }

    private V get(Node node, K key) {
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            return node.value;
        }
        if(cmp < 0){
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }

    }

    public void put(K key, V value){
        checkKeyNotNull(key);
        if(value == null){
            //remove
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if(node == null){
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            node.value = value;
        } else if (cmp < 0){
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        if(node.left == null && node.right == null){
            node.height = 0;
        } else {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
        return node;

    }

    public K minKey(){
        return min(root).key;
    }

    private Node min(Node node) {
        if(node.left == null){
            return node;
        }
        return min(node.left);
    }

    public void removeMin(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        root = removeMin(root);
    }

    private Node removeMin(Node node) {
        if(node.left == null){
            return node.right;
        }
        node.left = removeMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void remove(K key){
        checkKeyNotNull(key);
        root = remove(root, key);
    }

    private Node remove(Node node, K key) {
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.left = remove(node.left, key);
        } else if (cmp > 0){
            node.right = remove(node.right, key);
        } else {
            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = removeMin(temp);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        if(node.left == null && node.right == null){
            node.height = 0;
        } else {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
        return node;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node){
        if(node == null){
            return "";
        }
        return toString(node.left) + " " + node.key + "=" + node.value + " " + toString(node.right);
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if(node == null){
            return true;
        }
        if(Math.abs(height(node.left) - height(node.right)) > 1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }
}
