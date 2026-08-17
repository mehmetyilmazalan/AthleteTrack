import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AthleteTrackApplication {

    private static final double TOLERANS = 0.01;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SporcuYonetimi sporcuYonetimi = new SporcuYonetimi();
        BeslenmeHesaplayici beslenmeHesaplayici = new BeslenmeHesaplayici();

        BeslenmeRaporServisi beslenmeRaporServisi =
                new BeslenmeRaporServisi(sporcuYonetimi, beslenmeHesaplayici);

        AntrenmanRaporServisi antrenmanRaporServisi =
                new AntrenmanRaporServisi(sporcuYonetimi);

        boolean uygulamaCalisiyor = true;

        while (uygulamaCalisiyor) {

            menuyuGoster();

            int secim = intOku(scanner, "Seçiminiz: ");

            switch (secim) {

                case 1:
                    sporcuEkle(scanner, sporcuYonetimi);
                    break;

                case 2:
                    sporculariListele(sporcuYonetimi);
                    break;

                case 3:
                    antrenmanEkle(scanner, sporcuYonetimi);
                    break;

                case 4:
                    beslenmeKaydiEkle(scanner, sporcuYonetimi);
                    break;

                case 5:
                    beslenmeRaporuGoster(
                            scanner,
                            beslenmeRaporServisi
                    );
                    break;

                case 6:
                    antrenmanHacimRaporuGoster(
                            scanner,
                            antrenmanRaporServisi
                    );
                    break;

                case 7:
                    hareketHacimRaporuGoster(
                            scanner,
                            antrenmanRaporServisi
                    );
                    break;

                case 0:
                    uygulamaCalisiyor = false;
                    System.out.println("Uygulamadan çıkılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz menü seçimi!");
            }
        }

        scanner.close();
    }

    private static void menuyuGoster() {

        System.out.println();
        System.out.println("========== ATHLETE TRACK ==========");
        System.out.println("1- Sporcu ekle");
        System.out.println("2- Sporcuları listele");
        System.out.println("3- Antrenman ekle");
        System.out.println("4- Günlük beslenme kaydı ekle");
        System.out.println("5- Beslenme raporu görüntüle");
        System.out.println("6- Toplam antrenman hacmini karşılaştır");
        System.out.println("7- Hareket hacmini karşılaştır");
        System.out.println("0- Çıkış");
        System.out.println("===================================");
    }

    private static void sporcuEkle(
            Scanner scanner,
            SporcuYonetimi sporcuYonetimi) {

        System.out.println();
        System.out.println("----- SPORCU EKLEME -----");

        int sporcuId = intOku(scanner, "Sporcu ID: ");

        System.out.print("Ad soyad: ");
        String adSoyad = scanner.nextLine();

        int yas = intOku(scanner, "Yaş: ");
        double boy = doubleOku(scanner, "Boy (cm): ");
        double kilo = doubleOku(scanner, "Kilo (kg): ");

        Cinsiyet cinsiyet = cinsiyetSec(scanner);
        BeslenmeHedefi beslenmeHedefi = beslenmeHedefiSec(scanner);
        AktiviteSeviyesi aktiviteSeviyesi = aktiviteSeviyesiSec(scanner);

        Sporcu sporcu = new Sporcu(
                sporcuId,
                adSoyad,
                yas,
                boy,
                kilo,
                cinsiyet,
                beslenmeHedefi,
                aktiviteSeviyesi
        );

        boolean eklendiMi = sporcuYonetimi.sporcuEkle(sporcu);

        if (eklendiMi) {
            System.out.println("Sporcu başarıyla eklendi.");
        } else {
            System.out.println("Bu ID ile kayıtlı bir sporcu zaten var.");
        }
    }

    private static void sporculariListele(
            SporcuYonetimi sporcuYonetimi) {

        List<Sporcu> sporcular =
                sporcuYonetimi.getSporcuKayitlari();

        if (sporcular.isEmpty()) {
            System.out.println("Kayıtlı sporcu bulunmuyor.");
            return;
        }

        System.out.println();
        System.out.println("----- SPORCU LİSTESİ -----");

        for (Sporcu sporcu : sporcular) {

            System.out.println(
                    "ID: " + sporcu.getSporcuId()
                            + " | Ad Soyad: " + sporcu.getAdSoyad()
                            + " | Kilo: " + sporcu.getKiloKg()
                            + " kg"
            );
        }
    }

    private static void antrenmanEkle(
            Scanner scanner,
            SporcuYonetimi sporcuYonetimi) {

        System.out.println();
        System.out.println("----- ANTRENMAN EKLEME -----");

        int sporcuId = intOku(scanner, "Sporcu ID: ");

        Sporcu sporcu =
                sporcuYonetimi.idIleSporcuGetir(sporcuId);

        if (sporcu == null) {
            System.out.println("Sporcu bulunamadı.");
            return;
        }

        LocalDate tarih = tarihOku(scanner);

        Antrenman antrenman = new Antrenman(tarih);

        int hareketSayisi =
                intOku(scanner, "Antrenmandaki hareket sayısı: ");

        for (int i = 1; i <= hareketSayisi; i++) {

            System.out.println();
            System.out.println(i + ". hareket:");

            HareketAdi hareketAdi = hareketAdiSec(scanner);

            Hareket hareket = new Hareket(hareketAdi);

            int setSayisi = intOku(scanner, "Set sayısı: ");

            for (int setNo = 1; setNo <= setSayisi; setNo++) {

                System.out.println(setNo + ". set:");

                double agirlik =
                        doubleOku(scanner, "Ağırlık: ");

                int tekrar =
                        intOku(scanner, "Tekrar sayısı: ");

                HareketSeti hareketSeti =
                        new HareketSeti(agirlik, tekrar);

                hareket.setEkle(hareketSeti);
            }

            antrenman.hareketEkle(hareket);
        }

        boolean eklendiMi = sporcu.antrenmanEkle(antrenman);

        if (eklendiMi) {
            System.out.println("Antrenman başarıyla eklendi.");
            System.out.println(
                    "Antrenman hacmi: "
                            + antrenman.toplamHacimHesapla()
            );
        } else {
            System.out.println(
                    tarih + " tarihinde antrenman kaydı zaten var."
            );
        }
    }

    private static void beslenmeKaydiEkle(
            Scanner scanner,
            SporcuYonetimi sporcuYonetimi) {

        System.out.println();
        System.out.println("----- BESLENME KAYDI EKLEME -----");

        int sporcuId = intOku(scanner, "Sporcu ID: ");

        Sporcu sporcu =
                sporcuYonetimi.idIleSporcuGetir(sporcuId);

        if (sporcu == null) {
            System.out.println("Sporcu bulunamadı.");
            return;
        }

        LocalDate tarih = tarihOku(scanner);

        GunlukBeslenme gunlukBeslenme =
                new GunlukBeslenme(tarih);

        int ogunSayisi =
                intOku(scanner, "Günlük öğün sayısı: ");

        for (int i = 1; i <= ogunSayisi; i++) {

            System.out.println();
            System.out.println(i + ". öğün:");

            OgunTuru ogunTuru = ogunTuruSec(scanner);

            Ogun ogun = new Ogun(ogunTuru);

            int besinSayisi =
                    intOku(scanner, "Öğündeki besin sayısı: ");

            for (int j = 1; j <= besinSayisi; j++) {

                System.out.println();
                System.out.println(j + ". besin:");

                System.out.print("Besin adı: ");
                String besinAdi = scanner.nextLine();

                double kalori =
                        doubleOku(scanner, "100 gram kalorisi: ");

                double karbonhidrat =
                        doubleOku(scanner, "100 gram karbonhidratı: ");

                double protein =
                        doubleOku(scanner, "100 gram proteini: ");

                double yag =
                        doubleOku(scanner, "100 gram yağı: ");

                double miktar =
                        doubleOku(scanner, "Tüketilen miktar (gram): ");

                Besin besin = new Besin(
                        besinAdi,
                        kalori,
                        karbonhidrat,
                        protein,
                        yag
                );

                BesinPorsiyonu porsiyon =
                        new BesinPorsiyonu(miktar, besin);

                ogun.besinPorsiyonuEkle(porsiyon);
            }

            gunlukBeslenme.ogunEkle(ogun);
        }

        boolean eklendiMi =
                sporcu.gunlukBeslenmeEkle(gunlukBeslenme);

        if (eklendiMi) {

            System.out.println("Beslenme kaydı başarıyla eklendi.");

            System.out.println(
                    "Toplam kalori: "
                            + gunlukBeslenme.gunlukKaloriHesapla()
            );

            System.out.println(
                    "Toplam protein: "
                            + gunlukBeslenme.gunlukProteinHesapla()
                            + " gram"
            );

        } else {
            System.out.println(
                    tarih + " tarihinde beslenme kaydı zaten var."
            );
        }
    }

    private static void beslenmeRaporuGoster(
            Scanner scanner,
            BeslenmeRaporServisi servis) {

        System.out.println();
        System.out.println("----- BESLENME RAPORU -----");

        int sporcuId = intOku(scanner, "Sporcu ID: ");
        LocalDate tarih = tarihOku(scanner);

        BeslenmeRaporu rapor =
                servis.beslenmeRaporuGetir(sporcuId, tarih);

        if (rapor == null) {
            System.out.println(
                    "Sporcu veya belirtilen tarihteki beslenme kaydı bulunamadı."
            );
            return;
        }

        hedefSonucunuYazdir(
                rapor.kaloriFarkiHesapla(),
                "Kalori",
                "kalori"
        );

        hedefSonucunuYazdir(
                rapor.proteinFarkiHesapla(),
                "Protein",
                "gram"
        );
    }

    private static void antrenmanHacimRaporuGoster(
            Scanner scanner,
            AntrenmanRaporServisi servis) {

        System.out.println();
        System.out.println("----- ANTRENMAN HACİM RAPORU -----");

        int sporcuId = intOku(scanner, "Sporcu ID: ");

        System.out.println("İlk antrenmanın tarihi:");
        LocalDate ilkTarih = tarihOku(scanner);

        System.out.println("İkinci antrenmanın tarihi:");
        LocalDate ikinciTarih = tarihOku(scanner);

        Double hacimFarki = servis.toplamHacimFarkiHesapla(
                sporcuId,
                ilkTarih,
                ikinciTarih
        );

        if (hacimFarki == null) {
            System.out.println(
                    "Sporcu veya antrenman kayıtlarından biri bulunamadı."
            );
            return;
        }

        hacimSonucunuYazdir(hacimFarki, "Antrenman");
    }

    private static void hareketHacimRaporuGoster(
            Scanner scanner,
            AntrenmanRaporServisi servis) {

        System.out.println();
        System.out.println("----- HAREKET HACİM RAPORU -----");

        int sporcuId = intOku(scanner, "Sporcu ID: ");

        System.out.println("İlk antrenmanın tarihi:");
        LocalDate ilkTarih = tarihOku(scanner);

        System.out.println("İkinci antrenmanın tarihi:");
        LocalDate ikinciTarih = tarihOku(scanner);

        HareketAdi hareketAdi = hareketAdiSec(scanner);

        Double hacimFarki = servis.hareketHacimFarkiHesapla(
                sporcuId,
                ilkTarih,
                ikinciTarih,
                hareketAdi
        );

        if (hacimFarki == null) {
            System.out.println(
                    "Sporcu, antrenman veya hareket kaydı bulunamadı."
            );
            return;
        }

        hacimSonucunuYazdir(
                hacimFarki,
                hareketAdi.toString()
        );
    }

    private static void hedefSonucunuYazdir(
            double fark,
            String hedefAdi,
            String birim) {

        if (Math.abs(fark) < TOLERANS) {

            System.out.println(
                    hedefAdi + " hedefine ulaşıldı."
            );

        } else if (fark > 0) {

            System.out.println(
                    "Hedefe kalan " + hedefAdi
                            + ": " + fark
                            + " " + birim + "."
            );

        } else {

            System.out.println(
                    hedefAdi + " hedef aşımı: "
                            + Math.abs(fark)
                            + " " + birim + "."
            );
        }
    }

    private static void hacimSonucunuYazdir(
            double fark,
            String raporAdi) {

        if (Math.abs(fark) < TOLERANS) {

            System.out.println(
                    raporAdi + " hacmi değişmedi."
            );

        } else if (fark > 0) {

            System.out.println(
                    raporAdi + " hacmi "
                            + fark + " arttı."
            );

        } else {

            System.out.println(
                    raporAdi + " hacmi "
                            + Math.abs(fark) + " azaldı."
            );
        }
    }

    private static Cinsiyet cinsiyetSec(Scanner scanner) {

        System.out.println("1- ERKEK");
        System.out.println("2- KADIN");

        int secim = intOku(scanner, "Cinsiyet: ");

        if (secim == 1) {
            return Cinsiyet.ERKEK;
        }

        return Cinsiyet.KADIN;
    }

    private static BeslenmeHedefi beslenmeHedefiSec(
            Scanner scanner) {

        System.out.println("1- YAĞ KAYBI");
        System.out.println("2- KİLO KORUMA");
        System.out.println("3- KAS KAZANIMI");

        int secim = intOku(scanner, "Beslenme hedefi: ");

        if (secim == 1) {
            return BeslenmeHedefi.YAG_KAYBI;
        } else if (secim == 2) {
            return BeslenmeHedefi.KILO_KORUMA;
        }

        return BeslenmeHedefi.KAS_KAZANIMI;
    }

    private static AktiviteSeviyesi aktiviteSeviyesiSec(
            Scanner scanner) {

        System.out.println("1- HAREKETSİZ");
        System.out.println("2- AZ AKTİF");
        System.out.println("3- ORTA AKTİF");
        System.out.println("4- ÇOK AKTİF");

        int secim = intOku(scanner, "Aktivite seviyesi: ");

        if (secim == 1) {
            return AktiviteSeviyesi.HAREKETSIZ;
        } else if (secim == 2) {
            return AktiviteSeviyesi.AZ_AKTIF;
        } else if (secim == 3) {
            return AktiviteSeviyesi.ORTA_AKTIF;
        }

        return AktiviteSeviyesi.COK_AKTIF;
    }

    private static HareketAdi hareketAdiSec(
            Scanner scanner) {

        HareketAdi[] hareketAdlari = HareketAdi.values();

        for (int i = 0; i < hareketAdlari.length; i++) {

            System.out.println(
                    (i + 1) + "- " + hareketAdlari[i]
            );
        }

        int secim = intOku(scanner, "Hareket seçimi: ");

        return hareketAdlari[secim - 1];
    }

    private static OgunTuru ogunTuruSec(
            Scanner scanner) {

        OgunTuru[] ogunTurleri = OgunTuru.values();

        for (int i = 0; i < ogunTurleri.length; i++) {

            System.out.println(
                    (i + 1) + "- " + ogunTurleri[i]
            );
        }

        int secim = intOku(scanner, "Öğün türü: ");

        return ogunTurleri[secim - 1];
    }

    private static LocalDate tarihOku(Scanner scanner) {

        while (true) {
            System.out.print("Tarih (yyyy-MM-dd): ");
            String tarihMetni = scanner.nextLine();

            try {
                return LocalDate.parse(tarihMetni);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println(
                        "Geçersiz tarih! Örnek giriş: 2026-08-14"
                );
            }
        }
    }

    private static int intOku(
            Scanner scanner,
            String mesaj) {

        while (true) {

            System.out.print(mesaj);
            String giris = scanner.nextLine();

            try {
                return Integer.parseInt(giris);
            } catch (NumberFormatException e) {
                System.out.println("Lütfen tam sayı giriniz.");
            }
        }
    }

    private static double doubleOku(
            Scanner scanner,
            String mesaj) {

        while (true) {

            System.out.print(mesaj);
            String giris = scanner.nextLine();

            try {
                return Double.parseDouble(giris);
            } catch (NumberFormatException e) {
                System.out.println(
                        "Lütfen geçerli bir sayı giriniz. Örnek: 75.5"
                );
            }
        }
    }
}