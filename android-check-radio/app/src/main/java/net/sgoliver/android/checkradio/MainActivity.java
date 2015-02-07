package net.sgoliver.android.checkradio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private CheckBox cbMarcame;
    private TextView lblMensaje;
    private RadioGroup rgOpciones;
    private RadioButton rbOpcion1;
    private RadioButton rbOpcion2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbMarcame = (CheckBox)findViewById(R.id.ChkMarcame);

        cbMarcame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox)view).isChecked();

                if (isChecked) {
                    cbMarcame.setText("Checkbox marcado!");
                }
                else {
                    cbMarcame.setText("Checkbox desmarcado!");
                }
            }
        });

        //cbMarcame.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
        //    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //        if (isChecked) {
        //            cbMarcame.setText("Checkbox marcado!");
        //        }
        //        else {
        //            cbMarcame.setText("Checkbox desmarcado!");
        //        }
        //    }
        //});

        lblMensaje = (TextView)findViewById(R.id.LblSeleccion);

        rbOpcion1 = (RadioButton)findViewById(R.id.RbOpcion1);
        rbOpcion2 = (RadioButton)findViewById(R.id.RbOpcion2);

        View.OnClickListener list = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String opcion = "";
                switch(view.getId()) {
                    case R.id.RbOpcion1:
                        opcion = "opción 1";
                        break;
                    case R.id.RbOpcion2:
                        opcion = "opción 2";
                        break;
                }

                lblMensaje.setText("ID opción seleccionada: " + opcion);
            }
        };

        rbOpcion1.setOnClickListener(list);
        rbOpcion2.setOnClickListener(list);

        //rgOpciones = (RadioGroup)findViewById(R.id.GrbGrupo1);
        //rgOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        //    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //
        //        String opcion = "";
        //        switch(checkedId) {
        //            case R.id.RbOpcion1:
        //                opcion = "opción 1";
        //                break;
        //            case R.id.RbOpcion2:
        //                opcion = "opción 2";
        //                break;
        //        }
        //
        //        lblMensaje.setText("ID opción seleccionada: " + opcion);
        //    }
        //});
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
