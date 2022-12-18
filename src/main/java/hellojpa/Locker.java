package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.reflect.Member;

@Entity
@Getter
@Setter
public class Locker {

    @Id @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

}


