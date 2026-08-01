import java.util.Scanner;

public class TestUniversiteYonetimSistemi(){
   
    public static void main(String[] args){

    OgrenciYonetimSistemi OYS = new OgrenciYonetimSistemi();
    OgretimUyesiYonetimSistemi OUYS = new OgretimUyesiYonetimSistemi();
    DersYonetimSistemi DYS = new DersYonetimSistemi(OYS, OUYS);

    Scanner input = new Scanner(System.in);

    int secenek;
    do{
        System.out.println("1-ogrenci yonetim sistemi");
        System.out.println("2-ogretim uyesi yonetim sistemi");
        System.out.println("3-ders yonetim sistemi");
        System.out.println("4-programi sonlandir");
        System.out.println("bir secenek seciniz: ");
        
        secenek = input.nextInt();

        switch(secenek){
            case 1:
                yonetimSistemiBaslat(OYS, "ogrenci");
                break;
            case 2:
                yonetimSistemiBaslat(OUYS, "ogretim uyesi");
                break;
            case 3:
                yonetimSistemiBaslat(DYS);
        }

    }while(secenek != 4);
     System.out.println("univeriste yonetim sistemi programi sonlandi");
}
 

 public static void yonetimSistemiBaslat(YonetimSistemi YS, String degisecek_kelime){
    Scanner input = new Scanner(System.in);

    int secenek;
    do{
        secenek = menu(degisecek_kelime);
        switch(degisecek_kelime){
            case 1:
                 yeniKayit(YS, degisecek_kelime);
                 break;
            case 2:
                kayitGuncelle(YS, degisecek_kelime);
                break;
            case 3:
                kayitSil(YS, degisecek_kelime);
                break;
            case 4:
                kayitGoster(YS, degisecek_kelime);
                break;
            case 5:
                return;
        }
    }while(secenek != 5);
 }

  public static void DersYonetimSistemi(DersYonetimSistemi DYS){
    System.out.println("ders yonetim sistemine hos geldiniz");

    Scanner input = new Scanner(System.in);

    int secenek;
    do{
        secenek = menuDYS();

        switch(secenek){
            case 1:
                dersKayit(DYS);
                break;
            case 2:
                dersGuncelle(DYS);
                break;
            case 3:
                dersSil(DYS);
                break;
            case 4:
                dersGoster(DYS);
                break;
            case 5:
                dersOgrenciEkle(DYS);
                break;
            case 6:
                dersOgrenciCikar(DYS);
                break;
            case 7:
                dersOgretimUyesiEkle(DYS);
                break;
            case 8:
                dersOgretimUyesiDegistir(DYS);
                break;
            case 9:
                dersinTumBilgileriniGoster(DYS);
                break;
            case 10:
                return;

        }
    }while(secenek != 10);
  }

  public static void menu(String degisecek_kelime){
    Scanner input = new Scanner(System.in);

    System.out.println("yeni " + degisecek_kelime + " kayit");
    System.out.println(degisecek_kelime + " kayit guncelle");
    System.out.println(degisecek_kelime + " kayit sil");
    System.out.println(degisecek_kelime + " kayit goster");
    System.out.println("ana menuye don");
    System.out.println("bir secenek seciniz: ");
    int secenek = input.nextInt();

    return secenek;
  }

  public static void menuDYS(){
    Scanner input = new Scanner(System.in);

    System.out.println("1-yeni ders ekle");
    System.out.println("2-ders bilgileri guncelle");
    System.out.println("3-ders sil");
    System.out.println("4-tum dersleri goster");
    System.out.println("5-derse ogrenci ekle");
    System.out.println("6-dersten ogrenci cikar");
    System.out.println("7-derse ogretim uyesi ekle");
    System.out.println("8-ders ogretim uyesi degistir");
    System.out.println("9-dersin tum bilgilerini goster");
    System.out.println("10-ana menuye don");
    System.out.println("bir islem seciniz: ");
    int secenek = input.nextInt();
   
    return secenek;
  }

  public static void yeniKayit(YonetimSistemi YS, String degisecek_kelime){
    Scanner input = new Scanner(System.in);

    int no;
    String isim, eposta;
   
    System.out.println(degisecek_kelime + " nin numarasi:");
    no = input.nextInt();
    input.nextLine();

    System.out.println(degisecek_kelime + " nin ismi:");
    isim = input.nextLine();

    System.out.println(degisecek_kelime + " nin epostasi:");
    eposta = input.nextLine();

    YS.kayitEkle(no,isim,eposta);
    System.out.println();
  }

  public static void kayitGuncelle(YonetimSistemi YS, String degisecek_kelime){
    Scanner input = new Scanner(System.in);

    System.out.println("guncellenecek " + degisecek_kelime + " nin numarasi:");
    int yeni_no = input.nextInt();
    input.nextLine();

    System.out.println("guncellenecek " + degisecek_kelime + " nin ismi:");
    String yeni_isim = input.nextLine();

    System.out.println("guncellenecek " + degisecek_kelime + " nin e-postasi: ");
    String yeni_eposta = input.nextLine();

    YS.kayitGuncelle(yeni_no,yeni_isim,yeni_eposta);
    System.out.println();
  }

