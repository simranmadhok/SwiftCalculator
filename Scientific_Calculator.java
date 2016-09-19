package com.scicalc.compaq.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Scientific_Calculator extends AppCompatActivity
{

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bA,bS,bD,bM,bC,bDot,bE,bSqr,bPcn;
    Button bSRoot,bFact,bPow,bSin,bCos,bTan,bCbrt,bExp,bNLog,bOpB,bClB,bRt,bAbs,bLog10,bPi,bExp1;
    public String str ="",dispStr="";
    String op = "q";
    double num,numtemp,t;
    EditText showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific__calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        b1 = (Button) findViewById(R.id.btnOne);
        b2 = (Button) findViewById(R.id.btnTwo);
        b3 = (Button) findViewById(R.id.btnThree);
        b4 = (Button) findViewById(R.id.btnFour);
        b5 = (Button) findViewById(R.id.btnFive);
        b6 = (Button) findViewById(R.id.btnSix);
        b7 = (Button) findViewById(R.id.btnSeven);
        b8 = (Button) findViewById(R.id.btnEight);
        b9 = (Button) findViewById(R.id.btnNine);
        b0 = (Button) findViewById(R.id.btnZero);
        bA = (Button) findViewById(R.id.btnAdd);
        bS = (Button) findViewById(R.id.btnSubtract);
        bM = (Button) findViewById(R.id.btnMultiply);
        bD = (Button) findViewById(R.id.btnDivide);
        bC = (Button) findViewById(R.id.btnClear);
        bE = (Button) findViewById(R.id.btnEqual);
        bDot= (Button) findViewById(R.id.btnDot);
        bSqr=(Button) findViewById(R.id.btnSqr);
        bPcn=(Button) findViewById(R.id.btnPercentage);

        bSRoot = (Button) findViewById(R.id.btnSqrt);
        bFact = (Button) findViewById(R.id.btnFact);
        bPow = (Button) findViewById(R.id.btnPower);
        bSin = (Button) findViewById(R.id.btnSin);
        bCos = (Button) findViewById(R.id.btnCos);
        bTan = (Button) findViewById(R.id.btnTan);
        bCbrt = (Button) findViewById(R.id.btnCbrt);
        bExp = (Button) findViewById(R.id.btnExp);
        bNLog = (Button) findViewById(R.id.btnNLog);
        bOpB = (Button) findViewById(R.id.btnOpB);
        bClB = (Button) findViewById(R.id.btnClB);
        bRt = (Button) findViewById(R.id.btnRoot);
        bAbs=(Button)findViewById(R.id.btnAbs);
        bLog10=(Button)findViewById(R.id.btnLog10);
        bPi=(Button)findViewById(R.id.btnPi);
        bExp1=(Button)findViewById(R.id.btnE);

        showResult = (EditText) findViewById(R.id.txtScreen);
        int textLength = showResult.getText().length();
        showResult.setSelection(textLength);
    }

    public void btn0Clicked(View v)
    {
        insert(0);

    }

    public void btn1Clicked(View v)
    {
        insert(1);

    }

    public void btn2Clicked(View v)
    {
        insert(2);

    }

    public void btn3Clicked(View v)
    {
        insert(3);

    }

    public void btn4Clicked(View v)
    {
        insert(4);

    }

    public void btn5Clicked(View v)
    {
        insert(5);

    }

    public void btn6Clicked(View v)
    {
        insert(6);
    }

    public void btn7Clicked(View v)
    {
        insert(7);

    }

    public void btn8Clicked(View v)
    {
        insert(8);
    }

    public void btn9Clicked(View v)
    {
        insert(9);
    }

    public void btnplusClicked(View v)
    {
        insert("+");
        perform();
        op = "+";
    }

    public void btnminusClicked(View v)
    {
        insert("-");
        perform();
        op = "-";
    }

    public void btndivideClicked(View v)
    {
        insert("/");
        perform();
        op = "/";
    }

    public void btnmultiClicked(View v)
    {
        insert("*");
        perform();
        op = "*";
    }

    public void btnPercentageClicked(View v)
    {
        insert("%");
        perform();
        op = "%";
    }

    public void btnequalClicked(View v)
    {
        calculate();
    }

    public void btnclearClicked(View v)
    {
        reset();
    }

    public void btnSqrClicked(View v)
    {
        insert("^2");
        perform();
        op= "Sqr";
    }

    public void btnSqrtClicked(View v)
    {
        insert("Sqrt");
        perform();
        op= "Sqrt";
    }

    public void btnDotClicked(View v)
    {
        insert(".");
    }

    public void btnOpBClicked(View v)
    {
        insert("(");
        perform();
    }

    public void btnClBClicked(View v)
    {
        insert(")");
        perform();
    }

    public void btnRTClicked(View v)
    {
        insert(" Root ");
        perform();
        op="Root";
    }

    public void btnSinClicked(View v)
    {
        insert("(Sin)");
        perform();
        op="Sin";
    }

    public void btnCosClicked(View v)
    {
        insert("(Cos)");
        perform();
        op="Cos";
    }

    public void btnTanClicked(View v)
    {
        insert("(Tan)");
        perform();
        op="Tan";
    }

    public void btnCbrtClicked(View v)
    {
        insert(" Cbrt");
        perform();
        op="Cbrt";
    }

    public void btnExpClicked(View v)
    {
        insert(" Base e");
        perform();
        op="Exp";
    }

    public void btnEClicked(View v)
    {
        insert(" * e");
        perform();
        op="E";
    }

    public void btnPowerClicked(View v)
    {
        insert("^");
        perform();
        op= "Pow";
    }

    public void btnNLogClicked(View v)
    {
        insert("(ln)");
        perform();
        op= "NLog";
    }

    public void btnlog10Clicked(View v)
    {
        insert("(log10)");
        perform();
        op= "Log10";
    }

    public void btnAbsClicked(View v)
    {
        insert("(abs)");
        perform();
        op= "Abs";
    }

    public void btnPiClicked(View v)
    {
        insert("pi");
        perform();
        op= "Pi";
    }

    public void btnFactClicked(View v)
    {
        insert("!");
        perform();
        op= "Fact";
    }

    private void reset()
    {
        str = "";
        op = "q";
        num = 0;
        numtemp = 0;
        dispStr="";
        showResult.setText("");
    }

    private void insert(int j)
    {
        str = str + Integer.toString(j);

        num = Float.valueOf(str);

        dispStr+= Integer.toString(j);

        showResult.setText(dispStr);
    }

    private void insert(String j)
    {
        str = str + (j);

        dispStr+=(j);

        showResult.setText(dispStr);
    }

    private void perform()
    {
        str = "";
        numtemp = num;
    }

    private void calculate()
    {
        if (op == "+")
            num = (float)(numtemp + num);
        else if (op == "-")
            num = (float)(numtemp - num);
        else if (op == "/")
            num = (float)(numtemp / num);
        else if (op == "*")
            num = (float)(numtemp * num);
        else if (op == "Sqr")
            num=(float)(numtemp*numtemp);
        else if (op == "%")
            num = (float)(numtemp/100);
        else if (op == "Sqrt")
            num = (float)(Math.sqrt(numtemp));
        else if(op == "Sin")
        {
            t= Math.toRadians(numtemp);
            num= Math.sin(t);
        }
        else if(op == "Cos")
        {
            t =  Math.toRadians(numtemp);
            num = Math.cos(t);
        }
        else if(op == "Tan")
        {
            t = Math.toRadians(numtemp);
            num = Math.tan(t);
        }
        else if(op == "NLog")
        {
            t = (numtemp);
            num = Math.log(t);
        }
        else if(op == "Exp")
        {
            t = (numtemp);
            num =Math.exp(t);
        }
        else if(op == "E")
        {
            t = (numtemp);
            num =(Math.E)*(t);
        }
        else if(op == "Cbrt")
        {
            t = (numtemp);
            num = Math.cbrt(t);
        }
        else if(op == "Log10")
        {
            t = (numtemp);
            num = Math.log10(t);
        }
        else if (op == "Pow")

            num =(float)(Math.pow(numtemp, num));

        else if (op == "Fact")
        {
            int fact=1;
            for(int i=1;i<=numtemp;i++)
            {
                fact*=i;
            }
            num = (float)fact;
        }
        else if (op == "Root")
        {
            if(numtemp>0)
            {
                num = (float)Math.pow((num),(1/numtemp) );
            }
            else
            {
                showResult.setText("Error");
            }
        }
        else if(op == "Pi")
        {
            num = (float)(numtemp*3.14);
        }



        showResult.setText("" + num);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.s_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.s_item1:

                Intent switch4 = new Intent(Scientific_Calculator.this, MainActivity.class);
                startActivity(switch4);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
