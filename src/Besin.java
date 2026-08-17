public class Besin {
    private String besinAdi;
    private double besinKalori100gram;
    private double besinKarb100gram;
    private double besinProtein100gram;
    private double besinYag100gram;


    public Besin(String besinAdi, double besinKalori100gram, double besinKarb100gram, double besinProtein100gram, double besinYag100gram) {
        this.besinAdi = besinAdi;
        this.besinKalori100gram = besinKalori100gram;
        this.besinKarb100gram = besinKarb100gram;
        this.besinProtein100gram = besinProtein100gram;
        this.besinYag100gram = besinYag100gram;
    }

    public String getBesinAdi() {
        return besinAdi;
    }

    public double getBesinKalori100gram() {
        return besinKalori100gram;
    }

    public double getBesinKarb100gram() {
        return besinKarb100gram;
    }

    public double getBesinProtein100gram() {
        return besinProtein100gram;
    }

    public double getBesinYag100gram() {
        return besinYag100gram;
    }
}
