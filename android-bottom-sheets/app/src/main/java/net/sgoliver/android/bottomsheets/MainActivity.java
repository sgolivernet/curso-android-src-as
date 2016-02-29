package net.sgoliver.android.bottomsheets;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button btnExpBottomSheet;
    private Button btnConBottomSheet;
    private Button btnOcuBottomSheet;
    private Button btnModalBottomSheet;
    private LinearLayout bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bottom Sheets");

        bottomSheet = (LinearLayout)findViewById(R.id.bottomSheet);

        final BottomSheetBehavior bsb = BottomSheetBehavior.from(bottomSheet);

        btnExpBottomSheet = (Button)findViewById(R.id.btnExpBottomSheet);
        btnExpBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bsb.setState(BottomSheetBehavior.STATE_EXPANDED);
                //bottomSheet.requestLayout();
            }
        });

        btnConBottomSheet = (Button)findViewById(R.id.btnConBottomSheet);
        btnConBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bsb.setState(BottomSheetBehavior.STATE_COLLAPSED);
                //bottomSheet.requestLayout();
            }
        });

        btnOcuBottomSheet = (Button)findViewById(R.id.btnOcuBottomSheet);
        btnOcuBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bsb.setState(BottomSheetBehavior.STATE_HIDDEN);
                //bottomSheet.requestLayout();
            }
        });

        bsb.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                String nuevoEstado = "";

                switch(newState) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        nuevoEstado = "STATE_COLLAPSED";
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        nuevoEstado = "STATE_EXPANDED";
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        nuevoEstado = "STATE_HIDDEN";
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        nuevoEstado = "STATE_DRAGGING";
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        nuevoEstado = "STATE_SETTLING";
                        break;
                }

                Log.i("BottomSheets", "Nuevo estado: " + nuevoEstado);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.i("BottomSheets", "Offset: " + slideOffset);
            }
        });

        btnModalBottomSheet = (Button)findViewById(R.id.btnModalBottomSheet);
        btnModalBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogFragment bsdFragment =
                        MiBottomSheetDialogFragment.newInstance();

                bsdFragment.show(
                        MainActivity.this.getSupportFragmentManager(), "BSDialog");
            }
        });
    }
}
