package fit.mit.Lab6BackEnd.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
@Table(name="ItemBoots")
public class Boots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int size;
    private int price;
    private String image;
}
