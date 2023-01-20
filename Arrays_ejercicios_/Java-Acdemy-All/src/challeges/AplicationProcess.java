package challeges;

public class AplicationProcess extends Process{
    private final int MAX=15;
    private final int MIN=5;

    public AplicationProcess() {
        super.setSize(MAX,MIN);
        super.setFormatId();
    }
    @Override
    public String getFormatId() {
        return "a"+super.getFormatId();
    }
}
