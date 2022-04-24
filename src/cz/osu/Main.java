package cz.osu;

import cz.osu.dataProcessing.BillionairesManager;
import cz.osu.dataProcessing.DataSource;
import cz.osu.dataProcessing.FileManager;

public class Main {

    public static void main(String[] args) {
        //System.out.println(FileManager.readCsv("billionaires.csv"));
        BillionairesManager bm = new BillionairesManager(DataSource.CSV);
        System.out.println(bm.getMostRich(2000));
    }
}
