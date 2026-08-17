public class BeslenmeHesaplayici {

    public double temelKaloriHesapla(Sporcu sporcu){

        double sporcuBoy= sporcu.getBoyCm();
        double sporcuKilo=sporcu.getKiloKg();
        int sporcuYas=sporcu.getYas();

        double ortakFormul=10*sporcuKilo+6.25*sporcuBoy-5*sporcuYas;

        if(sporcu.getCinsiyet()==Cinsiyet.ERKEK){
            return ortakFormul+5;
        }
        return ortakFormul-161;
    }


    public double aktiviteKalorisiHesapla(Sporcu sporcu){
        AktiviteSeviyesi aktiviteSeviyesi = sporcu.getAktiviteSeviyesi();
        return temelKaloriHesapla(sporcu)*aktiviteSeviyesi.getKatsayi();
    }

    public double hedefKaloriHesapla(Sporcu sporcu){
        BeslenmeHedefi beslenmeHedefi = sporcu.getBeslenmeHedefi();
        return aktiviteKalorisiHesapla(sporcu)*beslenmeHedefi.getKatsayiKalori();
    }

    public double hedefProteinHesapla(Sporcu sporcu){
        BeslenmeHedefi beslenmeHedefi=sporcu.getBeslenmeHedefi();
        return sporcu.getKiloKg()*beslenmeHedefi.getKatsayiProtein();
    }

}
