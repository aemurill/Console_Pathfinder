package PFPackage.PFBooks;

public enum EntitySizeEnum {
    Medium;
    //More can be added but stop here pls

    private EntitySizeEnum(){
    }

    @Override
    public String toString() {
        return this.name();
    }

}
