package cat.itacademy.barcelonactiva.t.d.s05.t01.n01.domain.services;
import cat.itacademy.barcelonactiva.t.d.s05.t01.n01.domain.dto.SucursalDTO;

import java.util.List;
import java.util.Optional;

public interface ISucursalService {
    public SucursalDTO add(SucursalDTO sucursalDTO);
    public SucursalDTO update(SucursalDTO sucursalDTO);
    public void delete(int id);
    public Optional<SucursalDTO> getOne(int id);
    public List<SucursalDTO> getAll();

}
