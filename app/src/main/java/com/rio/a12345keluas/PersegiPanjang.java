package com.rio.a12345keluas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersegiPanjang extends AppCompatActivity {
    private EditText inputPanjang, inputLebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi_panjang);

        inputPanjang = findViewById(R.id.input_nilaiPanjang);
        inputLebar = findViewById(R.id.input_nilaiLebar);
        Button hitungButton = findViewById(R.id.hitung_persegiPanjang);
        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungDanKirimHasil();
            }
        });
    }
    private void hitungDanKirimHasil() {
        String panjangStr = inputPanjang.getText().toString();
        String lebarStr = inputLebar.getText().toString();

        if (!panjangStr.isEmpty() && !lebarStr.isEmpty()) {
            double panjang = Double.parseDouble(panjangStr);
            double lebar = Double.parseDouble(lebarStr);

            double luas = panjang * lebar;
            double keliling = 2 * (panjang + lebar);

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