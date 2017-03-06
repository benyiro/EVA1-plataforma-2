package starkiller.eva1_6_smash;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Secundaria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_secundaria);
        getFragmentManager().beginTransaction().replace(android.R.id.content,           //Que reemplazamos//
        new Confoguracion()) .commit();//con que lo reemplazamos
        SharedPreferences spMisPref = PreferenceManager.getDefaultSharedPreferences(this);
        Resources resource = this.getResources();

    }
    private void Selccionarcolor() {
        SharedPreferences spMisPref = PreferenceManager.getDefaultSharedPreferences(this);
        Resources resource = this.getResources();
        String ColorData = spMisPref.getString("language_preference", "en-US");
        int genderData = Integer.parseInt(spMisPref.getString("gender_preference", "0"));
        String[] voiceAlias = resource.getStringArray(R.array.entradas);

        int a = 1;
        String[] languageAlias = resource.getStringArray(R.array.valores);
        for (a; a < languageAlias.length ; a++) {
            if (languageAlias[a].equals(ColorData)) {
                break;
            }
        }

        shareprefs.putString("VoiceAlias", voiceAlias[(2 * a) + genderData]);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secundaria, menu);
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
    public static class Confoguracion extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferencias);

        }
    }
}
