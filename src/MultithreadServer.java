// Nico Abel Laia - 20215520010 | UAS PBO TI 2021

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.Scanner;
import java.util.Random;

public class MultithreadServer extends Thread {
    private BufferedReader bf;
    private String menang;
    private String[] soalArr = {"", ""};
    private String[] clueArr = {"", ""};

    MultithreadServer(BufferedReader bf) {
        this.bf = bf;
    }
    @Override
    public void run() {
        while(true) {
            try {
                System.out.print("\033[H\033[2J");
                System.out.println("Nico Abel Laia - 20215520010 | UAS PBO | TI 2021\n");
                System.out.println("Welcome to the game!");
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object

                // Baca File
                readSoal();
                readClue();
                readWinner();

                System.out.print("\033[H\033[2J");
                System.out.println("Nico Abel Laia - 20215520010 | UAS PBO | TI 2021\n");
                System.out.print("Enter username: ");

                String userName = myObj.nextLine();  // Read user input
                System.out.println("Username is: " + userName);  // Output user input

                System.out.print("\033[H\033[2J");
                System.out.println("Nico Abel Laia - 20215520010 | UAS PBO | TI 2021\n");

                // Random Soal
                Random randomNum = new Random();
                int showRand = randomNum.nextInt(2);

                System.out.println("Pemenang Terakhir adalah: " + menang);
                
                System.out.println("\nClue Soalnya adalah: "); 
                System.out.println(clueArr[showRand]);

                System.out.print("\nMasukkan jawaban anda: ");

                String jawaban = myObj.nextLine();  // Read user input

                if (new String(jawaban.toLowerCase()).equals(soalArr[showRand])) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Nico Abel Laia - 20215520010 | UAS PBO | TI 2021\n");
                    System.out.println("Selamat kamu benar");
                    writeFile(userName);
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Nico Abel Laia - 20215520010 | UAS PBO | TI 2021\n");
                    System.out.println("Maaf gagal kak");
                }


                System.out.println("\nTekan 1 untuk keluar permainan | Tekan angka lain untuk memulai ulang: ");  
                int stopProgram = myObj.nextInt();  // Read user input
                System.out.println("Stop: " + stopProgram);  // Output user input

                if (stopProgram == 1) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Nico Abel Laia - 20215520010 | UAS PBO | TI 2021\n");
                    System.out.println("Permainan Selesai Terimakasih");
                    break;
                }

            } catch (Exception e) {
                System.out.println("Client disconnected");
                break;
            }
        }
    }
    public void readSoal(){
        try{
            int hitung = 0;

            Scanner readSoal = new Scanner(new File("soalNico.txt"));
            readSoal.useDelimiter(",");
            String soal;

            while (readSoal.hasNext()) {
                soal = readSoal.next();
                soalArr[hitung] = soal;
                hitung++;
            }
            readSoal.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    public void readWinner(){
        try{

            Scanner readClue = new Scanner(new File("pemenang.txt"));

            while (readClue.hasNext()) {
                menang = readClue.nextLine();
            }
            readClue.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    public void readClue(){
        try{
            int hitung = 0;

            Scanner readClue = new Scanner(new File("clueNico.txt"));
            readClue.useDelimiter(",");
            String clue;

            while (readClue.hasNext()) {
                clue = readClue.next();
                clueArr[hitung] = clue;
                hitung++;
            }
            readClue.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    public void writeFile(String winner){
        try {
            FileWriter myWriter = new FileWriter("pemenang.txt");
            myWriter.write(winner);
            myWriter.close();
            System.out.println("Pemenang Terakhir Berhasil Di Update");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}

