package Models;

public class EquipementsModel extends MaterielsModel{
    private String address_MAC;


    //setter


    public EquipementsModel() {
    }

    public EquipementsModel(String address_MAC) {
        this.address_MAC = address_MAC;
    }

    public void setAddress_MAC(String address_MAC) {
        this.address_MAC = address_MAC;
    }

    // getter

    public String getAddress_MAC() {
        return address_MAC;
    }
}
