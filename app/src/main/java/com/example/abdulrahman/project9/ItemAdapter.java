package com.example.abdulrahman.project9;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {
    ArrayList<ItemModel> itemModels;
    Context context;
    DBManger manger;
    int pos;

    public ItemAdapter(Context context, ArrayList<ItemModel> itemModels) {
        this.context = context;
        this.itemModels = itemModels;
        manger = new DBManger(context);
    }


    @Override
    public int getCount() {
        return itemModels.size();
    }

    @Override
    public Object getItem(int position) {
        return itemModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        TextView name = view.findViewById(R.id.itemsm);
        TextView price = view.findViewById(R.id.pric);
        final TextView count = view.findViewById(R.id.qun);
        Button button = view.findViewById(R.id.button2);
        name.setText(itemModels.get(position).getItemName());
        price.setText(itemModels.get(position).getPrice() + "");
        count.setText(itemModels.get(position).getQuantity() + "");
        //pos=position;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                int qnq = Integer.parseInt(count.getText().toString());
                if (qnq <= 1) {

                } else {
                    --qnq;
                    values.put(ItemContact.CoulnIQuantity, qnq);
                    long i = manger.updateQunda(values, itemModels.get(position).getID());
                    if (i >= 1) {
                        count.setText(qnq + "");
                    }
                }
            }
        });
        return view;
    }
}
