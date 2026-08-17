import java.util.ArrayList;
import java.util.List;

public class Hareket {
    private HareketAdi hareketAdi;

    private List<HareketSeti> setler = new ArrayList<>();

    public Hareket(HareketAdi hareketAdi){
        this.hareketAdi=hareketAdi;
    }

    public HareketAdi getHareketAdi(){
        return this.hareketAdi;
    }

    public void setEkle(HareketSeti hareketSeti){
        setler.add(hareketSeti);
    }

    public double toplamHacimHesapla(){
        double toplamSetHacim=0;
        for(HareketSeti set : setler){
            toplamSetHacim+=set.hacimHesapla();
        } return toplamSetHacim;
    }
}
