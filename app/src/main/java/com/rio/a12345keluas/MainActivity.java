package com.rio.a12345keluas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView hasilTextView;
    // Konstanta untuk requestCode
    private static final int KODE_PERSEGI_PANJANG = 1;
    private static final int KODE_SEGITIGA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasilTextView = findViewById(R.id.hasil);
    }
    private void tampilkanHasil(double luas, double keliling) {
        hasilTextView.setVisibility(View.VISIBLE);
        hasilTextView.setText("Luas: " + luas + "\nKeliling: " + keliling);
    }

    public void launchPersegi(View view) {
        Intent intent = new Intent(MainActivity.this, Persegi.class);
        startActivityForResult(intent, 1);
    }

    public void launchPersegiPanjang(View view) {
        Intent intent = new Intent(MainActivity.this, PersegiPanjang.class);
        startActivityForResult(intent, KODE_PERSEGI_PANJANG);
    }

    public void launchSegitiga(View view) {
        Intent intent = new Intent(MainActivity.this, Segitiga.class);
        startActivityForResult(intent, KODE_SEGITIGA);
    }

    public void launchTentang(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                double luas = data.getDoubleExtra("luas", 0);
                double keliling = data.getDoubleExtra("keliling", 0);

                tampilkanHasil(luas, keliling);
            }
        } else if (requestCode == KODE_PERSEGI_PANJANG) {
            if (resultCode == RESULT_OK) {
                double luas = data.getDoubleExtra("luas", 0);
                double keliling = data.getDoubleExtra("keliling", 0);

                tampilkanHasil(luas, keliling);
            }
        } else if (requestCode == KODE_SEGITIGA) {
            if (resultCode == RESULT_OK) {
                double luas = data.getDoubleExtra("luas", 0);
                double keliling = data.getDoubleExtra("keliling", 0);

                tampilkanHasil(luas, keliling);
            }
        }
    }

}