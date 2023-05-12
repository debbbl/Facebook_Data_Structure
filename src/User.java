import java.util.List;

public class User {
    private String email;
    private String phone;
    private String username;
    private String password;
    private String gender;
    private String job;
    private String birthday;
    private String address;
    private String relationshipStatus;
    private List<String> hobbies;

    protected User(Builder builder) {
        this.email = builder.email;
        this.phone = builder.phone;
        this.username = builder.username;
        this.password = builder.password;
        this.gender = builder.gender;
        this.job = builder.job;
        this.hobbies = builder.hobbies;
        this.birthday = builder.birthday;
        this.address = builder.address;
    }
    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }
    public String getRelationshipStatus() {
        return relationshipStatus;
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

    public String getGender() {
        return gender;
    }

    public String getJob() {
        return job;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        // Check if the new status is valid
        if (relationshipStatus.equals("Single") || relationshipStatus.equals("In a relationship") || 
            relationshipStatus.equals("Engaged") || relationshipStatus.equals("Married") || 
            relationshipStatus.equals("It's complicated")) {
            this.relationshipStatus = relationshipStatus;
        } else {
            System.out.println("Invalid relationship status");
        }
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setJob(String job) {
        this.job = job;
    }
    
    

    public static class Builder {
        private String email;
        private String phone;
        private String username;
        private String password;
        private String gender;
        private String job;
        private String birthday;
        private String address;
        private List<String> hobbies;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public Builder hobbies(List<String> hobbies) {
            this.hobbies = hobbies;
            return this;
        }

        public Builder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
