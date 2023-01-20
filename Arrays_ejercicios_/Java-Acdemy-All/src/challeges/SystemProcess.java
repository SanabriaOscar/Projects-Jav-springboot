package challeges;

public class SystemProcess extends Process{
    private final int MAX=15;
    private final int MIN=5;


    public SystemProcess() {
        super.setSize(MAX, MIN);
        super.setFormatId();
    }

    @Override
    public String getFormatId() {
        return "s"+super.getFormatId();
    }

}
