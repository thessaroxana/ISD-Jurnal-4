package thessarx;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            LinkedList<PlayerList> playerLists = new LinkedList<PlayerList>();
//        playerLists.addLast(new PlayerList("pelangi", "anak-anak"));
//        playerLists.addLast(new PlayerList("pelangi2", "anak-anak"));
//        playerLists.addLast(new PlayerList("pelangi3", "anak-anak"));
            Scanner scanner = new Scanner(System.in);

            boolean kondisi = true;
            while (kondisi){
                menu();
                switch (scanner.nextInt()){
                    case 1:
                        String judulLagu = scanner.next();
                        String namaPenyanyi = scanner.next();
                        playerLists.addLast(new PlayerList(judulLagu, namaPenyanyi));
                        break;
                    case 2:
                        System.out.println("1. Hapus sesuai judul");
                        System.out.println("2. Hapus yang terakhir");
                        if(scanner.nextInt() == 1){
                            removeWithJudul(playerLists, scanner.next());
                        }else {
                            playerLists.removeLast();
                        }
                        break;
                    case 3:
                        print(playerLists);
                        break;
                    default:
                        kondisi = false;
                        break;
                }
            }


        }

        public static void print(LinkedList playerLists){
            ListIterator<PlayerList> iterator = playerLists.listIterator();

            while (iterator.hasNext()){
                System.out.print(iterator.next());
                if(iterator.hasNext()){
                    System.out.print(" - ");
                }
            }

            System.out.println();

            while (iterator.hasPrevious()){
                System.out.print(iterator.previous());
                if(iterator.hasPrevious()){
                    System.out.print(" - ");
                }
            }

            System.out.println("\n ---- habis ----");
        }

        public static void removeWithJudul(LinkedList playerLists, String judul){
            ListIterator<PlayerList> iterator = playerLists.listIterator();
            while (iterator.hasNext()){
                PlayerList playerList = iterator.next();
                if(playerList.getJudulLagu().equals(judul)){
                    iterator.remove();
                    System.out.println("--- berhasil hapus ---");
                }
            }
        }

        public static void menu(){
            System.out.println("menu player list");
            System.out.println("1. Input lagu");
            System.out.println("2. Hapus lagu");
            System.out.println("3. Mainkan lagu");
            System.out.println("4 Keluar");
        }
    }

