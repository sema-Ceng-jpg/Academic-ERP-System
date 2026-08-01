import java.util.ArrayList;

public class OgrenciYonetimSistemi {

   private ArrayList <Ogrenci> ogrenci_listesi;
 

   OgrenciYonetimSistemi(){
   
      ogrenci_listesi = new ArrayList <>();
   }

   public void kayitEkle(int ogr_no, String ogr_isim, String ogr_eposta){
     int indeks = this.ogrenciGirildiMi(ogr_no);
     if(indeks != -1){
        System.out.println("bu numarali ogrenci daha once girildi"); //yani boş donmuyor -1e eşit değil belliki girilmiş
     }else{
        ogrenci_listesi.add(new Ogrenci(ogr_no,ogr_isim,ogr_eposta));
        System.out.println("ogrenci kaydi basarili");
     }
    
   }
  
   public void kayitListele(){
     
    if(!ogrenci_listesi.isEmpty()){
        for(int i=0;i<ogrenci_listesi.size;i++){
            System.out.println(ogrenci_listesi.get(i).toString());
        }
    }else{
        System.out.println("sistemde kayitli ogrenci yoktur!");
    }  
    
   }
   
   public void kayitGuncelle(int ogr_no, String ogr_isim, String ogr_eposta){
    int indeks = this.ogrenciGirildiMi(ogr_no);

    if(indeks != -1){
       ogrenci_listesi.get(indeks).isimGetir(ogr_isim);
       ogrenci_listesi.get(indeks).epostaGetir(ogr_eposta);
       System.out.println("ogrenci basariyla guncellendi");

    }else{
        System.out.println("sistemde kayitli ogrenci bulunamadi");
    }
   }

   public void kayitSil(int ogr_no){
    int indeks = this.ogrenciGirildiMi(ogr_no);

    if(indeks != -1){  //ogrenci giris olmus demekki iste bu girileni kaldırma durumu
      ogrenci_listesi.remove(ogrenci_listesi.get(indeks));
      System.out.println("ogrenci basariyla silindi");
    }else{
        System.out.println("bu numara ile kayitli ogrenci yoktur");
    }
   }


   private int ogrenciGirildiMi(int ogr_no){
    int i;
    for(i=0; i<ogrenci_listesi.size();i++){
        if(ogrenci_listesi.get(i).ogrNoGetir == ogr_no){
            return i;
        }
        return -1;
    }
   }

   //numarası verilen ogrenciyi bulur ve nesne olarak dondurur
  private Ogrenci ogrenciGirildiMi(int ogr_no){
    int indeks = this.ogrenciGirildiMi(ogr_no);

    if(indeks != -1){
        return ogrenci_listesi.get(indeks);
    }
    return null; //ogrenci bulunamazsa null doner
  }

}