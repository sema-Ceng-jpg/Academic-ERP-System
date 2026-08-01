
import java.util.Scanner;

public class TestOgrenciYonetimSistemiV1 {
   
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
    
        System.out.println("ogrenci yonetim sistemi class'indan nesne olusturuluyor..");

        OgrenciYonetimSistemiV1 OYS = new OgrenciYonetimSistemiV1();

        int ogrenci_no;
        String ogrenci_isim, ogrenci_eposta;

        for(int i=0; i<ogrenci_sayisi; i++){
            System.out.println((i+1) + " .ogrencinin numarasi: ");
            ogrenci_no = input.nextInt();
            input.nextLine();

            System.out.println((i+1) + " .ogrencinin ismi: ");
            ogrenci_isim = input.nextLine();

            System.out.println((i+1) + " .ogrencinin epostasi: ");
            ogrenci_eposta = input.nextLine();

            OYS.ogrenciEkle(ogrenci_no, ogrenci_isim, ogrenci_eposta);
            System.out.println();

        }
        
        System.out.println("ogrenciler listeleniyor..");
        OYS.ogrenciListele();
        System.out.println();

        System.out.println("guncellenecek ogrencinin numarasi: ");
        int yeni_no = input.nextInt();
        input.nextLine();

        System.out.println("guncellenecek ogrencinin ismi: ");
        String yeni_isim = input.nextLine();

        System.out.println("guncellenecek ogrencinin epostasi: ");
        String yeni_eposta = input.nextLine();
    
        OYS.ogrenciGuncelle(yeni_no, yeni_isim, yeni_eposta);
        System.out.println();


        System.out.println("ogrenciler yeniden listeleniyor...");
        OYS.ogrenciListele();

    }
    
}