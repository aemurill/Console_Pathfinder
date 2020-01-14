package PFPackage.PFBooks;

public enum LanguageEnum {
    Common;

    private LanguageEnum(){
    }

    @Override
    public String toString() {
        return this.name();
    }
}
