package com.brains404.customlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<Product> {
    Context context ;
    int resource ;
    List<Product> productList ;
    public CustomListViewAdapter(@NonNull Context context, int resource, @NonNull List<Product> productList) {
        super(context, resource, productList);
        this.context=context ;
        this.resource=resource;
        this.productList=productList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

          final Product product = productList.get(position);
        final LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_products,null);
        TextView ProductName=view.findViewById(R.id.textView3);
        TextView ProductDescription=view.findViewById(R.id.textView2) ;
        ImageView ProductImage=view.findViewById(R.id.imageView2);
          ProductName.setText(product.getName());
          ProductDescription.setText(product.getDescription());
          ProductImage.setImageDrawable(context.getResources().getDrawable(product.getProductImage()));
          return view ;

    }

}
