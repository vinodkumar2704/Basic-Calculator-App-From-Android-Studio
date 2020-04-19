package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9, btnDelete, btnPlus,btnSub,btnMul,btnDiv,btnPercentage,btnC,btnDot,btnBrackets,btnEqual;
    TextView data,output;
    String process;
    boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 =findViewById(R.id.number0);
        btn1 =findViewById(R.id.number1);
        btn2 =findViewById(R.id.number2);
        btn3 =findViewById(R.id.number3);
        btn4 =findViewById(R.id.number4);
        btn5 =findViewById(R.id.number5);
        btn6 =findViewById(R.id.number6);
        btn7 =findViewById(R.id.number7);
        btn8 =findViewById(R.id.number8);
        btn9 =findViewById(R.id.number9);

        btnDelete =findViewById(R.id.delete);
        btnPlus =findViewById(R.id.addition);
        btnSub =findViewById(R.id.subtraction);
        btnMul =findViewById(R.id.multiplication);
        btnDiv =findViewById(R.id.division);
        btnDot =findViewById(R.id.dot);
        btnC =findViewById(R.id.clear);
        btnBrackets =findViewById(R.id.brackets);
        btnEqual =findViewById(R.id.equal);
        btnPercentage =findViewById(R.id.percentage);

        data=findViewById(R.id.data);
        output=findViewById(R.id.output);


        btnC.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                data.setText("");
                output.setText("");

            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'0');
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'1');
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'2');
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'3');
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'4');
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'5');
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'6');
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'7');
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'8');
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'9');
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'+');
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'-');
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'x');
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'÷');
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'.');
            }
        });
        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process+'%');
            }
        });
        btnBrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBracket){
                    process = data.getText().toString();
                    data.setText(process+')');
                    checkBracket=false;
                }else {

                    process = data.getText().toString();
                    data.setText(process+'(');
                    checkBracket=true;
                }
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    process = data.getText().toString();
                    String s = data.getText().toString();
                    s = s.substring(0, s.length() - 1);
                    data.setText(s);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"invalid input",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();

                process=process.replaceAll("x","*");
                process=process.replaceAll("÷","/");
                process=process.replaceAll("%","/100");

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);


                String finalresult ="";

                try{
                    Scriptable scriptable =rhino.initStandardObjects();
                    finalresult=rhino.evaluateString(scriptable,process,"javascript",1,null).toString();

                }catch (Exception e){
                    finalresult="0";

                }

                output.setText(finalresult);



            }
        });



    }
}
