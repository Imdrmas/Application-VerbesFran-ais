package com.verbes.drmas.verbesfranais;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicReference;

public class conjugation extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] strings;
    private ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_conjugation );


        // Start ListView
        final ListView listView = (ListView)findViewById(R.id.ListView);
         strings = getResources().getStringArray( R.array.index);
         adapter = new ArrayAdapter<String>( conjugation.this, R.layout.row_itme,R.id.textitem, strings);
         listView.setAdapter( adapter );
         listView.setOnItemClickListener( this );



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(conjugation.this, webhtml.class);
                intent.putExtra("page",position);
                startActivity(intent);


            }
        }); // end ListView

    } // end Main



 // Start menu
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
                adapter.getFilter().filter(newText);
                return false;
            }
        } );

        return super.onCreateOptionsMenu( menu );
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         String value = adapter.getItem( position );
        Toast.makeText( getApplicationContext(), value, Toast.LENGTH_LONG ).show();



    } // endding Menu


// start img_icons
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


}
