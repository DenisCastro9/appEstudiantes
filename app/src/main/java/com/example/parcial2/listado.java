package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listado extends AppCompatActivity {
    private ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        lv1 = findViewById(R.id.lv1);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"base1",null,1);
        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor registro = db.rawQuery("select dni, mail from alumnos",null);
        ArrayList<String> list = new ArrayList<>();
        while (registro.moveToNext())
        {
            list.add(registro.getString(0)+ " - " + registro.getString(2));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        lv1.setAdapter(adapter);
    }
}