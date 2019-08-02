package com.example.cnttcoban;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cnttcoban.DeThi.De1;
import com.example.cnttcoban.DeThi.De2;
import com.example.cnttcoban.DeThi.De3;
import com.example.cnttcoban.DeThi.De4;
import com.example.cnttcoban.DeThi.De5;

public class DeThiActivity extends AppCompatActivity {

    Spinner spinner;
    String[] danhsach = {"Đề 1", "Đề 2","Đề 3","Đề 4","Đề 5"};
    ArrayAdapter<String> arrayAdapter;
    De1 de1;
    De2 de2;
    De3 de3;
    De4 de4;
    De5 de5;
    Button a, b, c, d;
    TextView tvQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_de_thi);
        setInit();
        setSpinnerChecked();
        de1 = new De1(this, a, b, c, d, tvQuestion);
        de1.setQuestionAmount();
        de2 = new De2(this, a, b ,c ,d, tvQuestion);
        de2.setQuestionAmount();
        de3 = new De3(this, a, b ,c ,d, tvQuestion);
        de3.setQuestionAmount();
        de4 = new De4(this, a, b ,c ,d, tvQuestion);
        de4.setQuestionAmount();
        de5 = new De5(this, a, b ,c ,d, tvQuestion);
        de5.setQuestionAmount();

    }

    private void setSpinnerChecked() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        de1.playGame();
                        break;
                    case 1:
                        de2.playGame();
                        break;
                    case 2:
                        de3.playGame();
                        break;
                    case 3:
                        de4.playGame();
                        break;
                    case 4:
                        de5.playGame();
                        break;
                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    void setInit() {
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        tvQuestion = findViewById(R.id.tvQuesContainer);
        spinner = findViewById(R.id.spinner);
        arrayAdapter = new ArrayAdapter<>(this, R.layout.custom_spinner, danhsach);
        spinner.setAdapter(arrayAdapter);
    }
}

