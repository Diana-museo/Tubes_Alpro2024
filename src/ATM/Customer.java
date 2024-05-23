/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM;

import java.util.Scanner;

/**
 *
 * @author TOSHIBA
 */
public class Customer {
        String norek;
        String nama;
        String pin;
        double saldo;

        Customer() {
        }

        Customer(String No, String Name, String Pinku, double Saldonya) {
            this.norek = No;
            this.nama = Name;
            this.pin = Pinku;
            this.saldo = Saldonya;
        }

        String getNoRek() {
            return norek;
        }

        void setNoRek(String No) {
            this.norek = No;
        }

        String getNama() {
            return nama;
        }

        void setNama(String Namaku) {
            this.nama = Namaku;
        }

        String getPin() {
            return nama;
        }

        void setPin(String Pinku) {
            this.pin = Pinku;
        }

        double getSaldo() {
            return saldo;
        }

        void setSaldo(double Saldoku) {
            this.saldo = Saldoku;
        }

        void BacaRec() {
            Scanner sc = new Scanner(System.in);
            System.out.print("No rekening: ");
            norek = sc.next();
            System.out.print("Nama: ");
            nama = sc.next();
            System.out.print("Pin: ");
            pin = sc.next();
            System.out.print("Saldo: ");
            saldo = sc.nextDouble();
        }

        void TampilRec() {
            System.out.println(norek + ", " + nama + ", " + saldo);
        }

        public static void main(String[] args) {
            Customer R = new Customer();

            R.BacaRec();
            R.TampilRec();
        }
}
