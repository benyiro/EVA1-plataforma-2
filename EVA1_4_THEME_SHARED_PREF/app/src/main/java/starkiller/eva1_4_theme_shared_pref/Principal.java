package starkiller.eva1_4_theme_shared_pref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Principal extends AppCompatActivity {

    RadioGroup RGTema;
    RadioButton radioTema1, radioTema2;
    SharedPreferences shprMisdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        RGTema = (RadioGroup)findViewById(R.id.RGTema);
        radioTema1 = (RadioButton)findViewById(R.id.radioTema1);
        radioTema1 = new RadioButton(this, null, R.style.Amarillo);
        radioTema2 = (RadioButton)findViewById(R.id.radioTema2);

        shprMisdatos = getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
       int savedRadioIndex = shprMisdatos.getInt("KEY_SAVED_RADIO_BUTTON_INDEX",R.id.radioTema1);
      // int savedRadioIndex2= shprMisdatos.getInt("TEMA2",R.id.radioTema2);
        RGTema.check(savedRadioIndex);
        //RGTema.check(savedRadioIndex2);

        RGTema.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioTema1:
                        setTheme(R.style.Amarillo);
                        break;
                    case R.id.radioTema2:
                        setTheme(R.style.Verde);
                        break;

                }

            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor edtDatos = shprMisdatos.edit();
        edtDatos.putInt("KEY_SAVED_RADIO_BUTTON_INDEX",R.id.radioTema1 );
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
