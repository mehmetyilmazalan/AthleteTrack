public enum AktiviteSeviyesi {
    HAREKETSIZ(1.2),
    AZ_AKTIF(1.4),
    ORTA_AKTIF(1.6),
    COK_AKTIF(1.8);

    private double katsayi;

    AktiviteSeviyesi(double katsayi) {
        this.katsayi=katsayi;
    }

    public double getKatsayi() {
        return this.katsayi;
    }
}
