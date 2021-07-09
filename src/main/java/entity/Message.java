package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String content;
    private String deliveryTime;

    public Message(String content) {
        this.content = content;
    }
}
