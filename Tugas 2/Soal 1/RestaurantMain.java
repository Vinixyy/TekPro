import java.util.Scanner;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();
        Scanner input = new Scanner(System.in);
        
        menu.tambahMenuMakanan("Pizza", 250000, 20);
        Restaurant.nextId();
        
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        Restaurant.nextId();
        
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        Restaurant.nextId();
        
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);
        
        while (true) {
            menu.tampilMenuMakanan();   
            System.out.print("Masukkan nomor makanan yang ingin dipesan: ");
            int id = input.nextInt();
            System.out.print("Masukkan jumlah pesanan: ");
            int jumlah = input.nextInt();
            menu.pesanMakanan(id, jumlah);
        }
        
    }
}


