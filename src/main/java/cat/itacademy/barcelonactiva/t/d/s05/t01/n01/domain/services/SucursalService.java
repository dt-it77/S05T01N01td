package cat.itacademy.barcelonactiva.t.d.s05.t01.n01.domain.services;

import cat.itacademy.barcelonactiva.t.d.s05.t01.n01.domain.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.t.d.s05.t01.n01.domain.model.Sucursal;
import cat.itacademy.barcelonactiva.t.d.s05.t01.n01.domain.repository.SucursalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalService implements ISucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    public SucursalDTO add(SucursalDTO sucursal){
		sucursalRepository.save(translateToModel(sucursal));
		return sucursal;
		//return translateToDto(sucursalRepository.save(sucursal));
	}

	public SucursalDTO update(SucursalDTO updateFruida){
		sucursalRepository.save(translateToModel(updateFruida));
		return updateFruida;
       //return translateToDto(sucursalRepository.save(updateFruida));
    }
	
	public void delete(int id){
		sucursalRepository.deleteById(id);		
    }
	public Optional<SucursalDTO> getOne(int id){	
		return sucursalRepository.findById(id)
		.stream()
		.map(this::translateToDto)
		.findFirst();		
	}
	public List<SucursalDTO> getAll(){
		return sucursalRepository.findAll()
		.stream()
		.map(this::translateToDto)
		.collect(Collectors.toList());
	}
	public SucursalDTO translateToDto(Sucursal sucursal){
		return new SucursalDTO(sucursal.getId(),sucursal.getNom(),sucursal.getPais());
	}
	public Sucursal translateToModel(SucursalDTO sucursalDto){
		return new Sucursal(sucursalDto.getPk_SucursalID(),sucursalDto.getNomSucursal(),sucursalDto.getPaisSucursal());
	}	
}