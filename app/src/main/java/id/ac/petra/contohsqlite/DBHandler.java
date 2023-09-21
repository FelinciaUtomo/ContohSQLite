package id.ac.petra.contohsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_Version = 1;
    private static final String DB_Name = "ContactsManager";
    private static final String TB_Name = "Contacts";
    private static final String Key_ID = "ID";
    private static final String Key_Name = "Name";
    private static final String Key_Phone = "Phone";


    public DBHandler(@Nullable Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    //  Membuat table di SQLite
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Query = "Create Table " + TB_Name + "(" + Key_ID + " Integer Primary Key," +
                Key_Name + " Text," + Key_Phone + " Text" + ")";
        sqLiteDatabase.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TB_Name);
        onCreate(sqLiteDatabase);
    }

    //  Method untuk menambahkan
    public void addContact(Contact c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Key_Name, c.getNama());
        cv.put(Key_Phone, c.getPhone());
        db.insert(TB_Name, null, cv);
        db.close();
    }

    public Contact getContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TB_Name, new String[]{Key_ID, Key_Name, Key_Phone},
                Key_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
        if (c != null)
            c.moveToFirst();
        Contact contact = new Contact(Integer.parseInt(c.getString(0)), c.getString(1), c.getString(2));
        return contact;
    }

    public List<Contact> getAllContacts() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Contact> contactlist = new ArrayList<Contact>();

        String query = "Select * From " + TB_Name;
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
//          Kerjakan selama masih bisa dipindahkan ke yang lain
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(c.getString(0)));
                contact.setNama(c.getString(1));
                contact.setPhone(c.getString(2));
                contactlist.add(contact);
            } while (c.moveToNext());
        }
        return contactlist;
    }
}