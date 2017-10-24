package com.tunateam.poons.helloworld;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvHello;
    EditText editTextHello;
    Button btnCopy;

    TextView tvResult;
    EditText editText1;
    EditText editText2;
    Button btnCalculate;
    CustomViewGroup viewGroup1;
    CustomViewGroup viewGroup2;
    RadioButton rbPlus;
    RadioButton rbMinus;
    RadioButton rbMultiply;
    RadioButton rbDivide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        initInstances();
        DisplayToast(width, height);

    }

    private void initInstances() {
        tvHello = (TextView) findViewById(R.id.tvHello);
        editTextHello = (EditText) findViewById((R.id.tvEditTextHello));
        btnCopy = (Button) findViewById(R.id.btnCopy);

        tvResult = (TextView) findViewById(R.id.tvResult);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);


        btnCalculate.setOnClickListener(this);
    }

    private void DisplayToast(int width, int height){
        Toast.makeText(MainActivity.this,
                "Width: " + width + " Height: " + height,
                Toast.LENGTH_LONG)
                .show();


        viewGroup1 = (CustomViewGroup) findViewById(R.id.ViewGroup1);
        viewGroup2 = (CustomViewGroup) findViewById(R.id.ViewGroup1);

        viewGroup1.setButtonText("Hello");
        viewGroup2.setButtonText("World");

    }

    @Override
    public void onClick(View v) {
        if (v == btnCalculate) {
            int e1 = 0;
            int e2 = 0;
            int sum = 0;
            RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
            try {
                e1 = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException e) {
            }
            try {
                e2 = Integer.parseInt(editText2.getText().toString());
            } catch (NumberFormatException e) {
            }


            switch (rg.getCheckedRadioButtonId()) {
                case R.id.rbPlus:
                    sum = e1 + e2;
                    break;
                case R.id.rbMinus:
                    sum = e1 - e2;
                    break;
                case R.id.rbMultiply:
                    sum = e1 * e2;
                    break;
                case R.id.rbDivide:
                    if (e2 != 0) {
                        sum = e1 / e2;
                    }
                    break;
            }
            tvResult.setText("" + sum);

            Log.d("Calculation", "Result = " + sum);
            Toast.makeText(MainActivity.this,
                    "Result = " + sum,
                    Toast.LENGTH_SHORT)
                    .show();


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings){
            Toast.makeText(MainActivity.this,
                    "setting",
                    Toast.LENGTH_SHORT)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
