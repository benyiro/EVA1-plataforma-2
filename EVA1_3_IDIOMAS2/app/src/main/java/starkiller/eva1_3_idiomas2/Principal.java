package starkiller.eva1_3_idiomas2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    RadioGroup rdIdioma;
    RadioButton radioEsp, radioIng;
    TextView txtNom,txtApe;
    SharedPreferences shprMisdatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        rdIdioma = (RadioGroup)findViewById(R.id.rdIdioma);
        radioEsp = (RadioButton)findViewById(R.id.radioEsp);
        radioIng = (RadioButton)findViewById(R.id.radioIng);
        txtNom = (TextView)findViewById(R.id.txtNom);
        txtApe = (TextView)findViewById(R.id.txtApe);
        //guardar datos
        shprMisdatos = getSharedPreferences("mis_datos", Activity.MODE_PRIVATE);
        //boolean radio1,radio2;
        boolean radioesp = shprMisdatos.getBoolean("Radio1",false);
        boolean radioeng = shprMisdatos.getBoolean("Radio2",true);

        rdIdioma.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioEsp:
                        txtNom.setText(R.string.Nombre);
                        txtApe.setText(R.string.Apellidos);
                        break;
                    case R.id.radioIng:
                        txtNom.setText(R.string.Name);
                        txtApe.setText(R.string.Last_Name);
                        break;
                }
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
       // boolean radio1,radio2;
        //radio1 = radioEsp.isChecked();
        //radio2 = radioIng.isChecked();
        SharedPreferences.Editor edtDatos = shprMisdatos.edit();
        edtDatos.putBoolean("Radio1",radioEsp.isChecked());
        edtDatos.putBoolean("Radio2", radioIng.isChecked());
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
