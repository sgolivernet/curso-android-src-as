package net.sgoliver.android.imagenytexto;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

    private EditText txtTexto;
    private Button btnNegrita;
    private Button btnSetText;

    private TextInputLayout txtInputLayout;
    private EditText txtInput;
    private Button btnComprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTexto = (EditText)findViewById(R.id.TxtBasico);

        btnNegrita = (Button)findViewById(R.id.BtnNegrita);
        btnNegrita.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                Spannable texto = txtTexto.getText();

                int ini = txtTexto.getSelectionStart();
                int fin = txtTexto.getSelectionEnd();

                if(texto != null) {
                    texto.setSpan(
                            new StyleSpan(android.graphics.Typeface.BOLD),
                            ini, fin,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        });

        btnSetText = (Button)findViewById(R.id.BtnSetText);
        btnSetText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                Editable str = Editable.Factory.getInstance().newEditable("Esto es un simulacro.");
                str.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 11, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                txtTexto.setText(str);

                //Nueva cadena de texto
                //String nuevoTexto = "<p>Otro <b>texto</b> de ejemplo.</p>";

                //Asigna texto sin formato (incluirá todas las etiquetas HTML)
                //txtTexto.setText(nuevoTexto);

                //Asigna texto con formato HTML
                //txtTexto.setText(Html.fromHtml(nuevoTexto),BufferType.SPANNABLE);

                //Obtiene el texto SIN etiquetas de formato HTML
                //String aux1 = txtTexto.getText().toString();

                //Obtiene el texto CON etiquetas de formato HTML
                //String aux2 = Html.toHtml(txtTexto.getText());
            }
        });

        //TextInputLayout
        txtInputLayout = (TextInputLayout)findViewById(R.id.TiLayout);
        txtInputLayout.setErrorEnabled(true);

        txtInput = (EditText)findViewById(R.id.TxtInput);

        btnComprobar = (Button)findViewById(R.id.BtnInputLayout);
        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = txtInput.getText().toString();

                if(num.isEmpty() || Integer.parseInt(num)%2 != 0)
                    txtInputLayout.setError("Error: No es un número par!");
                else
                    txtInputLayout.setError(null);
            }
        });
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
