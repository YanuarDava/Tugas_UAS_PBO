import java.util.Scanner;

//class abstrack
abstract class Food {
    //encapsulation
    protected String name;
    protected double price;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void prepare();

    public double getPrice() {
        return price;
    }

    //overridding
    @Override
    public String toString() {
        return name + " - Rp " + price;
    }
}

// inhertance
class NasiGoreng extends Food {
    private boolean spicy;

    public NasiGoreng(String name, double price, boolean spicy) {
        super(name, price);
        this.spicy = spicy;
    }

    public boolean isSpicy() {
        return spicy;
    }

    @Override
    public void prepare() {
        if (spicy) {
            System.out.println("Tambahkan sambal pedas");
        }
        System.out.println("Sajikan nasi goreng " + (spicy ? "pedas" : "biasa"));
    }
}

//overloading
class SalesManager {
    public void sell(Food food) {
        System.out.println("Penjualan: " + food);
        food.prepare();
        System.out.println("Total: Rp " + food.getPrice());
        System.out.println();
    }

    //Overloading
    public void sell(Food food, int quantity) {
        System.out.println("Penjualan: " + food);
        food.prepare();
        double total = food.getPrice() * quantity;
        System.out.println("Jumlah yang dipesan: " + quantity);
        System.out.println("Total (item): Rp " + total);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SalesManager salesManager = new SalesManager();

        System.out.println("Selamat datang di warung Nasi Goreng!");
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Nasi Goreng Pedas - Rp 10,000");
            System.out.println("2. Nasi Goreng Biasa - Rp 8,000");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1/2/3): ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Masukkan jumlah Nasi Goreng Pedas yang dipesan: ");
                int quantity = scanner.nextInt();
                Food nasiGorengPedas = new NasiGoreng("Nasi Goreng Pedas", 10000, true);
                salesManager.sell(nasiGorengPedas, quantity);
            } else if (choice == 2) {
                System.out.print("Masukkan jumlah Nasi Goreng Biasa yang dipesan: ");
                int quantity = scanner.nextInt();
                Food nasiGorengBiasa = new NasiGoreng("Nasi Goreng Biasa", 8000, false);
                salesManager.sell(nasiGorengBiasa, quantity);
            } else if (choice == 3) {
                System.out.println("Terima kasih telah berkunjung!");
                break;
            } else {
                System.out.println("Pilihan tidak valid, silakan pilih lagi.");
            }
        }

        scanner.close();
    }
}
