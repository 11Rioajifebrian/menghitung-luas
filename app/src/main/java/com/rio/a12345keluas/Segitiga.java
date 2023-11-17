package com.rio.a12345keluas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Segitiga extends AppCompatActivity {
    private EditText inputSisiA, inputSisiB, inputSisiC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);

        inputSisiA = findViewById(R.id.input_nilaiA);
        inputSisiB = findViewById(R.id.input_nilaiB);
        inputSisiC = findViewById(R.id.input_nilaiC);

        Button hitungButton = findViewById(R.id.hitung_segitiga);
        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungDanKirimHasil();
            }
        });
    }
    private void hitungDanKirimHasil() {
        String sisiAStr = inputSisiA.getText().toString();
        String sisiBStr = inputSisiB.getText().toString();
        String sisiCStr = inputSisiC.getText().toString();

        if (!sisiAStr.isEmpty() && !sisiBStr.isEmpty() && !sisiCStr.isEmpty()) {
            double sisiA = Double.parseDouble(sisiAStr);
            double sisiB = Double.parseDouble(sisiBStr);
            double sisiC = Double.parseDouble(sisiCStr);

            // Perhitungan luas dan keliling segitiga
            double setengahKeliling = (sisiA + sisiB + sisiC) / 2;
            double luas = Math.sqrt(setengahKeliling * (setengahKeliling - sisiA) * (setengahKeliling - sisiB) * (setengahKeliling - sisiC));
            double keliling = sisiA + sisiB + sisiC;

            // Membuat Intent untuk mengirim hasil ke MainActivity
            Intent intent = new Intent();
            intent.putExtra("luas", luas);
            intent.putExtra("keliling", keliling);

            // Mengirim hasil ke MainActivity dengan resultCode RESULT_OK
            setResult(RESULT_OK, intent);

            // Menutup Activity saat tombol "HITUNG" ditekan
            finish();
        }
    }
}