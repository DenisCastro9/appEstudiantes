package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String basedatos = "base1";
    private EditText etdni,etcarrera,etmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etdni = findViewById(R.id.etdni);
        etcarrera = findViewById(R.id.etcarrera);
        etmail = findViewById(R.id.etmail);
    }


    public void cargar (View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,basedatos,null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("dni",etdni.getText().toString());
        registro.put("carrera",etcarrera.getText().toString());
        registro.put("mail",etmail.getText().toString());
        db.insert("alumnos",null,registro);
        db.close();
        admin.close();
        etdni.setText("");
        etcarrera.setText("");
        etmail.setText("");
        Toast.makeText(this, "Se cargo el Usuario exitosamente", Toast.LENGTH_SHORT).show();
    }


    public void consultaDni(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,basedatos,null,1);
        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor registro = db.rawQuery("select carrera, mail from alumnos where dni =" + etdni.getText().toString(),null);
        if (registro.moveToFirst())
        {
            etcarrera.setText(registro.getString(0));
            etmail.setText(registro.getString(1));
        }
        else
        {
            Toast.makeText(this, "No existe el Usuario con el dni: " + etdni.getText().toString(), Toast.LENGTH_SHORT).show();
            etdni.setText("");
            etcarrera.setText("");
            etmail.setText("");
        }
        db.close();
        admin.close();
    }


    public void modificar (View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,basedatos,null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("mail",etmail.getText().toString());
        int cant = db.update("alumnos", registro,"dni =" + etdni.getText().toString(),null);
        if (cant == 1)
        {
            Toast.makeText(this, "Se a modificado el usuario con el dni: " + etdni.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "No existe el usuario con el dni: " + etdni.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        db.close();
        admin.close();
    }


    public void borrar (View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,basedatos,null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        int cant = db.delete("alumnos","dni = " + etdni.getText().toString(),null);
        if (cant == 1)
        {
            Toast.makeText(this, "Se a borrado el Usuario con el dni:" + etdni.getText().toString(), Toast.LENGTH_SHORT).show();
            etdni.setText("");
            etcarrera.setText("");
            etmail.setText("");
        }
        else
        {
            Toast.makeText(this, "No existe el Usuario con el dni: " + etdni.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        db.close();
        admin.close();
    }


    public void lista (View v)
    {
        Intent intento = new Intent(this,listado.class);
        startActivity(intento);
    }


    public void temperatura (View v)
    {
        Intent intento1 = new Intent(this,cirTemperatura.class);
        startActivity(intento1);
    }
}