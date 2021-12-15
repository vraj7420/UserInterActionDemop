package com.example.userintercationdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private CheckBox chbEnglish;
    private CheckBox chbHindi;
    private ToggleButton toggleButton;
    private Button btnAlertDialog;
    private Button btnProgressDialog;
    private Button btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton1);
        chbEnglish = (CheckBox) findViewById(R.id.chbEnglish);
        chbHindi = (CheckBox) findViewById(R.id.chbHindi);
        btnAlertDialog = (Button) findViewById(R.id.btnAlertDialog);
        btnProgressDialog = (Button) findViewById(R.id.btnProgressDialog);
        btnNext=(Button)findViewById(R.id.btnNext);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    Toast.makeText(MainActivity.this, "You Turn Off Toggle Button", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Turn On Toggle Button", Toast.LENGTH_SHORT).show();
                }
            }
        });
        chbEnglish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "English CheckBox Checked", Toast.LENGTH_SHORT).show();
            }
        });
        chbHindi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "Hindi CheckBox Checked", Toast.LENGTH_SHORT).show();
            }
        });
      btnAlertDialog.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
              alert.setTitle("Exit");
              alert.setMessage("Are You Sure?");
              alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      finish();
                  }
              });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alert.show();
          }
      });
      btnProgressDialog.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              ProgressDialog pd=new ProgressDialog(MainActivity.this);
              pd.setTitle("Downloading....");
              pd.setMessage("Please Wait");
              pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
              pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                  }
              });
              pd.show();

          }
      });
      btnNext.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent nextActivityIntent=new Intent(MainActivity.this,MenuDemoActivity.class);
              startActivity(nextActivityIntent);
          }
      });


    }

}