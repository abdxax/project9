package com.example.abdulrahman.project9;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBManger manger;
    ArrayList<ItemModel> models;
    ItemAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        models = new ArrayList<>();
        adapter = new ItemAdapter(this, models);
        listView = findViewById(R.id.list_items);
        manger = new DBManger(this);
        loadData();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent displaydata = new Intent(MainActivity.this, displaydata.class);
                displaydata.putExtra("id", models.get(position).getID());
                startActivity(displaydata);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.insitem:
                startActivity(new Intent(this, insetitem.class));
                finish();
                break;
            case R.id.delitem:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle(R.string.titledelete);
                dialog.setMessage(R.string.msgdidte);
                dialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        manger.deleetAll();
                    }
                });
                dialog.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void loadData() {
        Cursor cursor = manger.allData();
        if (cursor.moveToFirst()) {
            do {
                models.add(new ItemModel(cursor.getInt(cursor.getColumnIndex(ItemContact.CoulnID)), cursor.getString(cursor.getColumnIndex(ItemContact.CoulnItemName)), cursor.getInt(cursor.getColumnIndex(ItemContact.Coulnprice))
                        , cursor.getInt(cursor.getColumnIndex(ItemContact.CoulnIQuantity)), cursor.getString(cursor.getColumnIndex(ItemContact.CoulnIproductSupplierName)),
                        cursor.getInt(cursor.getColumnIndex(ItemContact.CoulnIproductSupplierPhone))));
            } while (cursor.moveToNext());
        }
    }
}
