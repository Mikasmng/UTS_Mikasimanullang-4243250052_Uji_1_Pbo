// Class utama tempat program dijalankan
public class Tugas1 {
    public static void main(String[] args) {
        // Polymorphism: objek bertipe Vehicle tapi mereferensikan Car dan Motorcycle
        Vehicle myCar = new Car();
        Vehicle myMotorcycle = new Motorcycle();

        // Memanggil method yang dioverride di masing-masing class
        myCar.startEngine();
        myMotorcycle.startEngine();

        // Type casting untuk memanggil method dari interface Electric
        if (myCar instanceof Electric) {
            Electric electricCar = (Electric) myCar;
            electricCar.chargeBattery();
        }
    }
}

// Abstract class yang menjadi dasar kendaraan
abstract class Vehicle {
    // Method abstract menandakan bahwa semua turunan harus mengimplementasikan ini
    public abstract void startEngine();
}

// Interface untuk kendaraan listrik
interface Electric {
    // Method untuk mengisi daya baterai
    void chargeBattery();
}

// Class Car mewarisi Vehicle dan mengimplementasikan Electric
class Car extends Vehicle implements Electric {
    @Override
    public void startEngine() {
        // Implementasi khusus mobil
        System.out.println("Mobil dinyalakan dengan tombol start.");
    }

    @Override
    public void chargeBattery() {
        // Implementasi pengisian baterai untuk mobil listrik
        System.out.println("Mengisi daya baterai mobil listrik...");
    }
}

// Class Motorcycle mewarisi Vehicle
class Motorcycle extends Vehicle {
    @Override
    public void startEngine() {
        // Implementasi khusus motor
        System.out.println("Motor dinyalakan dengan kick starter.");
    }
}
