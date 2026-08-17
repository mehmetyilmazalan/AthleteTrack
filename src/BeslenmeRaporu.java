public class BeslenmeRaporu {
    private Sporcu sporcu;
    private GunlukBeslenme gunlukBeslenme;
    private BeslenmeHesaplayici beslenmeHesaplayici;

    public BeslenmeRaporu(Sporcu sporcu, GunlukBeslenme gunlukBeslenme, BeslenmeHesaplayici beslenmeHesaplayici) {
        this.sporcu = sporcu;
        this.gunlukBeslenme = gunlukBeslenme;
        this.beslenmeHesaplayici = beslenmeHesaplayici;
    }

    public double kaloriFarkiHesapla(){
        return beslenmeHesaplayici.hedefKaloriHesapla(sporcu)-gunlukBeslenme.gunlukKaloriHesapla();
    }

    public double proteinFarkiHesapla(){
        return beslenmeHesaplayici.hedefProteinHesapla(sporcu)-gunlukBeslenme.gunlukProteinHesapla();
    }

}
