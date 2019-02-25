package model;

import com.appsmontreal.kids.MainActivity;

public class Mathematic {
    private MainActivity.Operation operation;
    int result;

    public Mathematic(MainActivity.Operation operator) {
        this.operation = operator;
    }


    public boolean makeOperation(int index1, int index2, int userAnswer){
        if (operation == MainActivity.Operation.MULTIPLY) {
            result = multiplication(index1, index2);
        }
        else {
            result = addition(index1, index2);
        }

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
