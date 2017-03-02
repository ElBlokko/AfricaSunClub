package elblokko.africasunclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by DJ on 2017-02-25.
 */

public class Opalanie extends AppCompatActivity {

    private Button karnet;
    private Button gotowka;
    private Button powrot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opalanie);

        karnet = (Button) findViewById(R.id.karnet);
        karnet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startAnotherActivity = new Intent(getApplicationContext(), Karnet.class);
                startActivity(startAnotherActivity);
            }
        });

        gotowka = (Button) findViewById(R.id.gotowka);
        gotowka.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startAnotherActivity = new Intent(getApplicationContext(), Gotowka.class);
                startActivity(startAnotherActivity);
            }
        });

        powrot = (Button) findViewById(R.id.powrot);
        powrot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startAnotherActivity = new Intent(getApplicationContext(), Sprzedaz.class);
                startActivity(startAnotherActivity);
                Opalanie.super.onPause();
                finish();;
            }
        });
    }
}
