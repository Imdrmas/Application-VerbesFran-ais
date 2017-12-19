package com.verbes.drmas.verbesfranais;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     // SearchView sv;
      ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        // Itme Home Page
        ListView listView = (ListView)findViewById(R.id.ListView);
      // sv=(SearchView)findViewById(R.id.SearchView1);


        String[] itme = getResources().getStringArray(R.array.index);
        final ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.row_itme,R.id.textitem,itme);
        listView.setAdapter(arrayAdapter);

/*

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String text) {
                arrayAdapter.getFilter().filter(text);
                return false;
            }
        });

*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, webhtml.class);
                intent.putExtra("page",position);
                startActivity(intent);
            }
        });

    } // the main_activity


    // Start menu
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_main, menu );
        return super.onCreateOptionsMenu( menu );
    } // end menu


    // Start items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
          Intent intent;

        switch (item.getItemId()){
            case R.id.home_icon:
                Toast.makeText(MainActivity.this, "This is home page", Toast.LENGTH_SHORT).show();
                return true;
              //  Intent intent = new Intent(this, MainActivity.class);
               // startActivity( intent );
            case R.id.item1:
                intent = new Intent(this, MainActivity.class);
                startActivity( intent );
            case R.id.item2:
                intent = new Intent(this, MainActivity.class);
                startActivity( intent );
            case R.id.item3:
                intent = new Intent(this, MainActivity.class);
                startActivity( intent );
            default:
                return super.onOptionsItemSelected( item );
        }

    } // end itmes

*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate( R.menu.menu_main, menu );

        MenuItem menuItem = menu.findItem( R.id.search );
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        } );



        return super.onCreateOptionsMenu( menu );
    }




    public void img_share(View view){
        String txtshare = "Conjugaison les verbes français";
        String sharelink = "https://play.google.com/store/apps/details?id=com.verbes.drmas.verbesfranais";

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txtshare + "\n" + sharelink);
        startActivity(share);

    } // end Share

    // Start Send email
    public void img_email(View view) {
        try {
            String txt = "Good morning \n" + "My suggestion is";
            Intent sendemail = new Intent(Intent.ACTION_SEND);
            sendemail.setData( Uri.parse("mailto:"));
            sendemail.setType(("message/rfc822"));
            sendemail.putExtra(Intent.EXTRA_EMAIL, "imdrmas@gmail.com");
            sendemail.putExtra(Intent.EXTRA_SUBJECT, "Application conjugaison les verbes français");
            sendemail.putExtra(Intent.EXTRA_TEXT, txt);
            startActivity(sendemail);
        }catch (Exception e) {
            Toast.makeText(this,"Sorry cannot find the application", Toast.LENGTH_LONG).show();
        }
    } // end send email





    public void img_close(View view) {
        finish();
    }

} // the ending
