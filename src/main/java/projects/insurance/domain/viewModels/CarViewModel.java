package projects.insurance.domain.viewModels;

public class CarViewModel {

    private String make;
    private String model;
    private String DKN;
    private String chassis;
    private String year;

    public CarViewModel() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDKN() {
        return DKN;
    }

    public void setDKN(String DKN) {
        this.DKN = DKN;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
