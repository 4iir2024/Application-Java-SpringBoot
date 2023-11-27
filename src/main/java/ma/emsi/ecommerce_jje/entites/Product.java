package ma.emsi.ecommerce_jje.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // parce que c'est une entity jpa
@Data  // notation Data de loombook qui gener les getters et setters
@NoArgsConstructor // notation Data de loombook qui gener constructor sans parameter
@AllArgsConstructor // notation Data de loombook qui gener constructor avec parameter
//@Builder // pour creation des objets
public class Product {
    @Id // parceque c'est une entity jpa nessicete un identifie
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generete id automatique
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
