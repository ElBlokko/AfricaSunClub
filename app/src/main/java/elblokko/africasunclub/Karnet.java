package elblokko.africasunclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by DJ on 2017-02-25.
 */

public class Karnet extends AppCompatActivity {

    ZarzadcaBazy zb = new ZarzadcaBazy(this);
    private Button powrot;
    private Button zatwierdz;
    private EditText nazwisko;
    private EditText wartosc;
    private EditText nr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.karnet);

        nazwisko = (EditText) findViewById(R.id.wpiszNazwisko);
        wartosc = (EditText) findViewById(R.id.wpiszWartoscKarnetu);
        nr = (EditText) findViewById(R.id.wpiszNrKarnetu);

        powrot = (Button) findViewById(R.id.Powrot);
        powrot.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent startAnotherActivity = new Intent(getApplicationContext(), Sprzedaz.class);
                startActivity(startAnotherActivity);
                Karnet.super.onPause();
                finish();
            }
        });
        zatwierdz = (Button) findViewById(R.id.zatwierdz);
        zatwierdz.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNazwisko = nazwisko.getText().toString();
                String strNr = nr.getText().toString();
                String strWartosc = wartosc.getText().toString();
                zb.dodajKarnet(strNazwisko, strWartosc);
                Karnet.super.onPause();
                finish();
            }
        });

    }
}
