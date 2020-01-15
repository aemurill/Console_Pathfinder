package PFPackage.PFBooks;

public enum LanguageEnum {
    Common, Dwarven;

    private LanguageEnum(){
    }

    @Override
    public String toString() {
        return this.name();
    }
}
