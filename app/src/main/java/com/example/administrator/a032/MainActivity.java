package com.example.administrator.a032;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText    phone;
    String      action;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        phone=(EditText) findViewById(R.id.editText);
        phone.setText("0963657662");

        action=Intent.ACTION_CALL;
    }


    public  void    buttonsClick(View   v)
    {
        Button      b=(Button) v;
        String      s=b.getText().toString();
        int         len;
        Editable    etext;

        switch (v.getId())
        {
            case    R.id.button0:
            case    R.id.button1:
            case    R.id.button2:
            case    R.id.button3:
            case    R.id.button4:
            case    R.id.button5:
            case    R.id.button6:
            case    R.id.button7:
            case    R.id.button8:
            case    R.id.button9:
                phone.setText(phone.getText() + s);

                len=phone.getText().length();
                etext=phone.getText();
                Selection.setSelection(etext, len);
                break;

            /*
            Intent, 意圖: 打電話/發簡訊/跳下一個頁面Activity
             */
            case    R.id.button11:
                s=phone.getText().toString();

                Log.d("Call", "Step1");
                if (s == null || s.equals(""))
                {
                    Toast.makeText(this, R.string.phoneNumber + " ??", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Uri uri=Uri.parse("tel:"+ s);

                    Intent  ii=new Intent(action, uri);
                    Log.d("Call", "Step2");
                    startActivity(ii);
                    Log.d("Call", "Step3");
                }
                break;

            case    R.id.button10:
                len=phone.getText().length();

                if (len >= 1) {
                    phone.setText(phone.getText().toString().substring(0, len-1));

                    etext = phone.getText();
                    Selection.setSelection(etext, len-1);
                }
                break;
        }
    }
}
