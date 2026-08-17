import java.time.LocalDate;

public class AntrenmanRaporServisi {

    private SporcuYonetimi sporcuYonetimi;

    public AntrenmanRaporServisi(SporcuYonetimi sporcuYonetimi){
        this.sporcuYonetimi=sporcuYonetimi;
    }
    public Double toplamHacimFarkiHesapla(int sporcuId, LocalDate ilkTarih,LocalDate ikinciTarih){
        if(sporcuYonetimi.idIleSporcuGetir(sporcuId)!=null){
            Sporcu arananSporcu=sporcuYonetimi.idIleSporcuGetir(sporcuId);
            if(arananSporcu.antrenmanKaydiGetir(ikinciTarih) ==null || arananSporcu.antrenmanKaydiGetir(ilkTarih)==null){
                return null;
            }else{
                return arananSporcu.antrenmanKaydiGetir(ikinciTarih).toplamHacimHesapla()-arananSporcu.antrenmanKaydiGetir(ilkTarih).toplamHacimHesapla();
            }
     }
        return null;
    }

    public Double hareketHacimFarkiHesapla(
            int sporcuId,
            LocalDate ilkTarih,
            LocalDate ikinciTarih,
            HareketAdi hareketAdi) {

        Sporcu sporcu = sporcuYonetimi.idIleSporcuGetir(sporcuId);

        if (sporcu == null) {
            return null;
        }

        Antrenman ilkAntrenman = sporcu.antrenmanKaydiGetir(ilkTarih);
        Antrenman ikinciAntrenman = sporcu.antrenmanKaydiGetir(ikinciTarih);

        if (ilkAntrenman == null || ikinciAntrenman == null) {
            return null;
        }

        Hareket ilkHareket = ilkAntrenman.hareketGetir(hareketAdi);
        Hareket ikinciHareket = ikinciAntrenman.hareketGetir(hareketAdi);

        if (ilkHareket == null || ikinciHareket == null) {
            return null;
        }

        return ikinciHareket.toplamHacimHesapla()
                - ilkHareket.toplamHacimHesapla();
    }

}
