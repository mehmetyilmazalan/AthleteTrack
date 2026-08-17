import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Antrenman {
    private LocalDate tarih;
    private List<Hareket> hareketler = new ArrayList<>();

    public Antrenman(LocalDate tarih){
        this.tarih=tarih;
    }

    public LocalDate getTarih(){
        return this.tarih;
    }

    public void hareketEkle(Hareket hareket){
        hareketler.add(hareket);
    }

    public double toplamHacimHesapla(){
        double toplamAntrenmanHacmi=0;
        for( Hareket  hareket  : hareketler){
            toplamAntrenmanHacmi+=hareket.toplamHacimHesapla();
        }

        return toplamAntrenmanHacmi;
    }

    public Hareket hareketGetir(HareketAdi arananHareketAdi) {
        for (Hareket hareket : hareketler) {
            if (hareket.getHareketAdi() == arananHareketAdi) {
                return hareket;
            }
        }

        return null;
    }


}
