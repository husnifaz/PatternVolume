package com.androidlab.husnifa.patternvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText edt_p, edt_l, edt_t;
    private TextView hsl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_p = (EditText) findViewById(R.id.edt_panjang);
        edt_l = (EditText) findViewById(R.id.edt_lebar);
        edt_t = (EditText) findViewById(R.id.edt_tinggi);

        Button calculate = (Button) findViewById(R.id.btn_calc);
        hsl = (TextView) findViewById(R.id.tv_resutl);

        final MainPresenter presenter = new MainPresenter(this);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang = edt_p.getText().toString().trim();
                String lebar = edt_l.getText().toString().trim();
                String tinggi = edt_t.getText().toString().trim();

                boolean isEmptyFields = false;
                if (TextUtils.isEmpty(panjang)) {
                    isEmptyFields = true;
                    edt_p.setError("Nilai panjang tidak boleh kosong");
                }
                if (TextUtils.isEmpty(lebar)) {
                    isEmptyFields = true;
                    edt_l.setError("Nilai lebar tidak boleh kosong");
                }
                if (TextUtils.isEmpty(tinggi)) {
                    isEmptyFields = true;
                    edt_t.setError("Nilai tinggi tidak boleh kosong");
                }

                if (!isEmptyFields){
                    double p = Double.parseDouble(panjang);
                    double l = Double.parseDouble(lebar);
                    double t = Double.parseDouble(tinggi);

                    presenter.hitungVolume(p, l, t);
                }
            }
        });
    }

    @Override
    public void tampilVolume(MainModel model) {
        hsl.setText(String.valueOf(model.getVolume()));
    }
}
