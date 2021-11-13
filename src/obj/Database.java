package obj;

import java.util.ArrayList;

// Singlaton
public class Database {
    private static Database     DBinstance;

    private ArrayList<Member>   memberList;
    private Admin               admin;

    private Database() {
        memberList  = new ArrayList<Member>();
        memberList.add(new Member("1", "Peter", "123@gmail.com", "123"));

        admin = new Admin("Jack", "123");
    }

    public static Database connectDB() { 
        if(DBinstance == null) {
            DBinstance = new Database();
        }
        return DBinstance;
    }

    public Member getMember(String accountName, String password) {
        for(Member member : memberList) {
            // check if the username and password is match with the parameter
            if(member.checkAccount(accountName, password)) {
                return member;
            }
        }

        // member not found
        return null;
    }
    public Admin getAdmin(String accountName, String password) { 
        if(admin.checkAccount(accountName, password)) { return admin; }
        return null; 
    }
}
