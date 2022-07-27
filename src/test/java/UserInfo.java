import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserInfo {

    /**
     * Parameter sex : true is a men, false is a women;
     */

    String name;
    int age;
    int weight;
    boolean sex;
    String speciality;

    @Override
    public String toString() {
        return "Customer name is " + name + ". Has " + age + " years old. " + "Weight is " + weight + ". Sex is " +
        sex + ". Speciality is a " + speciality + ".";
    }
}
