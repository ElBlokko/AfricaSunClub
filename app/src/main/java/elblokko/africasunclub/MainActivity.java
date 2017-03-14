package elblokko.africasunclub;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button sprzedaz;
    private Button listaKarnetow;
    private Button wyjscie;
    private Button raporty;
    private Button edycjaTowarow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.textView1);
        sprzedaz = (Button) findViewById(R.id.sprzedaz);
        sprzedaz.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent startAnotherActivity = new Intent(getApplicationContext(), Sprzedaz.class);
                startActivity(startAnotherActivity);
            }
        });

        listaKarnetow = (Button) findViewById(R.id.lista_karnetow);
        listaKarnetow.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent startAnotherActivity = new Intent(getApplicationContext(), ListaKarnetow.class);
                startActivity(startAnotherActivity);
            }
        });
        ZarzadcaBazy zb = new ZarzadcaBazy(this);

        Cursor k = zb.wyswietl();
        while (k.moveToNext()){
            int nr = k.getInt(0);
            String imie = k.getString(1);
            String nazwisko = k.getString(2);
            tv.setText(tv.getText()+"\n"+imie +" "+nazwisko);

        }

    }


}
