package challeges;

import java.util.Formatter;
import java.util.Random;

public class Process {
    private final Formatter obj = new Formatter();
    private  int id;
    private  int size;
    private  String formatId;
    private static int cont=0;

    public Process() {
        setId(++cont);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int max, int min) {
        this.size = (int) (Math.random()*(max-min)) + min;
    }

    public String getFormatId() {
        return formatId;
    }

    public void setFormatId() {
        this.formatId = String.valueOf(obj.format("%03d", getId()));
    }

    public int getContat() {
        return cont;
    }

    public void setContat(int contat) {
        this.cont= contat;
    }
}
