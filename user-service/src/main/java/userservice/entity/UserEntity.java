package userservice.entity;

import jakarta.persistence.*;
import lombok.*;
import userservice.entity.shared.DateAudit;

@Data
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@SequenceGenerator(name = "SEQUENCE", sequenceName = "USERS_ID_SEQ", allocationSize = 1)
@Entity
@Table(name = "users")
public class UserEntity extends DateAudit {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = "SEQUENCE", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, updatable = false)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "registersms")
    private String registerSms;

    @Column(name = "forgotpasswordsms")
    private String forgotPasswordSms;

    @Column(name = "phoneverification")
    private boolean phoneVerification;
}

