package com.ashokbaniya.connection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SellingCropsGridAdapter extends BaseAdapter {
    private Context context;
    private List<SellingCropsItems> items;

    public SellingCropsGridAdapter(Context context, List<SellingCropsItems> items) {
        super();
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.crops_item, null);
        } else {
            gridView = convertView;
        }

        // Bind data to the grid item layout
        ImageView imageView = gridView.findViewById(R.id.imageView);
        TextView textView = gridView.findViewById(R.id.textView);
        TextView pr = gridView.findViewById(R.id.textView9);
        TextView qt = gridView.findViewById(R.id.txtV);
        SellingCropsItems item = items.get(position);
        Picasso.get().load(item.getImageResource()).into(imageView);
        textView.setText(item.getItemName());
        pr.setText("price:  "+item.getItemPrice());
        qt.setText("quantity: "+item.getItemQuantity());
        return gridView;
    }
}