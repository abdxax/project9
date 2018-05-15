package com.example.abdulrahman.project9;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class insetitem extends AppCompatActivity {
    EditText itemname;
    EditText price;
    EditText quenty;
    EditText suppliername;
    EditText supplierphone;
    DBManger manger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insetitem);
        itemname = findViewById(R.id.editText2);
        price = findViewById(R.id.editText3);
        quenty = findViewById(R.id.editText4);
        suppliername = findViewById(R.id.editText5);
        supplierphone = findViewById(R.id.editText6);
        manger = new DBManger(this);
    }

    public void butSave(View view) {
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
            long i = manger.insert(values);
            if (i > 0) {
                startActivity(new Intent(this, Main2Activity.class));
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Noting " + i, Toast.LENGTH_LONG).show();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.backmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                startActivity(new Intent(insetitem.this, Main2Activity.class));
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
