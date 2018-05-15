package com.example.abdulrahman.project9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {
    ArrayList<ItemModel> itemModels;
    Context context;

    public ItemAdapter(Context context, ArrayList<ItemModel> itemModels) {
        this.context = context;
        this.itemModels = itemModels;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        TextView name = view.findViewById(R.id.itemsm);
        TextView price = view.findViewById(R.id.pric);
        TextView count = view.findViewById(R.id.qun);
        name.setText(itemModels.get(position).getItemName());
        price.setText(itemModels.get(position).getPrice() + "");
        count.setText(itemModels.get(position).getQuantity() + "");

        return view;
    }
}
