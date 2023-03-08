public class Postfix {

    public static double evaluate(String[] expression) {
        try {
            Stack<String> stack = new Stack();
            double num1; double num2;
            for (String token: expression){
                if (token.equals("+")){
                    num1 = Double.parseDouble(stack.pop()); num2 = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(num1 + num2));
                }
                else if (token.equals("-")){
                    num1 = Double.parseDouble(stack.pop()); num2 = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(num2-num1));
                }
                else if (token.equals("/")){
                    num1 = Double.parseDouble(stack.pop()); num2 = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(num2/num1));
                }
                else if (token.equals("*")){
                    num1 = Double.parseDouble(stack.pop()); num2 = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(num1*num2));
                }
                else {
                    stack.push(token);
                }
            }
            return Double.parseDouble(stack.pop());
        } catch (StackException e){
            System.out.println(e.getSize());
        } finally {
            System.out.println("Evaluation complete.");
        }
        return 0.0;
    }

    public static void main(String[] args) {
        String[] expression = {"1", "2", "5", "6", "7", "8", "+", "3", "4", "+", "/"};
        System.out.println("The expression is: (1 + 2 + 5 + 6 + 7 + 8) / (3 + 4)");
        evaluate(expression);
    }

}
