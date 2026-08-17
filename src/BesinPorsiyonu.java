public class BesinPorsiyonu {
    private double besinGramMiktari;
    private Besin besin;


   //  TODO: olarak bırakacağımız kontroller:
    //Gram miktarı sıfır veya negatif olmamalı.
    //besin, null olmamalı.
    //Dört metotta tekrarlanan oran formülü ileride ortaklaştırılabilir; şu an ortaklaştırma, çünkü temel mantığı görmen daha önemli.

    public BesinPorsiyonu(double besinGramMiktari,Besin besin){
        this.besinGramMiktari =besinGramMiktari;
        this.besin=besin;
    }

    public double getBesinGramMiktari() {
        return besinGramMiktari;
    }

    public Besin getBesin() {
        return besin;
    }

    public double besinKaloriHesapla(){
        return besin.getBesinKalori100gram()* besinGramMiktari/100;
    }

    public double besinProteinHesapla(){
        return besin.getBesinProtein100gram()* besinGramMiktari/100;
    }

    public double besinYagHesapla(){
        return besin.getBesinYag100gram()* besinGramMiktari/100;
    }

    public double besinKarbHesapla(){
        return besin.getBesinKarb100gram()* besinGramMiktari/100;
    }

}
