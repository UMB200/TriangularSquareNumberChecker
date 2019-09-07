package com.example.umix.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number{
        int number;
        public boolean isSquare(){
            double s = Math.sqrt(number);
            if(s == Math.floor(s)){
                return true;
            }
            else{
                return false;
            }
        };

        //Check if given number is triangauler
        public boolean isTriangular(){
            int n = 1;
            int triangularNumber = 1;
            while (triangularNumber < number){
                n++;
                triangularNumber +=n;
            }
            if(triangularNumber  == number){
                return true;
            }
            else {
                return false;
            }
        };

    }
    public void testNumber(View view) {

        Log.i("check", "Button pressed");
        EditText editText = (EditText)findViewById(R.id.editText);
        String message = editText.getText().toString();
        //check if user entered valid entry
        if(message.isEmpty()){
            message += " Please enter valid number";
        }
        else {

            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(editText.getText().toString());


            if (myNumber.isSquare() && myNumber.isTriangular()) {
                message += " is square and triangualr";
            } else if (myNumber.isSquare()) {
                message += " is square but not triangular";
            } else if (myNumber.isTriangular()) {
                message += " is triangular but not square";

            } else {
                message += " is neither triangualr nor square";
            }
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
