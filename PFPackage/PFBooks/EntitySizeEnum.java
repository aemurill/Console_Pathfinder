package PFPackage.PFBooks;

public enum EntitySizeEnum {
    Fine(-8), Diminutive(-4), Tiny(-2), Small(-1), 
    Medium(0), Large(1), Huge(2), Gargantuan(4), Colossal(8);
    //More can be added but stop here pls
    private int mod;

    private EntitySizeEnum(int mod){
        this.mod = mod;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public int getMod() {
        return this.mod;
    }
}
