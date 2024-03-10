package design.pattern.expense.model;

public class User {
    private String id;
    private String name;
    private String email;
    private String mobileNo;


    public User(String id, String name, String email, String mobileNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNo() {
        return mobileNo;
    }
}
