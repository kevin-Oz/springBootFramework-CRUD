package bytesw._2023.test.Repository;

import bytesw._2023.test.Entity.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
}
