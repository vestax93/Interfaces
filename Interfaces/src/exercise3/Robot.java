package exercise3;

public class Robot implements Identifiable{
    private String model;
    private String id;

    public Robot(String id,String model ) {
        this.model = model;
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
