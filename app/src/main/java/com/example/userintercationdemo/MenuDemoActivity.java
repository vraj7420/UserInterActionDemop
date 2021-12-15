package com.example.userintercationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MenuDemoActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etAge;
    private Button btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_demo);
        etName=(EditText)findViewById(R.id.etName);
        etAge=(EditText)findViewById(R.id.etAge);
        btnNext=(Button)findViewById(R.id.btnNext);
        registerForContextMenu(etName);
        registerForContextMenu(etAge);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MenuDemoActivity.this, FragmentDemoActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case (R.id.menuItemMic):
                Toast.makeText(MenuDemoActivity.this, "Mic Selected", Toast.LENGTH_SHORT).show();
                break;
            case (R.id.menStatus):
                Toast.makeText(MenuDemoActivity.this, "Status Selected", Toast.LENGTH_SHORT).show();
                break;
            case (R.id.menItemSetting):
                Toast.makeText(MenuDemoActivity.this,"Setting Selected",Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()){

            case (R.id.etName):
                getMenuInflater().inflate(R.menu.et_name_menu,menu);
                break;
            case (R.id.etAge):
                getMenuInflater().inflate(R.menu.et_age_menu,menu);
                break;
        }


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case (R.id.menuItemOne):
                Toast.makeText(MenuDemoActivity.this,"Item One Selected",Toast.LENGTH_SHORT).show();
            case (R.id.menuItemTwo):
                Toast.makeText(MenuDemoActivity.this,"Item Two Selected",Toast.LENGTH_SHORT).show();
            case (R.id.ageItemOne):
                Toast.makeText(MenuDemoActivity.this,"Age Item One Selected",Toast.LENGTH_SHORT).show();
            case (R.id.ageItemTwo):
                Toast.makeText(MenuDemoActivity.this,"Age Item Two Selected",Toast.LENGTH_SHORT).show();


        }
        return true;
    }
}