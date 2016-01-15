package net.sgoliver.android.palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgImagen;

    private TextView txtVibrant;
    private TextView txtDarkVibrant;
    private TextView txtLightVibrant;

    private TextView txtMuted;
    private TextView txtDarkMuted;
    private TextView txtLightMuted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgImagen = (ImageView)findViewById(R.id.imgImagen);

        txtVibrant = (TextView)findViewById(R.id.txtVibrant);
        txtDarkVibrant = (TextView)findViewById(R.id.txtDarkVibrant);
        txtLightVibrant = (TextView)findViewById(R.id.txtLightVibrant);

        txtMuted = (TextView)findViewById(R.id.txtMuted);
        txtDarkMuted = (TextView)findViewById(R.id.txtDarkMuted);
        txtLightMuted = (TextView)findViewById(R.id.txtLightMuted);

        imgImagen.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.flores_2));

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.flores_2);

        Palette.from(bitmap).maximumColorCount(24).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette p) {

                /*
                //Opción 1: Acceso directo a los colores principales
                txtVibrant.setBackgroundColor(p.getVibrantColor(Color.BLACK));
                txtDarkVibrant.setBackgroundColor(p.getDarkVibrantColor(Color.BLACK));
                txtLightVibrant.setBackgroundColor(p.getLightVibrantColor(Color.BLACK));

                txtMuted.setBackgroundColor(p.getMutedColor(Color.BLACK));
                txtDarkMuted.setBackgroundColor(p.getDarkMutedColor(Color.BLACK));
                txtLightMuted.setBackgroundColor(p.getLightMutedColor(Color.BLACK));
                */

                //Opción 2: Acceso a los swatches pricipales completos
                setTextViewSwatch(txtVibrant, p.getVibrantSwatch());
                setTextViewSwatch(txtDarkVibrant, p.getDarkVibrantSwatch());
                setTextViewSwatch(txtLightVibrant, p.getLightVibrantSwatch());
                setTextViewSwatch(txtMuted, p.getMutedSwatch());
                setTextViewSwatch(txtDarkMuted, p.getDarkMutedSwatch());
                setTextViewSwatch(txtLightMuted, p.getLightMutedSwatch());

                //Opción 3: Acceso a todos los swatches generados
                for (Palette.Swatch sw : p.getSwatches()) {
                    Log.i("Palette", "Color: #" + Integer.toHexString(sw.getRgb()) + " (" + sw.getPopulation() + " píxeles)");
                }
            }
        });
    }

    private void setTextViewSwatch(TextView tview, Palette.Swatch swatch) {
        if(swatch != null) {
            tview.setBackgroundColor(swatch.getRgb());
            tview.setTextColor(swatch.getBodyTextColor());
            tview.setText("Pixeles: " + swatch.getPopulation());
        }
        else {
            tview.setBackgroundColor(Color.BLACK);
            tview.setTextColor(Color.WHITE);
            tview.setText("(sin definir)");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
