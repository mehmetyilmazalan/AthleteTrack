import java.time.LocalDate;

public class BeslenmeRaporServisi {

    private SporcuYonetimi sporcuYonetimi;
    private BeslenmeHesaplayici beslenmeHesaplayici;

    public BeslenmeRaporServisi(SporcuYonetimi sporcuYonetimi, BeslenmeHesaplayici beslenmeHesaplayici) {
        this.sporcuYonetimi = sporcuYonetimi;
        this.beslenmeHesaplayici = beslenmeHesaplayici;
    }

    public BeslenmeRaporu beslenmeRaporuGetir(int sporcuId, LocalDate tarih){
        Sporcu arananSporcu=sporcuYonetimi.idIleSporcuGetir(sporcuId);
        if(arananSporcu!=null){
           GunlukBeslenme arananSporcuGunlukBeslenmesi= arananSporcu.gunlukKayitGetir(tarih);
           if(arananSporcuGunlukBeslenmesi!=null){
               BeslenmeRaporu rapor = new BeslenmeRaporu(arananSporcu,arananSporcuGunlukBeslenmesi, beslenmeHesaplayici);
               return rapor;
           }else{
               return null;
           }

        }else{
            return null;
        }
    }

}

