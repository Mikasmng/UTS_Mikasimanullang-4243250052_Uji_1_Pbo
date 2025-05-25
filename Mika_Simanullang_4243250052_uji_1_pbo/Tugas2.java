// Class utama untuk menjalankan program jadwal sholat
public class Tugas2 {
    public static void main(String[] args) {
        // Array of polymorphic objects
        Prayer[] prayers = {
            new Fajr(),
            new Dhuhr(),
            new Asr(),
            new Maghrib(),
            new Isha()
        };

        // Menjalankan pengingat dan adzan untuk setiap waktu sholat
        for (Prayer prayer : prayers) {
            prayer.remind(); // Polymorphism: memanggil implementasi dari masing-masing subclass

            // Jika objek memiliki audio reminder, jalankan adzan
            if (prayer instanceof AudioReminder) {
                ((AudioReminder) prayer).playAdzan();
            }

            System.out.println(); // Pemisah antar jadwal
        }
    }
}

// Abstract class yang menjadi dasar semua sholat
abstract class Prayer {
    protected String name;

    public Prayer(String name) {
        this.name = name;
    }

    // Method abstrak yang harus diimplementasikan setiap waktu sholat
    public abstract void remind();
}

// Interface untuk fitur pengingat audio (adzan)
interface AudioReminder {
    void playAdzan();
}

// Subclass Fajr
class Fajr extends Prayer implements AudioReminder {
    public Fajr() {
        super("Sholat Subuh");
    }

    @Override
    public void remind() {
        System.out.println("Waktunya " + name + ". Mulailah hari dengan berdoa.");
    }

    @Override
    public void playAdzan() {
        System.out.println("Memutar adzan Subuh...");
    }
}

// Subclass Dhuhr
class Dhuhr extends Prayer implements AudioReminder {
    public Dhuhr() {
        super("Sholat Dzuhur");
    }

    @Override
    public void remind() {
        System.out.println("Sudah masuk waktu " + name + ". Tinggalkan sejenak aktivitas.");
    }

    @Override
    public void playAdzan() {
        System.out.println("Memutar adzan Dzuhur...");
    }
}

// Subclass Asr
class Asr extends Prayer implements AudioReminder {
    public Asr() {
        super("Sholat Ashar");
    }

    @Override
    public void remind() {
        System.out.println("Saatnya " + name + ". Jangan lewatkan kewajiban.");
    }

    @Override
    public void playAdzan() {
        System.out.println("Memutar adzan Ashar...");
    }
}

// Subclass Maghrib
class Maghrib extends Prayer implements AudioReminder {
    public Maghrib() {
        super("Sholat Maghrib");
    }

    @Override
    public void remind() {
        System.out.println("Sudah masuk " + name + ". Waktunya berbuka dan sholat.");
    }

    @Override
    public void playAdzan() {
        System.out.println("Memutar adzan Maghrib...");
    }
}

// Subclass Isha
class Isha extends Prayer implements AudioReminder {
    public Isha() {
        super("Sholat Isya");
    }

    @Override
    public void remind() {
        System.out.println("Waktunya " + name + ". Tutup harimu dengan ibadah.");
    }

    @Override
    public void playAdzan() {
        System.out.println("Memutar adzan Isya...");
    }
}
