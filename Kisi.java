public class Kisi {

    private String isim, eposta;

    Kisi(String isim, String eposta){
        this.isim = isim;
        this.eposta = eposta;
    }

    public String isimGetir(){
        return isim;
    }

    public String epostaGetir(){
        return eposta;
    }

    public void isimGuncelle(String yeni_isim){
      isim = yeni_isim;
    }

    public void epostaGuncelle(String yeni_eposta){
        eposta = yeni_eposta;
    }

 @Override
    public String toString(){
        return "isim:" + isim + "-eposta:" + eposta ;
    }
}