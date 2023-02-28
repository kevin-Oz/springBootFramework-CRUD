package bytesw._2023.test.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "empresa")
public class Empresa
{
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String nombre;
    @Column(name = "numero_de_nit")
    private String numero_de_nit;
    @Column(name = "fecha_de_fundacion")
    private Date fecha_de_fundacion;


}
