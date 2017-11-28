package com.example.myapp1127;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        Button btns = (Button) view;
        String getBtn = btns.getText().toString();
        TextView formulas = (TextView) findViewById(R.id.formula_area);
        String strContent = formulas.getText().toString();
        String strNewContent = strContent + getBtn;
        formulas.setText(strNewContent);
    }

    public void onClickSub(View view){
        switch (view.getId()) {
            case R.id.btn_c: {
                TextView formulaC = (TextView) findViewById(R.id.formula_area);
                formulaC.setText("");
                TextView resultC = (TextView) findViewById(R.id.result_area);
                resultC.setText("");
            }
            break;
            case R.id.btn_del: {
                TextView formulaD = (TextView) findViewById(R.id.formula_area);
                String strContentD = formulaD.getText().toString();
                if (strContentD.length() > 0) {
                    strContentD = strContentD.substring(0, strContentD.length() - 1);
                    formulaD.setText(strContentD);
                }else{
                    formulaD.setText("");
                }
            }
            break;
            case R.id.btn_equ: {
                TextView formulaLast = (TextView) findViewById(R.id.formula_area);
                String strContentALL = formulaLast.getText().toString();
                try {
                    Symbols s = new Symbols();
                    double res = s.eval(strContentALL);
                    TextView resultLast = (TextView) findViewById(R.id.result_area);
                    resultLast.setText(String.valueOf(res));
                    formulaLast.setText("");
                } catch (SyntaxException e) {
                    //Toast.makeText(MainActivity.this, "错误！", Toast.LENGTH_SHORT).show();
                }
            }
            break;

        }
    }
}
