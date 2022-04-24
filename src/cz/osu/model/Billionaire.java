package cz.osu.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Billionaire {
    private String name;
    private String company;
    private String country;
    private HashMap<Integer, Record> recordsMap;
    private ArrayList<Record> records;

    public Billionaire(String name, String company, String country) {
        this.name = name;
        this.company = company;
        this.country = country;
        recordsMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getCountry() {
        return country;
    }

    public HashMap<Integer, Record> getRecordsMap() {
        if(recordsMap == null || recordsMap.isEmpty()){
            recordsMap = new HashMap<>();
            if(records != null && !records.isEmpty()){
                for(Record record : records){
                    recordsMap.put(record.getYear(), record);
                }
            }
        }
        return recordsMap;
    }

    public ArrayList<Record> getRecords() {
        if(records == null){
            records = new ArrayList<>(recordsMap.values());
        }
        return records;
    }

    @Override
    public String toString() {
        return "Billionaire{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", country='" + country + '\'' +
                ", records=" + getRecords() +
                '}';
    }
}
