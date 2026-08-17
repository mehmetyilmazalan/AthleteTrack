public enum BeslenmeHedefi {
    YAG_KAYBI(0.90,2),
    KILO_KORUMA(1.00,1.6),
    KAS_KAZANIMI(1.10,1.8);

    private double katsayiKalori;
    private double katsayiProtein;

    BeslenmeHedefi(double katsayi,double katsayiProtein){

        this.katsayiProtein=katsayiProtein;
        this.katsayiKalori=katsayi;
    }

    public double getKatsayiKalori(){
        return this.katsayiKalori;
    }

    public double getKatsayiProtein(){
        return this.katsayiProtein;
    }


}
