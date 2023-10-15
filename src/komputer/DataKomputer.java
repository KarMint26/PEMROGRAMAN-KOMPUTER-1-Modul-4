package komputer;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author karel
 */
public class DataKomputer implements AppInterface {
    
    private final Komputer[] komputers;
    
    public DataKomputer() {
        komputers = new Komputer[1000];
    }

    @Override
    public int pilihanMenu() {
        String p = JOptionPane.showInputDialog(null, ""
                + "<html>"
                + "====Pilihan======================<br>"
                + "1 &rarr; Tambah Data Komputer<br>"
                + "2 &rarr; Cari Berdasarkan Brand Komputer<br>"
                + "3 &rarr; Cari Berdasarkan Model Komputer<br>"
                + "4 &rarr; Keluar Aplikasi<br>"
                + "=============================<br>"
                + "<b style='color: red;'>Ketik Pilihan Anda: </b>"
                + "</html>",
           "Menu Pilihan",
       JOptionPane.QUESTION_MESSAGE);
        int pilihan = Integer.parseInt(p);
        return pilihan;
    }

    @Override
    public void add() {
        Komputer kom = new Komputer();
        String brand = JOptionPane.showInputDialog(null, "Ketik Brand: ", ""
                + "Brand", JOptionPane.QUESTION_MESSAGE);
        kom.setBrand(brand);
        String model = JOptionPane.showInputDialog(null, "Ketik Model: ", ""
                + "Model", JOptionPane.QUESTION_MESSAGE);
        kom.setModel(model);
        String disk = JOptionPane.showInputDialog(null, "Tipe Disk (SSD/Hardisk): ", ""
                + "Tipe Disk", JOptionPane.QUESTION_MESSAGE);
        kom.setDiskType(disk);
        String size = JOptionPane.showInputDialog(null, "Kapasitas Disk (Angka):", ""
                + "Kapasitas Disk (dalam GB)", JOptionPane.QUESTION_MESSAGE);
        int diskSize = Integer.parseInt(size); // casting
        kom.setDiskSize(diskSize);
        String ram = JOptionPane.showInputDialog(null, "Kapasitas RAM (Angka):", ""
                + "Ukuran RAM (dalam GB)", JOptionPane.QUESTION_MESSAGE);
        int ramSize = Integer.parseInt(ram);
        kom.setRam(ramSize);

        for (int i = 0; i < komputers.length; i++) {
            if(komputers[i] == null) {
                komputers[i] = kom;
                break;
            }
        }
        
        viewData(kom, "Add Data", "add");
    }

    @Override
    public String keyword(String type) {
        String key = JOptionPane.showInputDialog(null, "Ketik " + type + " Komputer",
                type, JOptionPane.QUESTION_MESSAGE);
        return key;
    }

    @Override
    public Komputer searchByBrand(String brand) {
        Komputer komp = null;
        for(Komputer k : komputers){
            if(k != null && (brand.equalsIgnoreCase(k.getBrand()) || k.getBrand().contains(brand))){
                komp = k;
                break;
            }
        }
        return komp;
    }

    @Override
    public Komputer searchByModel(String model) {
        Komputer komp = null;
        for(Komputer k : komputers){
            if(k != null && (model.equalsIgnoreCase(k.getModel()) || k.getModel().contains(model))){
                komp = k;
                break;
            }
        }
        return komp;
    }
    
    public void viewTable(String searchType, String keyword){
        String[] columnNames = {"No", "Brand", "Model", "Disk Type", "Disk Size", "RAM"};
        Object[][] rowsField = new Object[komputers.length][columnNames.length];
        
        switch(searchType){
            case "Add Data" -> {
                for (int i = 0; i < komputers.length; i++) {
                    if (komputers[i] != null) {
                        rowsField[i][0] = i+1;
                        rowsField[i][1] = komputers[i].getBrand();
                        rowsField[i][2] = komputers[i].getModel();
                        rowsField[i][3] = komputers[i].getDiskType();
                        rowsField[i][4] = komputers[i].getDiskSize();
                        rowsField[i][5] = komputers[i].getRam();
                    }
                } 
                break;
            }
            case "Brand" -> {
                byte count = 0;
                for (Komputer komputer : komputers) {
                    if(komputer != null){
                        String brandKomputer = komputer.getBrand().toLowerCase();
                        String keywordSearch = keyword.toLowerCase();
                        if (komputer.getBrand().equalsIgnoreCase(keyword) || brandKomputer.contains(keywordSearch)) {
                            count++;
                        }
                    }
                }
                for (int i = 0; i < count; i++) {
                    String brandKomputer = komputers[i].getBrand().toLowerCase();
                    String keywordSearch = keyword.toLowerCase();
                    if(komputers[i].getBrand().equalsIgnoreCase(keyword) || brandKomputer.contains(keywordSearch)){
                        rowsField[i][0] = i+1;
                        rowsField[i][1] = komputers[i].getBrand();
                        rowsField[i][2] = komputers[i].getModel();
                        rowsField[i][3] = komputers[i].getDiskType();
                        rowsField[i][4] = komputers[i].getDiskSize();
                        rowsField[i][5] = komputers[i].getRam();
                    }
                }
                break;
            }
            case "Model" -> {
                byte count = 0;
                for (Komputer komputer : komputers) {
                    if(komputer != null){
                        String modelKomputer = komputer.getModel().toLowerCase();
                        String keywordSearch = keyword.toLowerCase();
                        if (komputer.getModel().equalsIgnoreCase(keyword) || modelKomputer.contains(keywordSearch)) {
                            count++;
                        }
                    }
                }
                for (int i = 0; i < count; i++) {
                    String brandKomputer = komputers[i].getModel().toLowerCase();
                    String keywordSearch = keyword.toLowerCase();
                    if(komputers[i].getModel().equalsIgnoreCase(keyword) || brandKomputer.contains(keywordSearch)){
                        rowsField[i][0] = i+1;
                        rowsField[i][1] = komputers[i].getBrand();
                        rowsField[i][2] = komputers[i].getModel();
                        rowsField[i][3] = komputers[i].getDiskType();
                        rowsField[i][4] = komputers[i].getDiskSize();
                        rowsField[i][5] = komputers[i].getRam();
                    }
                }
                break;
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Wrong Options", "Wrong Option", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        JTable table = new JTable(rowsField, columnNames);
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Komputer", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void viewData(Komputer k, String searchType, String key) {
        if (k == null) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        } else {
            viewTable(searchType, key);
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }
    
}
