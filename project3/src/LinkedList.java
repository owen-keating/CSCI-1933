//  Written by Owen Keating, keati090

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> head;
    private boolean isSorted;
    private int size;

    public LinkedList() {
        head = null;
        isSorted = true;
        size = 0;
    }

    public boolean add(T element){
        if(element==null) return false;
        else{
            Node<T> node = new Node<T>(element);
            if(isEmpty()){
                head = new Node<T>(null);
                head.setNext(node);
                size++;
            }
            else {
                Node<T> ptr = head;
                while(ptr.getNext()!=null){
                    ptr = ptr.getNext();
                }
                ptr.setNext(node);
                size++;
                if(isSorted) checkSorted();
            }
        }
        return true;
    }

    public boolean add(int index, T element){
        if(index<0||element==null||index>=size) return false;
        else{
            Node<T> node = new Node<T>(element);
            Node<T> first = head;
            Node<T> ptr = head.getNext();
            for(int i = 0; i<index; i++){
                first = ptr;
                ptr = ptr.getNext();
            }
            first.setNext(node);
            node.setNext(ptr);
            size++;
            if(isSorted) checkSorted();
        }
        return true;
    }

    public void checkSorted(){
        isSorted = true;
        Node<T> first = head;
        Node<T> ptr = head.getNext();
        if(first.getData()!=null&&ptr.getData()!=null){
            for(int i = 1; i<size; i++){
                if(first.getData().compareTo(ptr.getData())>0){
                    isSorted = false;
                    break;
                }
            }
        }
    }

    public void clear() {
        head = null;
        isSorted = true;
        size = 0;
    }

    public T get(int index){
        if(index<0||index>=size) return null;
        Node<T> ptr = head.getNext();
        for(int i = 0; i<index; i++){
            ptr = ptr.getNext();
        }
        return ptr.getData();
    }

    public int indexOf(T element) {
        if(element==null||isEmpty()) return -1;
        Node<T> ptr = head.getNext();
        for(int i = 0; i<size; i++){
            if(ptr.getData().compareTo(element)==0) return i;
            ptr = ptr.getNext();
        }
        return -1;
    }

    public boolean isEmpty(){
        if(size==0) return true;
        return false;
    }

    public int size(){ return size; }

    public void sort(){ }

    public T remove(int index){
        if(index<0||index>=size) return null;
        Node<T> first = head;
        Node<T> ptr = head.getNext();
        if(index==size-1){
            while(ptr.getNext()!=null){
                first = ptr;
                ptr = ptr.getNext();
            }
            first.setNext(null);
        }
        else{
            for(int i = 0; i<index; i++){
                first = ptr;
                ptr = ptr.getNext();
            }
            first.setNext(ptr.getNext());
        }
        size--;
        if(!isSorted()) checkSorted();
        return ptr.getData();
    }

    public void equalTo(T element) {
        for(int i = 0; i<size; i++){
            T temp = get(i);
            if(temp.compareTo(element)!=0){
                remove(i);
                i--;
            }
        }
        isSorted = true;
    }

    public void reverse(){
        if(size!=0&&size!=1){
            Node<T> start = head;
            Node<T> ptr = head.getNext();
            start = ptr;
            ptr = ptr.getNext();
            while (ptr!=null) {
                start.setNext(ptr.getNext());
                ptr.setNext(head.getNext());
                head.setNext(ptr);
                ptr = start.getNext();
            }
            checkSorted();
        }
    }

    public void merge(List<T> otherList){ }

    public boolean rotate(int n){
        if (n<=0||size<=1) return false;
        n%=size;
        Node<T> ptr = head.getNext();
        Node<T> trailer = head;
        for (int i = 0; i<size-n; i++) {
            trailer = ptr;
            ptr = ptr.getNext();
        }
        Node<T> end = head;
        while (end.getNext()!=null){
            end = end.getNext();
        }
        end.setNext(head.getNext());
        trailer.setNext(null);
        head.setNext(ptr);
        checkSorted();
        return true;
    }

    public String toString() {
        String str = "";
        if(isEmpty()) System.out.println("Empty list");
        else{
            Node<T> ptr = head.getNext();
            while(ptr!=null) {
                str+=ptr.getData()+"\n";
                ptr = ptr.getNext();
            }
        }
        return str;
    }

    public boolean isSorted(){ return isSorted; }

}