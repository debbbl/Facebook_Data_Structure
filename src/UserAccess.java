import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserAccess extends User {
    boolean isAdmin;
    boolean isParent;
    UserAccess parent;
    private int maxTimeOfOneDay;//hour
    private int remainingTime;


    public void setMaxTimeOfOneDay(int maxTimeOfOneDay) {
        this.maxTimeOfOneDay = maxTimeOfOneDay;
    }

    private List<User> userList;
    private List<User> child;

    public UserAccess(Builder builder, boolean isAdmin, boolean isParent, int maxTimeOfOneDay) {
        super(builder);
        this.isParent = isParent;
        this.isAdmin = isAdmin;
        this.maxTimeOfOneDay = maxTimeOfOneDay;
        this.remainingTime = maxTimeOfOneDay;

    }

    public void delete(User userToBeDeleted) {//delete userlist
        userList.remove(userToBeDeleted);
    }
//delete inAppropriateContents
public void removeInappropriateMaterials() {
   for(User user :userList){
  if(!user.getUsername().matches("")){//if the username contains some incorrect words * the ("")we need to set the criteria
   userList.remove(user);
  }
   }
}

    class parentControl {
        public boolean CanChildContinueUse() {

            if (isParent && isAdmin) {
                int currentTime = 0;
                parent.setMaxTimeOfOneDay(maxTimeOfOneDay);
                for (int i = 0; i <= 24; i++) {
                    currentTime++;
                    remainingTime = (maxTimeOfOneDay - currentTime);
                    if (remainingTime >=0) {
                        System.out.println("Children can still use for "+ remainingTime +"hours");
                    }
                    if(remainingTime<0){
                        System.out.printf("Stop ! The time of using is exceeded ");
                        return false;

                    }


                }

            }

            return false;
        }
    }
}





