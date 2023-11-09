package interview.birdeye;

import java.time.LocalDate;

public class ImmutableEmployee {
    private final String name;
    private final String id;
    private final String dept;
    private final LocalDate localDate;

    public ImmutableEmployee(String name,String id,String dept, final LocalDate localDate)
    {
        this.name=name;
        this.id=id;
        this.dept=dept;
        this.localDate=localDate;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDept() {
        return dept;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public static void main(String[] args)
    {
        ImmutableEmployee immutableEmployee= new ImmutableEmployee("xys","123","idid",LocalDate.now());
    }
}
