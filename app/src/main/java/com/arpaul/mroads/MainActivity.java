package com.arpaul.mroads;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arpaul.mroads.adapter.FlightAdapter;
import com.example.VerifyFlights;

import java.util.ArrayList;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {

    private EditText edtDest;
    private RecyclerView rvFlights;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private Button btnVerify;

    private ArrayList<String> arrFlights = new ArrayList<>();
    private FlightAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeControls();

//        arrFlights.add("AA1111/ATL/DAL/HOU");
//        arrFlights.add("AA2222/TPA/ATL/HOU/ORD");
//        arrFlights.add("AA3333/DAL/ORD/MSP/HOU");
//        String isFlight = VerifyFlights.checkFlight(arrFlights, "ORD-MSP");
//        if(TextUtils.isEmpty(isFlight))
//            isFlight = "No Flights Found";
//        edtDest.setText(isFlight);

        B objB = new B();
        fn1(objB);
//        objB = new B();
        fn2(objB);

        arrFlights.add("");
        adapter.refresh(arrFlights);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrFlights.add("");
                adapter.refresh(arrFlights);
            }
        });

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verify = edtDest.getText().toString();
                if(!TextUtils.isEmpty(verify)) {
                    if(adapter != null) {
                        ArrayList<String> arrFlights = adapter.getFlights();
                        String isFlight =  VerifyFlights.checkFlight(arrFlights, verify);

                        Toast.makeText(MainActivity.this, isFlight, Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Text box empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void fn1(B b) {
//        b = new B();
        b.x = 10;
        b.y = 20;
        b.z = b.x + b.y;
    }

    void fn2(B b) {
        System.out.println("b.z = " + b.z);
    }

    static class B {
        int x,y,z;
    }

    void initializeControls() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtDest = (EditText) findViewById(R.id.edtDest);

        rvFlights = (RecyclerView) findViewById(R.id.rvFlights);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        btnVerify = (Button) findViewById(R.id.btnVerify);

        adapter = new FlightAdapter(this, new ArrayList<String>());
        rvFlights.setAdapter(adapter);
    }
}
