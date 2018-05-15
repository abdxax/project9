package com.example.abdulrahman.project9;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class displaydata extends AppCompatActivity {
    EditText itemname;
    EditText price;
    EditText quenty;
    EditText suppliername;
    EditText supplierphone;
    DBManger manger;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaydata);
        itemname = findViewById(R.id.editText21);
        price = findViewById(R.id.editText31);
        quenty = findViewById(R.id.editText41);
        suppliername = findViewById(R.id.editText51);
        supplierphone = findViewById(R.id.editText61);
        manger = new DBManger(this);
        chandData();
    }

    public void chandData() {
        id = getIntent().getExtras().getInt("id");
        Cursor cursor = manger.displayItem(id);
        if (cursor.moveToFirst()) {
            do {
                itemname.setText(cursor.getString(cursor.getColumnIndex(ItemContact.CoulnItemName)));
                price.setText(cursor.getInt(cursor.getColumnIndex(ItemContact.Coulnprice)) + "");
                quenty.setText(cursor.getInt(cursor.getColumnIndex(ItemContact.CoulnIQuantity)) + "");
                suppliername.setText(cursor.getString(cursor.getColumnIndex(ItemContact.CoulnIproductSupplierName)));
                supplierphone.setText(cursor.getInt(cursor.getColumnIndex(ItemContact.CoulnIproductSupplierPhone)) + "");
            } while (cursor.moveToNext());
        }
    }

    public void buUpdate(View view) {
        String nam = itemname.getText().toString();
        int prices = Integer.parseInt(price.getText().toString());
        int qn = Integer.parseInt(quenty.getText().toString());
        String supname = suppliername.getText().toString();
        int suphon = Integer.parseInt(supplierphone.getText().toString());
        if (validation(nam, prices, qn, supname, suphon)) {
            ContentValues values = new ContentValues();
            values.put(ItemContact.CoulnItemName, nam);
            values.put(ItemContact.Coulnprice, prices);
            values.put(ItemContact.CoulnIQuantity, qn);
            values.put(ItemContact.CoulnIproductSupplierName, supname);
            values.put(ItemContact.CoulnIproductSupplierPhone, suphon);
            long i = manger.update(values, id);
            if (i >= 1) {
                startActivity(new Intent(displaydata.this, MainActivity.class));
                finish();
            }


        }
    }

    public boolean validation(String name, int prices, int quen, String suppliernam, int phonesup) {
        if (name.equals("") || name.equals(null)) {
            itemname.setError(String.valueOf(R.string.check));
            return false;
        }
        if (prices <= 0) {
            price.setError(String.valueOf(R.string.check));
            return false;
        }
        if (quen <= 0) {
            quenty.setError(String.valueOf(R.string.check));
            return false;
        }
        if (suppliernam.equals("") || suppliernam.equals(null)) {
            suppliername.setError(String.valueOf(R.string.check));
            return false;
        }
        if (phonesup <= 0) {
            supplierphone.setError(String.valueOf(R.string.check));
            return false;
        }

        return true;
    }

    public void butDelete(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(displaydata.this);
        dialog.setTitle(R.string.deteleItem);
        dialog.setMessage(getString(R.string.msgitem) + itemname.getText().toString() + " ?");
        dialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                long i = manger.delte(id);
                if (i >= 1) {
                    startActivity(new Intent(displaydata.this, MainActivity.class));
                    finish();
                }
            }
        });
        dialog.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.backmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                startActivity(new Intent(displaydata.this, MainActivity.class));
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
