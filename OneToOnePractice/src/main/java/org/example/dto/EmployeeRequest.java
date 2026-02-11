package org.example.dto;

public class EmployeeRequest {

    private String name;
    private String email;
    private ProfileRequest profileRequest;

    public static class ProfileRequest{
        private String phone;
        private String address;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProfileRequest getProfileRequest() {
        return profileRequest;
    }

    public void setProfileRequest(ProfileRequest profileRequest) {
        this.profileRequest = profileRequest;
    }
}
