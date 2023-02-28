package bytesw._2023.test.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class Empresa
{
    @jakarta.persistence.Id
    private Long Id;
    private String nombre;
    private String numero_de_NIT;
    private Date fecha_de_fundacion;


}
