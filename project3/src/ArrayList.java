//  Written by Owen Keating, keati090

public class ArrayList<T extends Comparable<T>> implements List<T> {

    private T[] a;
    private int size;
    private boolean isSorted;

    public ArrayList() {
        a = (T[]) new Comparable[2];
        isSorted = true;
        size = 0;
    }

    public boolean add(T element) {
        if (element == null) return false;
        if (size == a.length) expand();
        a[size++] = element;
        if(isSorted) checkSorted();
        return true;
    }

    public boolean add(int index, T element) {
        if (element == null || index < 0 || index >= size) return false;
        if (a[index] != null) {
            if (size == a.length) expand();
            for (int i = size; i > index; i--) a[i] = a[i - 1];
        }
        a[index] = element;
        size++;
        if(isSorted) checkSorted();
        return true;
    }

    private void expand() {
        T[] temp = (T[]) new Comparable[a.length * 2];
        System.arraycopy(a, 0, temp, 0, a.length);
        a = temp;
    }

    public void checkSorted() {
        isSorted = true;
        for(int i = 1; i<size; i++){
            if(a[i].compareTo(a[i-1])<0){
                isSorted = false;
                break;
            }
        }
    }

    public void clear(){
        a = (T[]) new Comparable[2];
        isSorted = true;
        size = 0;
    }

    public T get(int index){
        if(index< 0||index>=a.length) return null;
        return a[index];
    }

    public int indexOf(T element){
        if(element==null){ return -1; }
        for(int i = 0; i<a.length; i++){
            if(element.equals(a[i])) return i;
        }
        return -1;
    }

    public boolean isEmpty(){
        if(size==0) return true;
        return false;
    }

    public int size(){ return size; }

    public void sort(){
        if(!isSorted){
            for(int i = 0; i<size-1; i++){
                int x = i;
                for(int j = i+1; j<size; j++){
                    if(a[j].compareTo(a[x])<0){
                        x = j;
                    }
                }
                T temp = a[x];
                a[x] = a[i];
                a[i] = temp;
            }
            isSorted = true;
        }
    }

    public T remove(int index) {
        if(index<0||index>=size) return null;
        T temp = a[index]; a[index] = null; size--;
        for(int i = index; i<size; i++){
            a[i] = a[i+1];

        }
        a[size] = null;
        if(!isSorted()) checkSorted();
        return temp;
    }

    public void equalTo(T element){
        for(int i = 0; i<size; i++){
            if(a[i].compareTo(element)!=0){
                remove(i);
                i--;
            }
        }
        isSorted = true;
    }

    public void reverse(){
        for(int i = 0; i<size/2; i++){
            T temp = a[i];
            a[i] = a[size-i-1];
            a[size-i-1] = temp;
        }
        checkSorted();
    }

    public void merge(List<T> otherList){
        ArrayList<T> other = (ArrayList<T>) otherList;
        if(other!=null&&a[0]!=null){
            sort();
            other.sort();
            T[] temp = (T[]) new Comparable[size+other.size];
            int x = 0; int y = 0;
            size = temp.length;
            for(int i = 0; i<temp.length; i++){
                if (a[x] == null) temp[i] = other.a[y++];
                else if (other.a[y] == null) temp[i] = a[x++];
                else if (a[x].compareTo(other.a[y])<=0) temp[i] = a[x++];
                else if (other.a[y].compareTo(a[x])<0) temp[i] = other.a[y++];
            }
            a = temp;
        }
    }

    public boolean rotate(int n){
        if(n<=0||size<=1) return false;
        n%=size;
        for(int i = 0; i<n; i++){
            add(0,remove(size-1));
        }
        checkSorted();
        return true;
    }

    public String toString(){
        String str = "";
        if(isEmpty()) System.out.println("Empty list");
        else{
            for(int i = 0; i<a.length; i++){
                str+=a[i]+"\n";
            }
        }
        return str;
    }

    public boolean isSorted(){ return isSorted; }

}
