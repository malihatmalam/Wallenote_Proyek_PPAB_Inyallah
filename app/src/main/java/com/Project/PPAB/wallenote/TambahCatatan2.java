package com.Project.PPAB.wallenote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class TambahCatatan2 extends AppCompatActivity {

    Button addincome, addexp, save;
    Context context;
    EditText judul, keterangan, jumlah;
    String jenis = "Pemasukan";
    DBHelper dbcenter;
    final int sdk = android.os.Build.VERSION.SDK_INT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_catatan);
        dbcenter = new DBHelper(this);
        addincome = findViewById(R.id.addincome);
        addexp = findViewById(R.id.addexp);
        judul = findViewById(R.id.edtjudul);
        keterangan = findViewById(R.id.edtnote);
        jumlah = findViewById(R.id.edtjumlah);

        addincome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                jenis = "Pemasukan";
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    addincome.setBackgroundDrawable(ContextCompat.getDrawable(context, R.color.colorPrimary));
                    addincome.setTextColor(ContextCompat.getColor(context, R.color.putih));
                    addexp.setBackgroundDrawable(ContextCompat.getDrawable(context, R.color.putih));
                } else {
                    addincome.setBackground(ContextCompat.getDrawable(TambahCatatan2.this, R.color.colorPrimary));
                    addincome.setTextColor(ContextCompat.getColor(TambahCatatan2.this, R.color.putih));
                    addincome.setTextColor(ContextCompat.getColor(TambahCatatan2.this, R.color.putih));
                    addexp.setBackground(ContextCompat.getDrawable(TambahCatatan2.this, R.color.putih));
                    addexp.setTextColor(ContextCompat.getColor(TambahCatatan2.this, R.color.hitam));
                }
            }
        });
        addexp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                jenis = "Pengeluaran";
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    addexp.setBackgroundDrawable(ContextCompat.getDrawable(context, R.color.colorPrimary));
                    addexp.setTextColor(ContextCompat.getColor(context, R.color.putih));
                    addincome.setBackgroundDrawable(ContextCompat.getDrawable(context, R.color.putih));


                } else {
                    addexp.setBackground(ContextCompat.getDrawable(TambahCatatan2.this, R.color.colorPrimary));
                    addexp.setTextColor(ContextCompat.getColor(TambahCatatan2.this, R.color.putih));
                    addincome.setBackground(ContextCompat.getDrawable(TambahCatatan2.this, R.color.putih));
                    addincome.setTextColor(ContextCompat.getColor(TambahCatatan2.this, R.color.hitam));

                }
            }
        });
        save = findViewById(R.id.btnsave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                dbcenter.addTransaksi(
                        judul.getText().toString(),
                        jenis,
                        Integer.parseInt(jumlah.getText().toString()),
                        keterangan.getText().toString());
                onBackPressed();

            }
        });
    }
}
