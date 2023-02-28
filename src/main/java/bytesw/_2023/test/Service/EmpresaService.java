package bytesw._2023.test.Service;

import bytesw._2023.test.Entity.Empresa;

import java.util.List;

public interface EmpresaService {
    Empresa createEmpresa(Empresa empresa);
    List<Empresa> fetchEmpresasList();
    Empresa updateEmpresa(Empresa empresa, Long empresaId);

    void deleteEmpresaById(Long empresaId);

}
