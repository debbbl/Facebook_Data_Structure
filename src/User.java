import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//register
public class User {
    private final String email;
    private final String phone;
    private final String username;
    private final String password;
    private final String gender;
    private final String job;
    private String relationshipStatus;
    private final List<String> hobbies;

    private User(Builder builder) {
        this.email = builder.email;
        this.phone = builder.phone;
        this.gender=builder.gender;
        this.username = builder.username;
        this.password = builder.password;
        this.hobbies = builder.hobbies;
        this.job=builder.job;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public String getGender(){
        return  gender;
    }

    public String getJob(){
        return job;
    }
    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public static class Builder {
        public String gender;
        private String email;
        private String phone;
        private String username;
        private String password;
        private String job;
        private List<String> hobbies;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }


        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }
        public Builder job(String hob) {
            this.job = job;
            return this;
        }
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder hobbies(List<String> hobbies) {
            this.hobbies = hobbies;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
