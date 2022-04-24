package cz.osu.dataProcessing;

import cz.osu.model.Billionaire;
import cz.osu.model.Record;

import java.util.ArrayList;
import java.util.HashMap;

public class BillionairesManager {
    private ArrayList<Billionaire> billionaires;

    public BillionairesManager(DataSource dataSource) {
        if (dataSource == DataSource.CSV) {
            billionaires = parseCsv("billionaires.csv");
        }
    }

    private ArrayList<Billionaire> parseCsv(String fileName) {
        ArrayList<String> lines = FileManager.readCsv(fileName);
        HashMap<String, Billionaire> ret = new HashMap<>();
        for(String line : lines.subList(1, lines.size())){
            String[] components = line.split(";");
            String name = components[0];
            int rank = Integer.parseInt(components[1]);
            int year = Integer.parseInt(components[2]);
            String company = components[3];
            String country = components[4];
            double worth = Double.parseDouble(components[5].replace(',','.'));
            Billionaire billionaire = ret.get(name);
            if(billionaire == null) {
                billionaire = new Billionaire(name, company, country);
                ret.put(name, billionaire);
            }
            billionaire.getRecordsMap().put(year, new Record(rank, year, worth));
        }

        return new ArrayList<>(ret.values());
    }

    public Billionaire getMostRich(int year){
        Billionaire ret = null;
        for(Billionaire billionaire : billionaires){
            Record record = billionaire.getRecordsMap().get(year);
            if(record != null){
                if(ret == null){
                    ret = billionaire;
                } else {
                    Record currentRecord = ret.getRecordsMap().get(year);
                    if(record.getRank() < currentRecord.getRank()){
                        ret = billionaire;
                    }
                }
            }
        }
        return ret;
    }
}
