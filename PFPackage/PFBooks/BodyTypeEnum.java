package PFPackage.PFBooks;

public enum BodyTypeEnum {
    Humanoid;
    //More can be added but stop here pls

    private BodyTypeEnum(){
    }

    @Override
    public String toString() {
        return this.name();
    }

}
