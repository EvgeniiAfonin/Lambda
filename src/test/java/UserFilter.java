import java.util.LinkedList;
import java.util.List;

@FunctionalInterface
public interface UserFilter {

     boolean isFiltered(UserInfo user);

     static List<UserInfo> filter(List<UserInfo> usersData, UserFilter userFilter) {
         List<UserInfo> userList = new LinkedList<>();
         for(UserInfo userInfo : usersData) {
             if(userFilter.isFiltered(userInfo)) {
                 userList.add(userInfo);
             }
         }
         return userList;
     }
}
