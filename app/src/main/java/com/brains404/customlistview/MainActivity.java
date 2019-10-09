package com.brains404.customlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(R.drawable.word,"Word","Editeur de texte"));
        productList.add(new Product(R.drawable.excel,"Excel","Tableur"));
        productList.add(new Product(R.drawable.powerpoint,"PowerPoint","Logiciel de présentation"));
        productList.add(new Product(R.drawable.outlook,"Outlook","Client de courrier électronique"));

        ListView listViewProducts = findViewById(R.id.listView);
        CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(this,R.layout.list_products,productList);
        listViewProducts.setAdapter(customListViewAdapter );
        listViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),productList.get(position).getName(),Toast.LENGTH_LONG).show();
            }
        });
        listViewProducts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Sélection Item")
                        .setMessage("Votre choix : "+productList.get(position).getName())
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
                return false;
            }
        });
    }
}
