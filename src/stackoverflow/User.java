package stackoverflow;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private int id;
    private String name = "";

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {    
    	System.out.println(Integer.parseInt("02", 10));
//    	String encoding = "ISO8859_15";
//    	System.out.println("\u015a");
//    	byte[] b = "\u015A".getBytes(encoding);
//    	System.out.printf("b.length=%d b[0]=%s %n", b.length, Integer.toHexString(b[0]));
//    	String s = new String(b, encoding);
//    	System.out.printf("s.length=%d s=%s %n", s.length(), Integer.toHexString(s.charAt(0)));

//        List<User> users = new ArrayList<User>();
//        users.add(new User(1, "aaa"));
//        users.add(new User(2, "bbb"));
//        users.add(new User(3, "ccc"));
//        users.add(new User(4, "ddd"));
//        users.add(new User(5, "eee"));
//        users.add(new User(6, "fff"));
//        users.add(new User(7, "ggg"));
//
//        List<Integer> users1= new ArrayList<Integer>();
//        users1.add(3);
//        users1.add(6);
//        users1.add(1);
//        users1.add(4);
//        
//        for (Iterator<User> i = users.iterator(); i.hasNext(); ) {
//        	User user = i.next();
//        	if (users1.contains(user.getId()))
//        		i.remove();
//        }
//
//        for (User u : users)
//        	System.out.println(u.getId() + " " + u.getName());

    }
}
