package Models;

public class PhonesModel extends MaterielsModel {
    private String IMEI;

    public PhonesModel() {
        super();
        this.IMEI = IMEI;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }
}
