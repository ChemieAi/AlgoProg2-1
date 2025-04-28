/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by asus on 20.03.2019.
 */
public class Tools {

    public static String getString(String s) {
        System.out.print(s);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static int getInt(String s) {
        Scanner in = new Scanner(System.in);
        System.out.print(s);
        try {
            return in.nextInt();
        } catch (InputMismatchException e) {
            //System.out.println("Lütfen sayısal bir değer giriniz.");
            return getInt("Lütfen sayısal bir değer giriniz: ");
        }
    }

    public static void ortalamaDerece(int[][] list, String[] akademisyenListesi, Student[] studentList, String mod) {

        for (int j = 0; j < akademisyenListesi.length; j++) {
            int counter = 0;
            double ortalama = 0;
            if (mod.equals("S")) {
                for (int i = 0; i < Student.getCounter(); i++) {
                    counter += list[i][j];
                }
                ortalama = (double) counter / (double) Student.getCounter();
            } else if (mod.equals("UG")) {
                for (int i = 0; i < Student.getCounter(); i++) {
                    if (studentList[i] instanceof UnderGraduate) {
                        counter += list[i][j];
                    }
                }
                ortalama = (double) counter / (double) UnderGraduate.getUGCounter();
            } else if (mod.equals("G")) {
                for (int i = 0; i < Student.getCounter(); i++) {
                    if (studentList[i] instanceof Graduate) {
                        counter += list[i][j];
                    }
                }
                ortalama = (double) counter / (double) Graduate.getGCounter();
            } else if (mod.equals("Y")) {
                int YZCounter = 0;
                for (int i = 0; i < Student.getCounter(); i++) {
                    if (studentList[i] instanceof UnderGraduate) {
                        UnderGraduate UGStudent = (UnderGraduate) studentList[i];
                        if (UGStudent.getTrack().equalsIgnoreCase("Yapay Zeka")) {
                            counter += list[i][j];
                            YZCounter++;
                        }
                    }
                }
                ortalama = (double) counter / (double) YZCounter;


            }
            System.out.printf("%s adlı öğretim elemanının ortalama puanı %.1f\n", akademisyenListesi[j], ortalama);
        }
        System.out.println("\n********************************************************************************\n");
    }

    private static double ortalama(int[][] genelListe, int indeks) {
        int counter = 0;
        for (int i = 0; i < Student.getCounter(); i++) {
            counter += genelListe[i][indeks];
        }
        return (double) counter / (double) Student.getCounter();
    }

    public static void ortalamaAlti(int[][] genelListe, String[] akademisyenListesi, Student[] studentList, String mod) {
        for (int j = 0; j < akademisyenListesi.length; j++) {
            int sayac = 0;
            if (mod.equals("UG")){
                System.out.println(akademisyenListesi[j] + " akademisyenine ortalamanın altında not veren lisans öğrencileri:\n");
                System.out.println("");
            }
           
            else if (mod.equals("G")){
                System.out.println(akademisyenListesi[j] + " akademisyenine ortalamanın altında not veren lisansüstü öğrencileri:\n");
                System.out.println("");
            }
            double akademisyenOrt = ortalama(genelListe, j);
            for (int i = 0; i < studentList.length; i++) {
                if ((double) genelListe[i][j] < akademisyenOrt && studentList[i] != null) {

                    if (mod.equals("UG")) {
                        if (studentList[i] instanceof UnderGraduate) {
                            System.out.println(studentList[i]);
                            sayac ++;
                        }
                    } else if (mod.equals("G")) {
                        if (studentList[i] instanceof Graduate) {
                            System.out.println(studentList[i]);
                            sayac ++;
                        }
                    }
                }
            }
            if (sayac == 0){
                System.out.println("Hiç Bir Kullanıcı Bulunamadı.");
            }
            System.out.println("\n********************************************************************************\n");
        }
    }
    public static int mutlakDeger(int a, int b){
        if(a > b)
            return a - b;
        else
            return b - a;
    }
    public static int getSpesifikNumara(String mod){
        int deger;
        if (mod.equals("Derece")) {
            deger = getInt("");
            if (deger < 0 || deger > 5) {
                System.out.print("Lütfen 0-5 arası değerler giriniz: ");
                return getSpesifikNumara("Derece");
            } else {
                return deger;
            }
        }
        return 0;
    }
    public static Student musteriOlustur(){
        Student newStudent = null;
        String ogrenciTipi = getString("Lütfen ogrenci tipini giriniz (u/g)");
        if (ogrenciTipi.equals("u")||(ogrenciTipi.equals("UG"))){
            newStudent = new UnderGraduate(getInt("Öğrenci ID si giriniz: "),getString("Öğrenci adı giriniz: "),
                    getString("Öğrenci soyadı giriniz: "),
                    getString("Öğrencinin izlediği akademik patikayı giriniz: "));
        }else if (ogrenciTipi.equals("g") || (ogrenciTipi.equals("G"))){
            newStudent = new Graduate(getInt("Öğrenci ID si giriniz: "),getString("Öğrenci adı giriniz: "),
                    getString("Öğrenci soyadı giriniz: "), getString("Öğrencinin tez konusunu giriniz: "),
                    getString("Öğrencinin akademik danışmanını giriniz: "));
            
        }
        else{
            System.out.println("Yanlış Giriş Yaptınız Lütfen Tekrar Deneyin...");
            musteriOlustur();
           
        }
        return newStudent;
    }

}

