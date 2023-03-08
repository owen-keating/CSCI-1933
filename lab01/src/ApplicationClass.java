
public class ApplicationClass {

    // milestone 4

    /*private double radius;

    public ApplicationClass(double r){
        radius = r;
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double r){
        radius = r;
    }

    public double getArea(){
        return radius*radius*3.14159;
    }

    public double getDiameter(){
        return radius*2;
    }

    public double getCircumference(){
        return radius*2*3.14159;
    }

    public boolean equals(ApplicationClass a){
        boolean e = false;
        if(radius==a.getRadius()){
            e = true;
        }
        return e;
    }*/

    // milestone 3

    private String str;
    private int len;
    private int first;

    public ApplicationClass(String s, int l) {
        len = l;
        str = s;
        first = 0;
    }

    public boolean isPalindrome(){
        if(len==0)
            return true;
        else if(str.charAt(len-1)!=str.charAt(first))
            return false;
        else{
            len-=1;
            first+=1;
            return isPalindrome();
        }
    }

}
