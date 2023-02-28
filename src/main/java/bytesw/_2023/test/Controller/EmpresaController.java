package bytesw._2023.test.Controller;

import bytesw._2023.test.Entity.Empresa;
import bytesw._2023.test.Repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/")
public class EmpresaController {
    @Autowired private EmpresaRepository empresaRepository;

    @PostMapping("/empresa")
    public ResponseEntity<?> createEmpresa( @RequestBody Empresa empresa){
        try {
            empresaRepository.save(empresa);
        return new ResponseEntity<>(empresa, HttpStatus.CREATED);
        }catch (Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/empresas")
    public ResponseEntity<?> fetchEmpresaList(){
        try {
            return new ResponseEntity<>(empresaRepository.findAll(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/empresa/{id}")
    public ResponseEntity<?> updateEmpresa(@RequestBody Empresa empresa, @PathVariable("id")  Long empresaId) {

        try {
            Empresa empresaDB = empresaRepository.findById(empresaId).get();

            if (Objects.nonNull(empresa.getNombre())
                    && !"".equalsIgnoreCase(
                    empresa.getNombre())) {
                empresaDB.setNombre(
                        empresa.getNombre());
            }

            if (Objects.nonNull(
                    String.valueOf(empresa.getFecha_de_fundacion()))
                    && !"".equalsIgnoreCase(
                    String.valueOf(empresa.getFecha_de_fundacion()))) {
                empresaDB.setFecha_de_fundacion(
                        empresa.getFecha_de_fundacion());
            }

            if (Objects.nonNull(empresa.getNumero_de_nit())
                    && !"".equalsIgnoreCase(
                    empresa.getNumero_de_nit())) {
                empresaDB.setNumero_de_nit(
                        empresa.getNumero_de_nit());
            }

            empresaRepository.save(empresaDB);
            return new ResponseEntity<>(empresaDB, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/empresa/{id}")
    public ResponseEntity<?> deleteEmpresaById(@PathVariable("id") Long empresaId) {
        try {
            empresaRepository.deleteById(empresaId);

            return new ResponseEntity<>("Empresa removida!", HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
