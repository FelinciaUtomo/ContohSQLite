package id.ac.petra.contohsqlite;

public class Contact {
    int id;
//  Tidak diakses langsung gunakan "_"
    String nama;
    String phone;

    public Contact(int id, String nama, String phone) {
        this.id = id;
        this.nama = nama;
        this.phone = phone;
    }

    public Contact() {
    }

    public Contact(String nama, String phone) {
        this.nama = nama;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
