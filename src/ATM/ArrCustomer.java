
package ATM;

import java.util.Scanner;

public class ArrCustomer {

    int N = 4;
    Customer[] a = new Customer[N];

    void IsiArray() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            System.out.println("A[" + i + "]: ");
            Customer R = new Customer();
            R.BacaRec();
            a[i] = R;
            System.out.println("");
        }
    }

    void TampilArray() {
        for (int i = 0; i < N; i++) {
            System.out.println("A[" + i + "]: ");
            a[i].TampilRec();
        }
    }

    void CekSaldo(int i) {
        a[i].TampilRec();
    }

    void Pengambilan(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Saldo yang ingin ditarik : ");
        double X = sc.nextDouble();
        a[i].saldo = a[i].saldo - X;

        a[i].TampilRec();
    }

    void Setor(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Saldo yang ingin disetorkan : ");
        double X = sc.nextDouble();
        a[i].saldo = a[i].saldo + X;
        
        a[i].TampilRec();
    }
    
    void Transfer(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nomor rekening tujuan anda : ");
        String norekTujuan = sc.next();
        System.out.print("Jumlah yang ingin ditransfer : ");
        double jumlahTransfer = sc.nextDouble();

        boolean bertemu = false;
        int indexTujuan = -1;

        for (int j = 0; j < N; j++) {
            if (a[j].norek.equals(norekTujuan)) {
                    bertemu = true;
                    indexTujuan = j;
                    break;
            }
        }

        if (bertemu) {
                if (a[i].saldo >= jumlahTransfer) {
                        a[i].saldo -= jumlahTransfer;
                        a[indexTujuan].saldo += jumlahTransfer;
                        System.out.println("");
                        System.out.println("Transfer berhasil : ");
                        System.out.println("Saldo pengirim : ");
                        a[i].TampilRec();
                        System.out.println("");
                        System.out.println("Saldo penerima : ");
                        a[indexTujuan].TampilRec();
                } else {
                        System.out.println("Saldo tidak mencukupi untuk melakukan transaksi : ");
                }
        } else {
                    System.out.println("Nomor rekening tujuan tidak ditemukan : ");
        }
        
        a[i].TampilRec();
    }

    int Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Menu: ");
        System.out.println("1. Tampil Array ");
        System.out.println("2. Pengambilan ");
        System.out.println("3. Setor ");
        System.out.println("4. Transfer ");
        System.out.println("5. Cek Saldo ");
        System.out.println("0. Keluar ");
        System.out.print("Pilihan anda ");
        int X = sc.nextInt();
        System.out.println("");
        return X;
    }

    int Login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("- Silakan Login di bawah ini -");
        System.out.println("");
        System.out.print("Norek: ");
        String norek = sc.next();
        boolean ketemu;
        int i;
        int ulang = 1;
        do {
            System.out.print("Pin: ");
            String pinku = sc.next();
            i = 0;
            ketemu = false;
            while ((ketemu == false) && (i < N)) {
                if ((a[i].norek.equals(norek))
                        && (a[i].pin.equals(pinku))) {
                    ketemu = true;
                } else {
                    i++;
                }
            }
            ulang++;
        } while ((ketemu == false) && (ulang <= 3));
        if (ketemu == true) {
            System.out.print("Selamat Datang: ");
            a[i].TampilRec();
            return i;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        ArrCustomer A = new ArrCustomer();

        int active; //index customer yang login
        A.IsiArray();
        active = A.Login();
        if (active != -1) {
            int pilih = A.Menu();
            while (pilih != 0) {
                switch (pilih) {
                    case 1:
                        A.TampilArray();
                        break;
                    case 2:
                        A.Pengambilan(active);
                        break;
                    case 3:
                        A.Setor(active);
                        break;
                    case 4:
                        A.Transfer(active);
                        break;
                    case 5:
                        A.CekSaldo(active);
                        break;
                    case 0:
                        System.exit(pilih);
                        break;
                    default:
                        System.out.print("Pilihan salah! ");
                }
                pilih = A.Menu();
            }
        }
    }
}
