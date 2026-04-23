import java.util.Scanner;

class Sum {
    private long totalSum = 0;

    public synchronized void addPartialSum(long partial) {
        totalSum += partial;
    }

    public long getTotalSum() {
        return totalSum;
    }
}

public class ParallelSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Jumlah Thread: ");
        int numThreads = scanner.nextInt();

        System.out.print("Masukkan Angka Akhir: ");
        long finalNumber = scanner.nextLong();

        scanner.close();

        Sum sum = new Sum();
        Thread[] threads = new Thread[numThreads];

        long Size = finalNumber / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int threadId = i + 1;
            long start = (i * Size) + 1;
            long end = (i == numThreads - 1) ? finalNumber : (i + 1) * Size;

            threads[i] = new Thread(() -> {
                System.out.println("Thread " + threadId + " : Menjumlahkan " + start + " - " + end);
                long partialSum = 0;
                for (long j = start; j <= end; j++) {
                    partialSum += j;
                }
                System.out.println("Thread " + threadId + " : Hasil Parsial: " + partialSum);
                sum.addPartialSum(partialSum);
            });
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
            }
        }

        System.out.println("\nTotal Penjumlahan Akhir: " + sum.getTotalSum());
    }
}