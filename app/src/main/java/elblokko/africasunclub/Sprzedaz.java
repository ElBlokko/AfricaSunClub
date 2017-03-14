package elblokko.africasunclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


/**
 * Created by DJ on 2017-02-24.
 */

public class Sprzedaz extends AppCompatActivity {

    private Button opalanie;
    private Button karnet;
    private Button kosmetyk;
    private Button prasowanie;
    private Button powrot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sprzedaz);

        opalanie = (Button) findViewById(R.id.opalanie);
        opalanie.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent startAnotherActivity = new Intent(getApplicationContext(), Opalanie.class);
                startActivity(startAnotherActivity);
            }
        });

        powrot = (Button) findViewById(R.id.powrot);
        powrot.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent startAnotherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startAnotherActivity);
                Sprzedaz.super.onPause();
                finish();
            }
        });

        karnet = (Button) findViewById(R.id.karnet);
        karnet.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent startAnotherActivity = new Intent(getApplicationContext(), Karnet.class);
                startActivity(startAnotherActivity);
            }
        });

        prasowanie = (Button) findViewById(R.id.karnet);
        prasowanie.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent startAnotherActivity = new Intent(getApplicationContext(), Prasowanie.class);
                startActivity(startAnotherActivity);
            }
        });
    }
}
