import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sporcu {
    private int sporcuId;
    private String adSoyad;
    private int yas;
    private double boyCm;
    private double kiloKg;
    private Cinsiyet cinsiyet;
    private Map<LocalDate,Antrenman> antrenmanKayitlari = new HashMap<>();
    private BeslenmeHedefi beslenmeHedefi;
    private AktiviteSeviyesi aktiviteSeviyesi;
    private Map<LocalDate,GunlukBeslenme> sporcuBeslenmeKayitlari = new HashMap<>();


    public boolean gunlukBeslenmeEkle(GunlukBeslenme gunlukBeslenme){
        if(sporcuBeslenmeKayitlari.containsKey(gunlukBeslenme.getTarih())){
            return false;
        }else{
            sporcuBeslenmeKayitlari.put(gunlukBeslenme.getTarih(),gunlukBeslenme);
            return  true;
        }
    }

    public  GunlukBeslenme gunlukKayitGetir(LocalDate arananTarih){
        return sporcuBeslenmeKayitlari.get(arananTarih);
    }

    public boolean gunlukBeslenmeKaydiSil(LocalDate silinecekTarih){
        if(sporcuBeslenmeKayitlari.remove(silinecekTarih)!=null){
            return true;
        }else{
            return false;
        }
    }

    public boolean gunlukBeslenmeKaydiGuncelle(GunlukBeslenme yeniGunlukBeslenme){
        LocalDate guncellenecekTarih=yeniGunlukBeslenme.getTarih();
        if(sporcuBeslenmeKayitlari.replace(guncellenecekTarih,yeniGunlukBeslenme)!=null){
            return true;
        }
        return  false;
    }


    public Sporcu(int sporcuId, String adSoyad, int yas, double boyCm, double kiloKg, Cinsiyet cinsiyet,BeslenmeHedefi beslenmeHedefi,AktiviteSeviyesi aktiviteSeviyesi) {
        this.sporcuId = sporcuId;
        this.adSoyad = adSoyad;
        this.yas = yas;
        this.boyCm = boyCm;
        this.kiloKg = kiloKg;
        this.cinsiyet = cinsiyet;
        this.beslenmeHedefi=beslenmeHedefi;
        this.aktiviteSeviyesi=aktiviteSeviyesi;
    }

    public int getSporcuId() {
        return this.sporcuId;
    }

    public String getAdSoyad() {
        return this.adSoyad;
    }

    public int getYas() {
        return this.yas;
    }

    public double getBoyCm() {
        return this.boyCm;
    }

    public double getKiloKg() {
        return this.kiloKg;
    }

    public Cinsiyet getCinsiyet() {
        return this.cinsiyet;
    }

    public BeslenmeHedefi getBeslenmeHedefi(){ return this.beslenmeHedefi; }

    public AktiviteSeviyesi getAktiviteSeviyesi(){ return this.aktiviteSeviyesi; }

    public boolean antrenmanEkle(Antrenman antrenman){
        LocalDate antrenmanTarihi=antrenman.getTarih();
        if(antrenmanKayitlari.containsKey(antrenmanTarihi)){
            return false;
        }else{
            antrenmanKayitlari.put(antrenmanTarihi,antrenman);
            return true;
        }
    }

    public double toplamHacimHesapla(){
        double toplamHacim=0;
        for(Antrenman antrenman : antrenmanKayitlari.values()){
            toplamHacim+=antrenman.toplamHacimHesapla();
        }
        return toplamHacim;
    }

    public Antrenman antrenmanKaydiGetir(LocalDate arananAntrenmanTarihi){
        return antrenmanKayitlari.get(arananAntrenmanTarihi);
    }

    public boolean antrenmanSil(LocalDate silinecekAntrenmanTarihi){
        if(antrenmanKayitlari.remove(silinecekAntrenmanTarihi)!=null){
            return true;
        }
        return false;
    }

    public boolean antrenmanGuncelle(Antrenman guncellenecekAntrenman){
        if(antrenmanKayitlari.replace(guncellenecekAntrenman.getTarih(),guncellenecekAntrenman)!=null){
            return true;
        }
        return false;
    }

}
