package kz.bitlab.academy.secondsprint.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "application_requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "commentary")
    private String commentary;


    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "handled", nullable = false)
    private boolean handled = false;

    public ApplicationRequest(String userName, String courseName, String phone, String commentary){
        this.userName = userName;
        this.courseName = courseName;
        this.phone = phone;
        this.commentary = commentary;
    }
}
