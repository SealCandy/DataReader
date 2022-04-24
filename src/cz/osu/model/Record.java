package cz.osu.model;

public class Record {
    private int rank;
    private int year;
    private double worth;

    public Record(int rank, int year, double worth) {
        this.rank = rank;
        this.year = year;
        this.worth = worth;
    }

    public int getRank() {
        return rank;
    }

    public int getYear() {
        return year;
    }

    public double getWorth() {
        return worth;
    }

    @Override
    public String toString() {
        return "Record{" +
                "rank=" + rank +
                ", year=" + year +
                ", worth=" + worth +
                '}';
    }
}
