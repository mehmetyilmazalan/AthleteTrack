import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AthleteTrackApplication {
private static final double tolerans=0.01;

    public static void main(String[] args) {

        Antrenman antrenman1 = new Antrenman(LocalDate.now());

        Hareket latPulldown  = new Hareket(HareketAdi.LAT_PULLDOWN);
        HareketSeti latPulldownSeti1 =new HareketSeti(40,12);
        HareketSeti latPulldownSeti2 =new HareketSeti(45,10);
        latPulldown.setEkle(latPulldownSeti1);
        latPulldown.setEkle(latPulldownSeti2);

        Hareket seatedRow  = new Hareket(HareketAdi.SEATED_ROW);
        HareketSeti seatedRowSeti1 =new HareketSeti(50,10);
        HareketSeti seatedRowSeti2 =new HareketSeti(55,8);
        seatedRow.setEkle(seatedRowSeti1);
        seatedRow.setEkle(seatedRowSeti2);

        antrenman1.hareketEkle(latPulldown);
        antrenman1.hareketEkle(seatedRow);

        System.out.println("Antrenman 1 Hacmi : "+ antrenman1.toplamHacimHesapla());


        Sporcu sporcu1 =new Sporcu(1,"Mehmet Alan",25,184,75,
                Cinsiyet.ERKEK,BeslenmeHedefi.KAS_KAZANIMI,AktiviteSeviyesi.ORTA_AKTIF);
        sporcu1.antrenmanEkle(antrenman1);
        System.out.println("Sporcunun Toplam Antrenman Hacmi : "+sporcu1.toplamHacimHesapla());



        BeslenmeHesaplayici beslenmeHesaplayici = new BeslenmeHesaplayici();
        System.out.println ("Sporcunun Temel Kalorisi : "+beslenmeHesaplayici.temelKaloriHesapla(sporcu1));
        System.out.println("Sporcunun Aktivite Sonrası Kalorisi: "+ beslenmeHesaplayici.aktiviteKalorisiHesapla(sporcu1));
        System.out.println("Sporcunun Hedef Kalorisi: "+ beslenmeHesaplayici.hedefKaloriHesapla(sporcu1));
        System.out.println("Sporcunun Günlük Protein İhtiyacı : "+ beslenmeHesaplayici.hedefProteinHesapla(sporcu1));



        Besin besin1 = new Besin("Yulaf",370,60,13,7);
        BesinPorsiyonu besinPorsiyonu1 = new BesinPorsiyonu(80,besin1);
        System.out.println("Besinin Kalorisi: "+besinPorsiyonu1.besinKaloriHesapla());
        System.out.println("Besinin Karbonhidratı : "+besinPorsiyonu1.besinKarbHesapla());
        System.out.println("Besinin Proteini : "+besinPorsiyonu1.besinProteinHesapla());
        System.out.println("Besinin Yağı : "+besinPorsiyonu1.besinYagHesapla());

        Besin besin2 = new Besin("Süt",60,4.7,3.2,3.3);
        BesinPorsiyonu besinPorsiyonu2 = new BesinPorsiyonu(200,besin2);

        Ogun ogun1 = new Ogun(OgunTuru.KAHVALTI);
        ogun1.besinPorsiyonuEkle(besinPorsiyonu1);
        ogun1.besinPorsiyonuEkle(besinPorsiyonu2);
        System.out.println("Öğün 1 toplam kalorisi : "+ogun1.toplamKaloriHesapla());
        System.out.println("Öğün 1 toplam protein Miktarı  : "+ogun1.toplamProteinHesapla());
        System.out.println("Öğün 1 toplam Yağ Miktarı  : "+ogun1.toplamYagHesapla());
        System.out.println("Öğün 1 toplam Karbonhidrat Miktarı  : "+ogun1.toplamKarbHesapla());


        Besin besin3 = new Besin("Tavuk Göğsü",165,0,31,3.6);
        BesinPorsiyonu besinPorsiyonu3 = new BesinPorsiyonu(200,besin3);

        Ogun ogun2=new Ogun(OgunTuru.AKSAM_YEMEGI);
        ogun2.besinPorsiyonuEkle(besinPorsiyonu3);


        GunlukBeslenme gunlukBeslenme1 = new GunlukBeslenme(LocalDate.of(2026,8,14));
        gunlukBeslenme1.ogunEkle(ogun1);
        gunlukBeslenme1.ogunEkle(ogun2);

        System.out.println("tarih : "+gunlukBeslenme1.getTarih()+"\n");
        System.out.println("Günlük alınan kalori : "+gunlukBeslenme1.gunlukKaloriHesapla());
        System.out.println("toplam protein Miktarı  : "+gunlukBeslenme1.gunlukProteinHesapla());
        System.out.println("toplam Yağ Miktarı  : "+gunlukBeslenme1.gunlukYagHesapla());
        System.out.println("toplam Karbonhidrat Miktarı  : "+gunlukBeslenme1.gunlukKarbHesapla());


        BeslenmeRaporu beslenmeRaporu = new BeslenmeRaporu(sporcu1,gunlukBeslenme1,beslenmeHesaplayici);
        hedefSonucunuYazdir(beslenmeRaporu.kaloriFarkiHesapla(),"Kalori","kalori");
        hedefSonucunuYazdir(beslenmeRaporu.proteinFarkiHesapla(),"Protein","gram");


        GunlukBeslenme gunlukBeslenme2 = new GunlukBeslenme(LocalDate.of(2026,8,1));
        GunlukBeslenme gunlukBeslenme3 = new GunlukBeslenme(LocalDate.of(2026,8,2));

        System.out.println(sporcu1.gunlukBeslenmeEkle(gunlukBeslenme1));
        System.out.println(sporcu1.gunlukBeslenmeEkle(gunlukBeslenme2));
        System.out.println(sporcu1.gunlukBeslenmeEkle(gunlukBeslenme3));

        GunlukBeslenme gunlukBeslenme4=new GunlukBeslenme(LocalDate.of(2026,8,1));
        gunlukBeslenme4.ogunEkle(ogun1);
        gunlukBeslenme4.ogunEkle(ogun2);
        //Beslenme İşlemleri

        //Güncelleme
        boolean kayitGuncellendiMi=sporcu1.gunlukBeslenmeKaydiGuncelle(gunlukBeslenme4);
        if(kayitGuncellendiMi){
            System.out.println("Kayıt Güncellendi");
            System.out.println("Güncelleme sonrası dönen kalori: "+sporcu1.gunlukKayitGetir(LocalDate.of(2026,8,1)).gunlukKaloriHesapla());
        }else{
            System.out.println("Güncellenecek Kayıt Bulunamadı.");
        }

        //SPORCU İŞLEMLERİ
        //Kayıt Ekleme

        Sporcu sporcu2=new Sporcu(2,"Leo Messi",39,180,85,Cinsiyet.ERKEK,BeslenmeHedefi.KAS_KAZANIMI,AktiviteSeviyesi.COK_AKTIF);
        Sporcu sporcu3=new Sporcu(2,"Leo Messi",39,180,85,Cinsiyet.ERKEK,BeslenmeHedefi.KAS_KAZANIMI,AktiviteSeviyesi.COK_AKTIF);
        SporcuYonetimi sporcuYonetimi = new SporcuYonetimi();
        sporcuYonetimi.sporcuEkle(sporcu2);
        if(sporcuYonetimi.sporcuEkle(sporcu3)){
            System.out.println("Sporcu Başarıyla Eklendi."+"\n"+"Eklenen sporcu Id si : "+sporcu3.getSporcuId()+"\n"+"Eklenen sporcu ad-soyad : "+sporcu3.getAdSoyad());
        }else{
            System.out.println("Bu ıd ile kayıtlı olan sporcu var ! ");
        }


        Sporcu bulunanSporcu1=sporcuYonetimi.idIleSporcuGetir(2);
        if(bulunanSporcu1!=null){
            System.out.println("Sporcu Ad - Soyad : "+ bulunanSporcu1.getAdSoyad());
        }else{
            System.out.println(bulunanSporcu1);
        }

        boolean sporcuSilindiMi1=sporcuYonetimi.sporcuSil(2);
        if(sporcuSilindiMi1){
            System.out.println("Kayıt başarıyla silindi");
        }else{
            System.out.println("Silinecek kayıt bulunamadı !");
        }

        Sporcu bulunanSporcu2=sporcuYonetimi.idIleSporcuGetir(2);
        if(bulunanSporcu2!=null){
            System.out.println("Sporcu Ad - Soyad : "+ bulunanSporcu2.getAdSoyad());
        }else{
            System.out.println(bulunanSporcu2);
        }

        boolean sporcuSilindiMi2=sporcuYonetimi.sporcuSil(2);
        if(sporcuSilindiMi2){
            System.out.println("Kayıt başarıyla silindi");
        }else{
            System.out.println("Silinecek kayot bulunamadı !");
        }

        Sporcu sporcu4=new Sporcu(4,"CR7",41,186,80,Cinsiyet.ERKEK,BeslenmeHedefi.KAS_KAZANIMI,AktiviteSeviyesi.ORTA_AKTIF);
        sporcuYonetimi.sporcuEkle(sporcu4);
        Sporcu sporcuYeni4=new Sporcu(4,"MYA",25,184,76,Cinsiyet.ERKEK,BeslenmeHedefi.KAS_KAZANIMI,AktiviteSeviyesi.COK_AKTIF);
        boolean guncellendiMi=sporcuYonetimi.sporcuGuncelle(sporcuYeni4);
        if(guncellendiMi){
            System.out.println("Güncelleme Başarılı"+"\n"+"Eski Kayıt Ad - Soyad : "+sporcu4.getAdSoyad()+"\n"+"Güncel Kayıt Ad-Soyad :"+sporcuYeni4.getAdSoyad());
        }else{
            System.out.println("Güncellenecek ID ye kayıtlı bir sporcu bulunamadı.");
        }

        Sporcu bulunanSporcu3=sporcuYonetimi.idIleSporcuGetir(4);
        if(bulunanSporcu3!=null){
            System.out.println("Sporcu Ad - Soyad : "+ bulunanSporcu3.getAdSoyad());
        }else{
            System.out.println(bulunanSporcu3);
        }


        Sporcu sporcu6=new Sporcu(6,"Orkun",25,185,80,Cinsiyet.ERKEK,BeslenmeHedefi.KILO_KORUMA,AktiviteSeviyesi.ORTA_AKTIF);
        Sporcu sporcu7=new Sporcu(7,"OH",23,1887,80,Cinsiyet.ERKEK,BeslenmeHedefi.KAS_KAZANIMI,AktiviteSeviyesi.ORTA_AKTIF);
        Sporcu sporcu8=new Sporcu(8,"Salih",28,186,80,Cinsiyet.ERKEK,BeslenmeHedefi.KAS_KAZANIMI,AktiviteSeviyesi.ORTA_AKTIF);
        Sporcu sporcu9=new Sporcu(9,"Trossard",31,180,80,Cinsiyet.ERKEK,BeslenmeHedefi.KAS_KAZANIMI,AktiviteSeviyesi.ORTA_AKTIF);
        Sporcu sporcu10=new Sporcu(10,"Nübel",29,188,80,Cinsiyet.ERKEK,BeslenmeHedefi.KAS_KAZANIMI,AktiviteSeviyesi.ORTA_AKTIF);
        Sporcu sporcu11=new Sporcu(11,"Emirhan",26,187,80,Cinsiyet.ERKEK,BeslenmeHedefi.KAS_KAZANIMI,AktiviteSeviyesi.ORTA_AKTIF);
        sporcuYonetimi.sporcuEkle(sporcu6);
        sporcuYonetimi.sporcuEkle(sporcu7);
        sporcuYonetimi.sporcuEkle(sporcu8);
        sporcuYonetimi.sporcuEkle(sporcu9);
        sporcuYonetimi.sporcuEkle(sporcu10);
        sporcuYonetimi.sporcuEkle(sporcu11);

        List<Sporcu> sporcuListesi=sporcuYonetimi.getSporcuKayitlari();

        for(Sporcu sporcu : sporcuListesi){
            System.out.println("Sporcu ID :"+sporcu.getSporcuId()+"\n"
                    +"Sporcu Ad - Soyad : "+sporcu.getAdSoyad());
        }


        GunlukBeslenme gunlukBeslenme5 =new GunlukBeslenme(LocalDate.of(2026,8,17));
        gunlukBeslenme5.ogunEkle(ogun1);
        gunlukBeslenme5.ogunEkle(ogun2);
        sporcu6.gunlukBeslenmeEkle(gunlukBeslenme5);

        BeslenmeRaporServisi servis = new BeslenmeRaporServisi(sporcuYonetimi,beslenmeHesaplayici);
        BeslenmeRaporu sonuc = servis.beslenmeRaporuGetir(6,LocalDate.of(2026,8,17));


        if (sonuc == null) {
            System.out.println("Beslenme raporu oluşturulamadı.");
        } else {
            hedefSonucunuYazdir(
                    sonuc.kaloriFarkiHesapla(),
                    "Kalori",
                    "kalori"
            );

            hedefSonucunuYazdir(
                    sonuc.proteinFarkiHesapla(),
                    "Protein",
                    "gram"
            );
        }


        Antrenman antrenman2=new Antrenman(LocalDate.of(2026,8,17));
        Antrenman antrenman3=new Antrenman(LocalDate.of(2026,8,17));
        sporcu6.antrenmanEkle(antrenman2);
        if(sporcu6.antrenmanEkle(antrenman3)){
            System.out.println("Antrenman eklendi");
        }else{
            System.out.println(antrenman2.getTarih()+" tarihinde antrenman kaydı vardır.");
        }

        Antrenman antrenmanKontrol=sporcu6.antrenmanKaydiGetir(LocalDate.of(2026,8,17));
        if(antrenmanKontrol!=null){
            System.out.println(antrenmanKontrol.getTarih());
        }else{
            System.out.println("Aranan tarihte kayıt bulunamadı!");
        }

        LocalDate testTarihi = LocalDate.of(2026, 9, 1);
        Antrenman silmeTestAntrenmani = new Antrenman(testTarihi);

        boolean eklendiMi = sporcu6.antrenmanEkle(silmeTestAntrenmani);
        System.out.println("Antrenman eklendi mi: " + eklendiMi);


        boolean ilkSilmeSonucu = sporcu6.antrenmanSil(testTarihi);
        System.out.println("İlk silme başarılı mı: " + ilkSilmeSonucu);


        Antrenman silmeSonrasiKayit = sporcu6.antrenmanKaydiGetir(testTarihi);

        if (silmeSonrasiKayit == null) {
            System.out.println("Silme sonrası kayıt bulunamadı.");
        } else {
            System.out.println("HATA: Kayıt hâlâ sistemde bulunuyor.");
        }

        boolean ikinciSilmeSonucu = sporcu6.antrenmanSil(testTarihi);
        System.out.println("İkinci silme başarılı mı: " + ikinciSilmeSonucu);

        Antrenman antrenman5=new Antrenman(LocalDate.of(2026,7,9));
        antrenman5.hareketEkle(latPulldown);

        Antrenman antrenman6=new Antrenman(LocalDate.of(2026,7,9));
        antrenman6.hareketEkle(seatedRow);

        sporcu10.antrenmanEkle(antrenman5);
        boolean antrenmanGuncellendiMi =sporcu10.antrenmanGuncelle(antrenman6);
        if(antrenmanGuncellendiMi){
            Antrenman guncelAntrenman=sporcu10.antrenmanKaydiGetir(LocalDate.of(2026,7,9));
            System.out.println("Güncellenen antrenman hacmi : "+ guncelAntrenman.toplamHacimHesapla());
        }else{
            System.out.println("Antrenman güncellenemedi");
        }


        Antrenman antrenman7=new Antrenman(LocalDate.of(2026,7,20));
        antrenman7.hareketEkle(latPulldown);

        Antrenman antrenman8=new Antrenman(LocalDate.of(2026,7,25));
        antrenman8.hareketEkle(seatedRow);

        sporcu8.antrenmanEkle(antrenman7);
        sporcu8.antrenmanEkle(antrenman8);

        AntrenmanRaporServisi antrenmanRaporServisi = new AntrenmanRaporServisi(sporcuYonetimi);

        Double hacimFarki=antrenmanRaporServisi.toplamHacimFarkiHesapla(8,
                LocalDate.of(2026,7,20)
                ,LocalDate.of(2026,7,25));

        if (hacimFarki == null) {
            System.out.println("Sporcu veya antrenman kayıtlarından biri bulunamadı.");
        } else if (hacimFarki > 0) {
            System.out.println("Antrenman hacmi " + hacimFarki + " arttı.");
        } else if (hacimFarki < 0) {
            System.out.println("Antrenman hacmi " + Math.abs(hacimFarki) + " azaldı.");
        } else {
            System.out.println("Antrenman hacmi değişmedi.");
        }

        Hareket eskiLatPulldown = new Hareket(HareketAdi.LAT_PULLDOWN);
        eskiLatPulldown.setEkle(new HareketSeti(40, 10));
        eskiLatPulldown.setEkle(new HareketSeti(45, 8));

        Antrenman eskiAntrenman =
                new Antrenman(LocalDate.of(2026, 9, 10));

        eskiAntrenman.hareketEkle(eskiLatPulldown);


        Hareket yeniLatPulldown = new Hareket(HareketAdi.LAT_PULLDOWN);
        yeniLatPulldown.setEkle(new HareketSeti(45, 10));
        yeniLatPulldown.setEkle(new HareketSeti(50, 8));

        Antrenman yeniAntrenman =
                new Antrenman(LocalDate.of(2026, 9, 17));

        yeniAntrenman.hareketEkle(yeniLatPulldown);


        sporcu8.antrenmanEkle(eskiAntrenman);
        sporcu8.antrenmanEkle(yeniAntrenman);


        AntrenmanRaporServisi antrenmanRaporServisi2 =
                new AntrenmanRaporServisi(sporcuYonetimi);

        Double hareketHacimFarki =
                antrenmanRaporServisi2.hareketHacimFarkiHesapla(
                        8,
                        LocalDate.of(2026, 9, 10),
                        LocalDate.of(2026, 9, 17),
                        HareketAdi.LAT_PULLDOWN
                );


        if (hareketHacimFarki == null) {
            System.out.println("Sporcu, antrenman veya hareket kaydı bulunamadı.");
        } else if (hareketHacimFarki > 0) {
            System.out.println(
                    "LAT_PULLDOWN hacmi " + hareketHacimFarki + " arttı."
            );
        } else if (hareketHacimFarki < 0) {
            System.out.println(
                    "LAT_PULLDOWN hacmi "
                            + Math.abs(hareketHacimFarki)
                            + " azaldı."
            );
        } else {
            System.out.println("LAT_PULLDOWN hacmi değişmedi.");
        }

        /*

        //Mevcut kayıt arama işlemi testi
        LocalDate arananTarih=LocalDate.of(2026,8,4);
        GunlukBeslenme bulunanKayit= sporcu1.gunlukKayitGetir(arananTarih);
        if(bulunanKayit==null){
            System.out.println("KAYIT BULUNAMADI !");
        }else{
            System.out.println("Tarih : "+bulunanKayit.getTarih() + "\n" +"Alınan Kalori : " +bulunanKayit.gunlukKaloriHesapla());
        }


        LocalDate silinecekTarih=LocalDate.of(2026,8,4);
        boolean silinenKayit=sporcu1.gunlukBeslenmeKaydiSil(silinecekTarih);
        if(silinenKayit){
            System.out.println("Kayıt başarıyla silindi");
        }else {
            System.out.println("Silinecek Kayıt Bulunamadı.");
        }

        LocalDate silinecekTarih2=LocalDate.of(2026,8,4);
        boolean silinenKayit2=sporcu1.gunlukBeslenmeKaydiSil(silinecekTarih2);
        if(silinenKayit2){
            System.out.println("Kayıt başarıyla silindi");
        }else {
            System.out.println("Silinecek Kayıt Bulunamadı.");
        }
        System.out.println(sporcu1.gunlukKayitGetir(arananTarih));




         */

    }


    private static void hedefSonucunuYazdir(double fark,String hedefAdi,String birim){

        if(Math.abs(fark)<tolerans){
            System.out.println(hedefAdi+" hedefine Ulaşıldı.");

        } else if (fark>0) {
            System.out.println("Hedefe kalan "+ hedefAdi +": "+Math.abs(fark)+" "+birim+".");

        }else{
            System.out.println(hedefAdi+" hedef aşımı: "+Math.abs(fark) +" "+birim+".");

        }


    }

}
