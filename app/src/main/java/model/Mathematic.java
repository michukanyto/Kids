package model;

public class Mathematic {
    private boolean operator;
    int result;

    public Mathematic(boolean operator) {
        this.operator = operator;
    }

    public boolean isOperator() {
        return operator;
    }

    public void setOperator(boolean operator) {
        this.operator = operator;
    }

    public boolean makeOperation(int index1, int index2, int userAnswer){
        if (operator)
          result = multiplication(index1,index2);
        else
          result = addition(index1,index2);

        return checkAnswer(result,userAnswer);
    }

    private int addition(int index1, int index2){
        return index1 + index2;
    }

    private int multiplication(int index1, int index2){
        return index1 * index2;
    }

    private boolean checkAnswer(int result, int userAnswer){
        return result == userAnswer?true:false;

    }

}
