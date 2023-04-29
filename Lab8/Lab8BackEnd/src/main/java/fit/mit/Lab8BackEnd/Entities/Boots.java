package fit.mit.Lab8BackEnd.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="Boots")
public class Boots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int size;
    private int price;
    private String image;
}
