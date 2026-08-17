import java.util.ArrayList;
import java.util.List;

public class Ogun {
    private OgunTuru ogunTuru;

    private List<BesinPorsiyonu> besinPorsiyonuListesi = new ArrayList<>();

    public Ogun(OgunTuru ogunTuru){ this.ogunTuru=ogunTuru;}

    public OgunTuru getOgunTuru(){return this.ogunTuru; }

    public void besinPorsiyonuEkle(BesinPorsiyonu besinPorsiyonu){
        besinPorsiyonuListesi.add(besinPorsiyonu);
    }

    public double toplamKaloriHesapla(){
        double toplamKalori=0;
        for(BesinPorsiyonu besinPorsiyonu : besinPorsiyonuListesi){
            toplamKalori += besinPorsiyonu.besinKaloriHesapla();

        }
        return toplamKalori;
    }

    public double toplamProteinHesapla(){
        double toplamProtein=0;
        for(BesinPorsiyonu besinPorsiyonu : besinPorsiyonuListesi){
            toplamProtein+=besinPorsiyonu.besinProteinHesapla();
        }
        return toplamProtein;
    }
    public double toplamYagHesapla(){
        double toplamYag=0;
        for(BesinPorsiyonu besinPorsiyonu : besinPorsiyonuListesi){
            toplamYag+=besinPorsiyonu.besinYagHesapla();
        }
        return toplamYag;
    }
    public double toplamKarbHesapla(){
        double toplamKarb=0;
        for(BesinPorsiyonu besinPorsiyonu : besinPorsiyonuListesi){
            toplamKarb+=besinPorsiyonu.besinKarbHesapla();
        }
        return toplamKarb;
    }

}
