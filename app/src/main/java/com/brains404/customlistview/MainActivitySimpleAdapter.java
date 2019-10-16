package com.brains404.customlistview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;



public class MainActivitySimpleAdapter extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listViewProducts = findViewById(R.id.listView);
        final List<HashMap<String,String>> productList = new ArrayList<>();
        // prod 1
        HashMap<String,String> prod1 = new HashMap<String,String>() ;
        prod1.put("titre","Word");
        prod1.put("description","Traitement de texte");
        prod1.put("image",String.valueOf(R.drawable.word));
        productList.add(prod1);
        //prod 2
        HashMap<String,String> prod2 = new HashMap<String,String>() ;
        prod2.put("titre","Excel");
        prod2.put("description","Tableur");
        prod2.put("image",String.valueOf(R.drawable.excel));
        productList.add(prod2);
        //prod 3
        HashMap<String,String> prod3 = new HashMap<String,String>() ;
        prod3.put("titre","PowerPoint");
        prod3.put("description","Logiciel de présentation");
        prod3.put("image",String.valueOf(R.drawable.powerpoint));
        productList.add(prod3);
        //prod 4
        HashMap<String,String> prod4 = new HashMap<String,String>() ;
        prod4.put("titre","Outlook");
        prod4.put("description","Client de courrier électronique");
        prod4.put("image",String.valueOf(R.drawable.outlook));
        productList.add(prod4);
        // my Adapter
        SimpleAdapter myAdapter = new SimpleAdapter(this.getBaseContext(),productList,R.layout.list_products,new String[]  {"titre","description","image"},new int [] {R.id.textView3,R.id.textView2,R.id.imageView2});
         listViewProducts.setAdapter(myAdapter);
        listViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),productList.get(position).get("titre"),Toast.LENGTH_LONG).show();
            }
        });
        listViewProducts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                new AlertDialog.Builder(MainActivitySimpleAdapter.this)
                        .setTitle("Sélection Item")
                        .setMessage("Votre choix : "+productList.get(position).get("titre"))
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).show();
                return false;
            }
        });

    }
}
