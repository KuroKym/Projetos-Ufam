package br.edu.ufam.icomp.trab2;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void entrarClicado(View view) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String prefLogin = sharedPreferences.getString("login", "");
        String prefPass  = sharedPreferences.getString("password", "");

        String editLogin = ((EditText) findViewById(R.id.editLogin)).getText().toString();
        String editPass  = ((EditText) findViewById(R.id.editPassword)).getText().toString();

        if (editLogin.equals(prefLogin) && editPass.equals(prefPass)) {
            Intent intent = new Intent(this, ListActivity.class);
            EditText inputLogin = findViewById(R.id.editLogin);
            intent.putExtra("login", inputLogin.getText().toString());
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Login/senha inválidos!", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.about) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("PlainText Password Manager v1.0")
                    .setNeutralButton("Ok", null).show();
            return true;
        } else if (itemId == R.id.configs) {
            Intent intentConfig = new Intent(this, PreferencesActivity.class);
            startActivity(intentConfig);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}