import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GunlukBeslenme {
    private LocalDate tarih;
    private List<Ogun> ogunListesi = new ArrayList<>();

    public GunlukBeslenme(LocalDate tarih){this.tarih=tarih;}
    public LocalDate getTarih() {return this.tarih;}

    public void ogunEkle(Ogun ogun){ogunListesi.add(ogun);}

    public double gunlukKaloriHesapla(){
        double toplamOgunKalorisi=0;
        for(Ogun ogun : ogunListesi){
            toplamOgunKalorisi += ogun.toplamKaloriHesapla();
        }
        return toplamOgunKalorisi;
    }


    public double gunlukProteinHesapla(){
        double toplamOgunProtein=0;
        for(Ogun ogun : ogunListesi){
            toplamOgunProtein+=ogun.toplamProteinHesapla();
        }
        return toplamOgunProtein;
    }
    public double gunlukYagHesapla(){
        double toplamOgunYag=0;
        for(Ogun ogun : ogunListesi){
            toplamOgunYag+=ogun.toplamYagHesapla();
        }
        return toplamOgunYag;
    }
    public double gunlukKarbHesapla(){
        double toplamOgunKarb=0;
        for(Ogun ogun : ogunListesi){
            toplamOgunKarb+=ogun.toplamKarbHesapla();
        }
        return toplamOgunKarb;
    }


}
