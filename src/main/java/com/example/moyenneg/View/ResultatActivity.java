package com.example.moyenneg.View;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.moyenneg.R;
public class ResultatActivity extends AppCompatActivity {

    private TextView moduleView1;
    private TextView moduleView2;
    private TextView moduleView3;
    private TextView moduleView4;
    private TextView moduleView5;
    private TextView moyenneView;
    private TextView creditView;
    private TextView statusView;

    private double moyenne1;
    private double moyenne2;
    private double moyenne3;
    private double moyenne4;
    private double moyenne5;
    private double moyenneGen;
    private int sommecredit = 0;
    java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        moyenne1 = Double.parseDouble(bundle.getString("Moyenne1"));
        moyenne2 = Double.parseDouble(bundle.getString("Moyenne2"));
        moyenne3 = Double.parseDouble(bundle.getString("Moyenne3"));
        moyenne4 = Double.parseDouble(bundle.getString("Moyenne4"));
        moyenne5 = Double.parseDouble(bundle.getString("Moyenne5"));

        moduleView1 = findViewById(R.id.module1);
        moduleView2 = findViewById(R.id.module2);
        moduleView3 = findViewById(R.id.module3);
        moduleView4 = findViewById(R.id.module4);
        moduleView5 = findViewById(R.id.module5);
        moyenneView = findViewById(R.id.moyG);
        creditView = findViewById(R.id.credit);
        statusView = findViewById(R.id.status);

        moduleView1.setText(df.format(moyenne1));
        moduleView2.setText(df.format(moyenne2));
        moduleView3.setText(df.format(moyenne3));
        moduleView4.setText(df.format(moyenne4));
        moduleView5.setText(df.format(moyenne5));

        if (moyenne1 > 10) { sommecredit += 3; }
        if (moyenne2 > 10) { sommecredit += 2; }
        if (moyenne3 > 10) { sommecredit += 3; }
        if (moyenne4 > 10) { sommecredit += 3; }
        if (moyenne5 > 10) { sommecredit += 2; }

        moyenneGen = ((moyenne1 * 2) + (moyenne2 * 2) + (moyenne3 * 3) + (moyenne4 * 3) + (moyenne5 * 1)) / 11;

        moyenneView.setText(String.valueOf(df.format(moyenneGen)));
        creditView.setText(String.valueOf(sommecredit));

        if (moyenneGen > 10) {
            statusView.setText("Admis");
            creditView.setText(String.valueOf(13));
        } else {
            statusView.setText("Ajourné");
        }
        Intent intent = new Intent(ResultatActivity.this, MainActivity.class);
        finish();

    }
}

