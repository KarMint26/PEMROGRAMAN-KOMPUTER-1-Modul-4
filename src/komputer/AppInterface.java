package komputer;

/**
 *
 * @author karel
 */
public interface AppInterface {
    final int ADD_DATA_KOMPUTER = 1;
    final int SEARCH_BY_BRAND = 2;
    final int SEARCH_BY_MODEL = 3;
    final int EXIT = 4;
    
    public int pilihanMenu();
    public void add();
    public String keyword(String type);
    public Komputer searchByBrand(String brand);
    public Komputer searchByModel(String model);
    public void viewData(Komputer k, String searchType, String key);
    public void exit();
}
