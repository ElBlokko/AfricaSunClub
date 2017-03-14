package elblokko.africasunclub;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by DJ on 2017-03-01.
 */

public class ListaKarnetow extends AppCompatActivity {
    private TextView wyswietl;
    private EditText wyszukaj;
    String strWyszukaj ="";
    ZarzadcaBazy zb = new ZarzadcaBazy(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listakarnetow);
        wyszukaj = (EditText) findViewById(R.id.wyszukiwarka);
        wyswietl = (TextView) findViewById(R.id.wyswietlanie);
        wyszukaj.addTextChangedListener(textWatcher);
    }

    public TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            wyswietl.setText("");
            strWyszukaj = wyszukaj.getText().toString();
            if(strWyszukaj.length()!=0) {
                Cursor k = zb.wyswietl(strWyszukaj);
                while (k.moveToNext()) {
                    int nr = k.getInt(0);
                    String imie = k.getString(1);
                    String nazwisko = k.getString(2);
                    wyswietl.setText(wyswietl.getText() + "\n" + imie + " " + nazwisko);
                }
            }
        }
    };
}
