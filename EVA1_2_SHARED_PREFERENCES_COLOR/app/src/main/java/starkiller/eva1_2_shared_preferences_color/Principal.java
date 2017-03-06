package starkiller.eva1_2_shared_preferences_color;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Principal extends AppCompatActivity {

    RadioGroup RGcolor;
    RadioButton radioRojo, radioAzul, radioVerde;
    SharedPreferences shprMisdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        RGcolor = (RadioGroup)findViewById(R.id.RGcolor);
        radioRojo = (RadioButton)findViewById(R.id.radioRojo);
        radioAzul = (RadioButton)findViewById(R.id.radioAzul);
        radioVerde = (RadioButton)findViewById(R.id.radioVerde);
        //leer datos
        shprMisdatos = getSharedPreferences("mis_datos", Activity.MODE_PRIVATE);
        String cRojo,cAzul,cVerde;
        cRojo = shprMisdatos.getString("Color1", "Red");
        cAzul = shprMisdatos.getString("Color2","Blue");
        cVerde = shprMisdatos.getString("Color3","Green");

        //trabajo de los radiobuttons
        RGcolor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioRojo:
                        getWindow().getDecorView().setBackgroundColor(Color.RED);
                        break;
                    case R.id.radioAzul:
                        getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                        break;
                    case R.id.radioVerde:
                        getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                        break;
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        String cRojo,cAzul,cVerde;
        //cRojo = radioRojo.getText().toString();
        //cAzul = radioAzul.getText().toString();
       // cVerde = radioAzul.getText().toString();

        SharedPreferences.Editor edtDatos = shprMisdatos.edit();
        edtDatos.putString("Color1","Rojo");
        edtDatos.putString("Color2","Azul");
        edtDatos.putString("Color3","Verde");
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
