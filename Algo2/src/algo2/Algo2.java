/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo2;



/**
 *
 * @author asus **/

   
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Algo2 {

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File("C:\\Users\\asus\\Desktop\\Kurum.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(input.nextLine(), ",");


        int akademisyenSayisi = Integer.parseInt(stringTokenizer.nextToken());

        String[] akademisyenIsımleri = new String[akademisyenSayisi];

        int count = stringTokenizer.countTokens();

        for (int i = 0; i < count; i++) {
            akademisyenIsımleri[i] = stringTokenizer.nextToken();
        }

        int[][] genelListe = new int[200][akademisyenSayisi];
        Student[] studentList = new Student[200];

        while (input.hasNext()) {
            Student newStudent = null;

            stringTokenizer = new StringTokenizer(input.nextLine(), ",");

            String cesit = stringTokenizer.nextToken();

            if (cesit.equals("u")) {
                newStudent = new UnderGraduate(Integer.parseInt(stringTokenizer.nextToken()),
                        stringTokenizer.nextToken(), stringTokenizer.nextToken(),
                         stringTokenizer.nextToken());

                stringTokenizer = new StringTokenizer(input.nextLine(), ",");

                for (int i = 0; i < akademisyenSayisi; i++) {
                    genelListe[Student.getCounter() - 1][i] = Integer.parseInt(stringTokenizer.nextToken());
                }

            } else {
                newStudent = new Graduate(Integer.parseInt(stringTokenizer.nextToken()),
                        stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(),
                        stringTokenizer.nextToken());

                stringTokenizer = new StringTokenizer(input.nextLine(), ",");
                for (int i = 0; i < akademisyenSayisi; i++) {
                    genelListe[Student.getCounter() - 1][i] = Integer.parseInt(stringTokenizer.nextToken());
                }

            }
            studentList[Student.getCounter() - 1] = newStudent;
        }


//      1)
        System.out.println("Her bir akademisyene ait ortalama dercelendirme puanları: \n");
        Tools.ortalamaDerece(genelListe,akademisyenIsımleri,studentList,"S");
//      2)
        System.out.println("\nHer bir akademisyen için lisans öğrencilerinin ortalama puanları: \n");
        Tools.ortalamaDerece(genelListe,akademisyenIsımleri,studentList,"UG");
//      3)
        System.out.println("\nHer bir akademisyen için lisansüstü öğrencilerin ortalama puanları: \n");
        Tools.ortalamaDerece(genelListe,akademisyenIsımleri,studentList,"G");
//      4)
        System.out.println("\nHer bir akademisyen için lisans öğrencilerinden izlediği patika yapay zeka olan öğrencilerin ortalama puanları: \n");
        Tools.ortalamaDerece(genelListe,akademisyenIsımleri,studentList,"YZ");
        System.out.println();
//      5)
        Tools.ortalamaAlti(genelListe,akademisyenIsımleri,studentList,"UG");
//      6)
        Tools.ortalamaAlti(genelListe,akademisyenIsımleri,studentList,"G");

        int klavyeGiris = Student.getCounter();//Klavyeden girilecek Customer nesnelerinin başlangıç indeksi olacak.

//      7)

        while(Student.getCounter() <200){

//          a) Klavyeden yeni kullanıcılar oluşturulur, sonra her bir kullanıcı için ürün puanlamaları alınır:

            int indeks = Student.getCounter();
            studentList[indeks] = Tools.musteriOlustur();

            System.out.println("Oluşturulan öğrenci için; ");
            for (int i = 0; i < akademisyenSayisi - 1; i++){
                System.out.print((i+1) + ". akademisyen puanlamasını giriniz: ");
                genelListe[indeks][i] = Tools.getSpesifikNumara("Derece");
            }

//          b) En son ürün puanı önceden puan vermiş kullanıcıların puanları kullanılarak hesaplanır:
            int min = 1000;
            double aynıBenzerlikSayac = 0.0;
            int esitSayisi = 0;
            for (int i = 0; i < indeks; i++){

                int benzerlikDegeri = 0;

                for(int j = 0; j < akademisyenSayisi - 1; j++){
                    benzerlikDegeri += Tools.mutlakDeger(genelListe[i][j] , genelListe[indeks][j]);
                }

                if ( benzerlikDegeri < min){
                    min = benzerlikDegeri;
                    genelListe[indeks][akademisyenSayisi - 1] = genelListe[i][akademisyenSayisi - 1];
                    aynıBenzerlikSayac = genelListe[indeks][akademisyenSayisi - 1];
                    esitSayisi = 1;
                }else if( benzerlikDegeri == min){
                    esitSayisi++;
                    aynıBenzerlikSayac += genelListe[i][akademisyenSayisi - 1];
                    genelListe[indeks][akademisyenSayisi -1] = (int) Math.round(aynıBenzerlikSayac/(double)esitSayisi);


                }
            }

            String devamMi = Tools.getString("Çıkmak İçin h'ye Devam Etmek İçin Herhangi Bir Tuşa Basınız:");
            if(devamMi.equals("h") || devamMi.equals("H")){
                break;
            }
            
                
            
            
                        
                            
            
        

//      8)
//          a)Klavyeden griş yapılarak oluşturulan kullanıcıların bilgileri:
        int[][] klavyedenGirilen = new int[Student.getCounter() - klavyeGiris + 1][akademisyenSayisi];
        System.out.println("Klavyeden griş yapılarak oluşturulan kullanıcıların bilgileri:\n");
        int j = 0;
        int studentNumber = Student.getCounter();
        Student.setCounter(studentNumber - klavyeGiris);
        for (int i = klavyeGiris; i < studentNumber; i++){
            System.out.println(studentList[i]);
            for (int k = 0; k < akademisyenSayisi; k++){
                klavyedenGirilen[j][k] = genelListe[i][k];
            }
            j++;
        }
        System.out.println("\n************************************************************\n");

//          b) Klayveden girilen bilgilerle oluşturulan müşterilerin ürünlere verdiği not ortalamaları:

        Tools.ortalamaDerece(klavyedenGirilen,akademisyenIsımleri,studentList,"S");

       
        }
        }
    }


