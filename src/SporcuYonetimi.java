import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SporcuYonetimi {
    private Map<Integer,Sporcu> sporcuKayitlari = new HashMap<>();

    public boolean sporcuEkle(Sporcu eklenecekSporcu){
        int eklenecekSporcuId=eklenecekSporcu.getSporcuId();
        if(sporcuKayitlari.containsKey(eklenecekSporcuId)){
            return false;
        }else{
            sporcuKayitlari.put(eklenecekSporcuId,eklenecekSporcu);
            return true;
        }
    }

    public Sporcu idIleSporcuGetir(int arananSporcuId){
        return sporcuKayitlari.get(arananSporcuId);
    }

    public boolean sporcuSil(int silinecekSporcuId){
        if(sporcuKayitlari.remove(silinecekSporcuId)!=null){
            return true;
        }
        return false;
    }

    public boolean sporcuGuncelle(Sporcu guncellenecekKayit){
        if(sporcuKayitlari.replace(guncellenecekKayit.getSporcuId(),guncellenecekKayit)!=null){
            return true;
        }
        return false;
    }

    public List<Sporcu> getSporcuKayitlari(){
        List<Sporcu> sporcuListesi = new ArrayList<>();
        for(Sporcu kayıtlıSporcu : sporcuKayitlari.values()){
            sporcuListesi.add(kayıtlıSporcu);
        }return sporcuListesi;
    }
}
