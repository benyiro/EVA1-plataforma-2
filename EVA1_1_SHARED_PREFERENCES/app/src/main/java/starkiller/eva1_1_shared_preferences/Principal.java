package starkiller.eva1_1_shared_preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class Principal extends AppCompatActivity {

    EditText EdtNombre, EdtApellido, EdtEdad;
    SharedPreferences shPrMisDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        EdtNombre=(EditText)findViewById(R.id.EdtNombre);
        EdtApellido=(EditText)findViewById(R.id.EdtApellido);
        EdtEdad=(EditText)findViewById(R.id.EdtEdad);
        //leemos los datos
        shPrMisDatos = getSharedPreferences("mis_datos", Activity.MODE_PRIVATE);
        String sNom,sApe;
        int iEdad;
        sNom = shPrMisDatos.getString("Nombre","Hector Benjamin");
        sApe = shPrMisDatos.getString("Apellido", "Rodriguez Flores");
        iEdad = shPrMisDatos.getInt("Edad", 21);

        EdtNombre.setText(sNom);
        EdtApellido.setText(sApe);
        EdtEdad.setText("" + iEdad);

        getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //guardamos los datos
        String sNom,sApe;
        int iEdad;
        sNom = EdtNombre.getText().toString();
        sApe = EdtApellido.getText().toString();
        iEdad = Integer.parseInt(EdtEdad.getText().toString());
        SharedPreferences.Editor edtDatos = shPrMisDatos.edit();
            edtDatos.putString("Nombre",sNom);
            edtDatos.putString("Apellido",sApe);
            edtDatos.putInt("Edad", iEdad);
        edtDatos.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