  public static void kayitSil(YonetimSistemi YS, String degisecek_kelime){
    Scanner input = new Scanner(System.in);

    System.out.println("kaydi silinecek" + degisecek_kelime + " nin numarasi:");
    int delete_no = input.nextInt();

    YS.kayitSil(delete_no);
    System.out.println();
  }


  public static void kayitGoster(YonetimSistemi YS, String degisecek_kelime){
    System.out.println(degisecek_kelime + " nin kayitlari listeleniyor...");
    YS.kayitListele();
    System.out.println();
  }


  public static void dersKayit(DersYonetimSistemi DYS){
    Scanner input = new Scanner(System.in);

    int yariyil,kod,kapasite;
    String ad;
    
    System.out.println("dersin kodu:");
    kod = input.nextInt();   //başta veri tutunu belirttim gerek yok
    input.nextLine(); //buffer'daki newline karakterini silmesi için

    System.out.println("dersin adi:");
    ad = input.nextLine();
    
    System.out.println("dersin yariyili:");
    yariyil = input.nextInt();
    input.nextLine();

    System.out.println("ders kapasitesi:");
    kapasite = input.nextInt();
    input.nextLine();
    
    DYS.dersEkle(kod,ad,yariyil,kapasite);
    System.out.println();
    
  }
   
  public static void dersGuncelle(DersYonetimSistemi DYS){
    Scanner input = new Scanner(System.in);

    System.out.println("guncellenecek dersin kodu: ");
    int kod = input.nextInt();  //başta belirtmedim bu nedenle veri turunu belirtmem gerek
    input.nextLine(); 

    System.out.println("guncellenecek dersin adi: ");
    String yeni_ad = input.nextLine();

    System.out.println("guncellenecek dersin yariyili: ");
    int yeni_yariyil = input.nextInt();
    input.nextLine();

    DYS.dersGuncelle(kod,ad,yariyil,kapasite);
    System.out.println();
  }

  public static void dersSil(DersYonetimSistemi DYS){
    Scanner input = new Scanner(System.in);

    System.out.println("kaydi silinecek deersin kodu: ");
    int delete_kod = input.nextInt();
    input.nextLine();

    DYS.dersSil(delete_kod);
    System.out.println();
  } 

  public static void dersGoster(DersYonetimSistemi DYS){
    System.out.println("tum ders kayitlari listeleniyor...");

    DYS.dersListele();   //kullanıcıya sormadan direkt tum listeyi direkt ekrana basma Scanner input iht yok
    System.out.println();
  }

  public static void dersOgrenciEkle(DersYonetimSistemi DYS){
   Scanner input = new Scanner(System.in);

   System.out.println("ogrenci eklenecek dersin kodu: ");
   int ders_kod = input.nextInt();
   input.nextLine();
   
   System.out.println("derse eklenecek ogrencinin numarasi: ");
   int ogrenci_no = input.nextInt();
   input.nextLine();

   DYS.dersOgrenciEkle(ders_kod,ogrenci_no);
   System.out.println();
  }

  public static void dersOgrenciCikar(DersYonetimSistemi DYS){
    Scanner input = new Scanner(System.in);

    System.out.println("ogrenci silinecek dersin kodu: ");
    int ders_kod = input.nextInt();
    input.nextLine();

    System.out.println("dersten cikarilacak ogrencinin numarasi: ");
    int ogrenci_no = input.nextInt();
    input.nextLine();

    DYS.dersOgrenciCikar(ders_kod,ogrenci_no);
    System.out.println();
  }

  public static void dersOgretimUyesiEkle(DersYonetimSistemi DYS){
    Scanner input = new Scanner(System.in);

    System.out.println("ogretim uyesi eklenecek dersin kodu: ");
    int ders_kod = input.nextInt();
    input.nextLine();

    System.out.println("derse eklenecek ogretim uyesinin sicil numarasi: ");
    int sicil_no = input.nextInt();
    input.nextLine();

    DYS.dersOgretimUyesiEkle(ders_kod,sicil_no);
    System.out.println();
  }

  public static void dersOgretimUyesiDegistir(DersYonetimSistemi DYS){
    Scanner input = new Scanner(System.in);

    System.out.println("ogretim uyesi degistirilecek dersin kodu: ");
    int ders_kod = input.nextInt();
    input.nextLine();

    System.out.println("dersi degistirlecek ogretim uyesinin sicil numarasi: ");
    int sicil_no = input.nextInt();
    input.nextLine();

    DYS.dersOgretimUyesiDegistir(ders_kod,sicil_no);
    System.out.println();
  }

  public static void dersinTumBilgileriniGoster(DersYonetimSistemi DYS){
    Scanner input = new Scanner(System.in);   //"hangi ders?" sorusunun cevabı için kalvyeden gridi almak şart
   
    System.out.println("tum bilgileri gosterilecek dersin kdounu giriniz: ");
    int ders_kod = input.nextInt();
    input.nextLine();

    DYS.dersinTumBilgileriniGoster(ders_kod);
    System.out.println();
  }

}
