package za.ac.cput.marginhotelmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact_details")
public class ContactDetails implements ValueObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactDetailsId;

    @Column(unique = true, nullable = false)
    private String email;
    private String mobile;

    public ContactDetails() {
    }

    public ContactDetails(Builder builder) {
        this.contactDetailsId = builder.contactDetailsId;
        this.email = builder.email;
        this.mobile = builder.mobile;
    }

    public Long getContactDetailsId() {
        return contactDetailsId;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public static class Builder {
        private Long contactDetailsId;
        private String email;
        private String mobile;

        public Builder setEmail(String email) {
            this.email = email;
            return this;

        }

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;

        }

        public Builder setContactDetailsId(Long contactDetailsId) {
            this.contactDetailsId = contactDetailsId;
            return this;
        }

        public Builder copy(ContactDetails contactDetails) {
            this.contactDetailsId = contactDetails.contactDetailsId;
            this.email = contactDetails.email;
            this.mobile = contactDetails.mobile;
            return this;
        }

        public ContactDetails build() {
            return new ContactDetails(this);
        }
    }

}
