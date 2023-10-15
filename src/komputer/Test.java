package komputer;

import javax.swing.JOptionPane;

/**
 *
 * @author karel
 */
public class Test {
    public static void main(String[] args) {
        DataKomputer data = new DataKomputer();
        do {
            int p = data.pilihanMenu();
            switch(p) {
                case AppInterface.ADD_DATA_KOMPUTER -> {
                    data.add();
                    break;
                }
                case AppInterface.SEARCH_BY_BRAND -> {
                    String key = data.keyword("brand");
                    Komputer k = data.searchByBrand(key);
                    data.viewData(k, "Brand", key);
                    break;
                }
                case AppInterface.SEARCH_BY_MODEL -> {
                    String key = data.keyword("model");
                    Komputer k = data.searchByModel(key);
                    data.viewData(k, "Model", key);
                    break;
                }
                case AppInterface.EXIT -> {
                    data.exit();
                    break;
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Pilihan Salah!");
                    break;
                }
            }
        } while(true);
    }
}
