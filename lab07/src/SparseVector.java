public class SparseVector {

    private Node head;
    private int length;

    public SparseVector(int len){
        head = null;
        length = len;
    }

    public String toString(){
        String result = "";
        Node currNode = head;
        int currIndex = 0;
        while( currNode != null ){
            int idx = currNode.getIndex();
            while( currIndex < idx ){
                result += "0, ";
                currIndex++;
            }
            result += currNode;
            currNode = currNode.getNext();
            currIndex++;
            if( currNode != null ){ result += ", "; }
        }
        return result;
    }

    public void addElement(int index, double value){
        Node ptr = head;
        if(index>length){
            System.out.println("Invalid index");
        }
        else if(head==null){
            head = new Node(index,value);
        }
        else{
            while(ptr.getNext()!=null){
                ptr = ptr.getNext();
            }
            ptr.setNext(new Node(index,value));
        }
    }

    public static double dot( SparseVector x, SparseVector y ){
        double result = 0.0;
        if(x.length==y.length){
            int len_x = 1; Node ptr_x = x.head;
            int len_y = 1; Node ptr_y = y.head;
            while(ptr_x.getNext()!=null){ ptr_x = ptr_x.getNext(); len_x++; }
            while(ptr_y.getNext()!=null){ ptr_y = ptr_y.getNext(); len_y++; }
            if(len_y>len_x){ len_x = len_y; }
            ptr_x = x.head; ptr_y = y.head;
            for(int i = 0; i<len_x; i++){
                if(ptr_x.getIndex()==ptr_y.getIndex()){
                    result+=ptr_x.getValue()*ptr_y.getValue();
                    ptr_x = ptr_x.getNext();
                    ptr_y = ptr_y.getNext();
                }
                else if(ptr_x.getIndex()<ptr_y.getIndex()){
                    ptr_x = ptr_x.getNext();
                }
                else{
                    ptr_y = ptr_y.getNext();
                }
            }
        }
        else{
            System.out.println("Vectors not of equal length");
        }
        return result;
    }

    public static void main(String[] args) {
        SparseVector x = new SparseVector(100000000);
        x.addElement(0, 1.0);
        x.addElement(10000000, 3.0);
        x.addElement(10000001, -2.0);
        SparseVector y = new SparseVector(100000000);
        y.addElement(0, 2.0);
        y.addElement(10000001, -4.0);
        double result = dot(x, y);
        System.out.println(result);
    }

}