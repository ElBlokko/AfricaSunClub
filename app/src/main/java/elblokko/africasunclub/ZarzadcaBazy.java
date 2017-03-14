package elblokko.africasunclub;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
/**
 * Created by DJ on 2017-02-27.
 */

public class ZarzadcaBazy extends SQLiteOpenHelper {

    public ZarzadcaBazy(Context context){
        super(context, "karnety.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table karnety(" +
                "nr integer primary key autoincrement, " +
                "nazwisko varchar(20)," +
                "uwagi varchar(200)," +
                "id varchar(4)," +
                "dataWaznosci date," +
                "wartosc real);");

        db.execSQL("create table historia(" +
                "lozko varchar(10) not null," +
                "minuty char(2) not null," +
                "nr integer primary key autoincrement," +
                "karnet char(4));");
        db.execSQL("create table uslugi(" +
                "nazwa varchar(10)," +
                "cena varchar(10)," +
                "nr integer primary key);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion ){
    }

    public void dodajKarnet( String nazwisko, String wartosc ){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("nazwisko", nazwisko);
        wartosci.put("wartosc", wartosc);

        db.insertOrThrow("karnety", null, wartosci);
    }

    public Cursor wyswietl(){
        String[] kolumny = {"nr", "nazwisko", "wartosc"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("karnety", kolumny, null, null, null, null, null);
        return kursor;
    }
    public Cursor wyswietl(String szukany){
        String[] kolumny = {"nr", "nazwisko", "wartosc"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("karnety", kolumny, "nazwisko like ?", new String[] {"%" + szukany + "%"}, null, null, null);
        return kursor;
    }
}
