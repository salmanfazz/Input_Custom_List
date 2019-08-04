package com.example.input_custom_list;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button commit = null;
    private EditText txtCount = null;
    private EditText txt1 = null;
    private EditText txt2 = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    private void initComponent() {
        txtCount = (EditText) findViewById(R.id.txt3);
        txt1 = (EditText) findViewById(R.id.txt1);
        txt2 = (EditText) findViewById(R.id.txt2);

        commit = (Button) findViewById(R.id.btn);
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCount.setText(String.valueOf(tambah(Integer.parseInt(txt1.getText().toString()), Integer.parseInt(txt2.getText().toString()))));
            }
        });
    }

    private int tambah(int angka1, int angka2) {
        return angka1 + angka2;
    }
}
