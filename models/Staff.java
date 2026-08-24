package models;

public class Staff extends User {
    private String staffRole;

    // Constructor
    public Staff(Integer userId, String username, String email, String staffRole){
        super(userId, username, email);
        this.staffRole = staffRole;
    }
    
    // Getters
    public String getStaffRole(){
        return staffRole;
    }
}
