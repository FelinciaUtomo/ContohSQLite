package id.ac.petra.contohsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

//  Step materi kelas :
//    1. Buat new class "Contact"
//    2. Generate Constructor
//    4. Generate Getter and Setter
//    5. Buat new class "DBHandler"
//    6. Isi MainActivity.java
//    7. Generate Constructor "Phone and Nama"
//    8. Lanjut "DBHandler"
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler dbHandler = new DBHandler(this);
        dbHandler.addContact(new Contact("Cia", "085748677709"));
        dbHandler.addContact(new Contact("Ben", "085748677707"));
        dbHandler.addContact(new Contact("Adi", "085748677708"));
        Log.d("SQLite", "Membaca isi database");
        List<Contact> contacts = dbHandler.getAllContacts();
        for (Contact c: contacts){
            String m = "id: "+c.getId()+ " nama: "+c.getNama()+ " phone: "+c.getPhone();
            Log.d("SQLite",m);
        }
    }
}