public class HareketSeti {
    private double agirlik;
    private int tekrarSayisi;


    // TODO: Ağırlık ve tekrar sayısı için geçersiz değer kontrolü eklenecek.
    public HareketSeti(double agirlik, int tekrarSayisi){
        this.agirlik=agirlik;
        this.tekrarSayisi=tekrarSayisi;

    }

    public double getAgirlik(){
        return this.agirlik;
    }

    public int getTekrarSayisi(){
        return this.tekrarSayisi;
    }

    public double hacimHesapla(){
        return agirlik*tekrarSayisi;
    }
}
