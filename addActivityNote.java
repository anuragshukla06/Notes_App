package com.casper.notes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class addActivityNote extends AppCompatActivity {

    EditText editText;
    String text;
    int Index;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        sp = this.getSharedPreferences("com.casper.notes", Context.MODE_PRIVATE);
        editText = (EditText) findViewById(R.id.editText);
        Intent intent = getIntent();
        text = intent.getStringExtra("note");
        Index = intent.getIntExtra("index", -1);
        if(!text.equals("noString")) {
            editText.setText(text);
            editText.setSelection(editText.getText().length());
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        String toAdd = editText.getText().toString();
        Log.i("msg",toAdd);
        if(toAdd.equals("")){

            return;
        }
        if(text.equals("noString")) {
            MainActivity.notes.add(toAdd);
        }
        else {
            try {
                MainActivity.notes.set(Index, toAdd);
            } catch (Exception e) {
                Toast.makeText(this, "Something went Wrong", Toast.LENGTH_SHORT);
            }
        }

        try {
            String ser = ObjectSerializer.serialize(MainActivity.notes);
            sp.edit().putString("notesSer", ser).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MainActivity.arrayAdapter.notifyDataSetChanged();

    }
}
