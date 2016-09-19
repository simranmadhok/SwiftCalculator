package com.scicalc.compaq.calculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bA, bS, bD, bM, bC, bDot, bE, bSqr, bPcn;
    public String str = "", dispStr = "";
    String op = "q";
    float num, numtemp;
    EditText showResult;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        bDot = (Button) findViewById(R.id.btnDot);
        bSqr = (Button) findViewById(R.id.btnSqr);
        bPcn = (Button) findViewById(R.id.btnPercentage);

        showResult = (EditText) findViewById(R.id.txtScreen);

        showResult.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if(b)
                {
                    showResult.setSelection(showResult.getText().length());
                }
            }
        });

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void btn0Clicked(View v) {
        insert(0);

    }

    public void btn1Clicked(View v) {
        insert(1);

    }

    public void btn2Clicked(View v) {
        insert(2);

    }

    public void btn3Clicked(View v) {
        insert(3);

    }

    public void btn4Clicked(View v) {
        insert(4);

    }

    public void btn5Clicked(View v) {
        insert(5);

    }

    public void btn6Clicked(View v) {
        insert(6);
    }

    public void btn7Clicked(View v) {
        insert(7);

    }

    public void btn8Clicked(View v) {
        insert(8);
    }

    public void btn9Clicked(View v) {
        insert(9);
    }

    public void btnplusClicked(View v)
    {
        insert("+");
        perform();
        op = "+";
        //dispStr += "+";
    }

    public void btnminusClicked(View v) {
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

    public void btnclearClicked(View v) {
        reset();
    }

    public void btnSqrClicked(View v)
    {
        insert("^2");
        perform();
        op = "Sqr";
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

    private void reset()
    {
        str = "";
        op = "q";
        num = 0;
        numtemp = 0;
        dispStr = "";
        showResult.setText("");
    }

    private void insert(int j)
    {
        str = str + Integer.toString(j);

        num = Float.valueOf(str);

        dispStr += Integer.toString(j);

        showResult.setText(dispStr);
    }

    private void insert(String j)
    {
        str = str + (j);

        dispStr += (j);

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
            num = (numtemp + num);
        else if (op == "-")
            num = (numtemp - num);
        else if (op == "/")
            num = (numtemp / num);
        else if (op == "*")
            num = (numtemp * num);
        else if (op == "Sqr")
            num = (numtemp * numtemp);
        else if (op == "Sqrt")
            num = (float)(Math.sqrt(numtemp));
        else if (op == "%")
            num = (numtemp / 100);

        showResult.setText("" + num);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {

            case R.id.item1:

                Intent switch2 = new Intent(MainActivity.this, Scientific_Calculator.class);
                startActivity(switch2);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.scicalc.compaq.calculator/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.scicalc.compaq.calculator/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
