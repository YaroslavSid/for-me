package entity;

//import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@EqualsAndHashCode
@Setter
@Getter
public class User {
    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
//                "id=" + id +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
                '}';
    }
}
