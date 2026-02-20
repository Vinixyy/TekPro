public class Restaurant{
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }
    public void tambahMenuMakanan(String nama, double harga, int stok) {
        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.stok[id] = stok;
    }
    
    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(
                    i + ". " + nama_makanan[i] + "[" + stok[i] + "]" + "\tRp. " + harga_makanan[i] 
                );
            }
            else if (isOutOfStock(i)) {
                System.out.println(
                    i + ". " + nama_makanan[i] + "[Habis]" + "\tRp. " + harga_makanan[i] 
                );
            }
        }
    }
    
    public boolean isOutOfStock(int id) {
        if (stok[id] <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void nextId() {
        id++;
    }

    public void pesanMakanan(int id, int jumlah) {
        if (isOutOfStock(id)) {
            System.out.println("Maaf, " + nama_makanan[id] + " sudah habis.\n");
        } else if (jumlah > stok[id]) {
            System.out.println("Maaf, stok " + nama_makanan[id] + " tidak cukup.\n");
        } else {
            stok[id] -= jumlah;
            double totalHarga = harga_makanan[id] * jumlah;
            System.out.println("Total Harga: Rp. " + totalHarga + "\n");
        }
    }
}

