package cat.itacademy.barcelonactiva.t.d.s05.t01.n01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;
import java.util.Optional;
import cat.itacademy.barcelonactiva.t.d.s05.t01.n01.domain.services.ISucursalService;
import cat.itacademy.barcelonactiva.t.d.s05.t01.n01.domain.dto.SucursalDTO;


@Controller
public class SucursalController {
    @Autowired
	private ISucursalService sucursalService;

	@GetMapping("/")
	public String home(Model model) {
		return "redirect:/sucursal";
	}

	@GetMapping("/sucursal")
	public String getAll(Model model) {
		model.addAttribute("_allSucursals", sucursalService.getAll());
		List<SucursalDTO> a  = sucursalService.getAll();
		return "index";
		//return new ResponseEntity<>(sucursalService.getAll(), HttpStatus.OK);
	}    
	
	@GetMapping("/sucursal/add")
	public String add(Model model){
		SucursalDTO _sucursalDTO = new SucursalDTO();
		model.addAttribute("_sucursalDTO", _sucursalDTO);
		return "add";
	}

	@PostMapping("/sucursal/add")
	public String add(@ModelAttribute SucursalDTO _sucursalDTO, Errors errors) {
		if(errors.hasErrors()){
			return "add";
		}
		try {
			sucursalService.add(_sucursalDTO);
		} catch (Exception e) {
			return "add";
		}
		return "redirect:/sucursal";
	}

	@GetMapping("/sucursal/getOne/{id}")
	public ResponseEntity<SucursalDTO> getOne(@PathVariable("id") int id) {
		Optional<SucursalDTO> _sucursalDto = sucursalService.getOne(id);
		if (_sucursalDto.isPresent()) {
			return new ResponseEntity<>(_sucursalDto.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}    


	@GetMapping("/sucursal/update/{id}")
	public String update(@PathVariable("id") int id, Model model) {
		Optional<SucursalDTO> _sucursalDto = sucursalService.getOne(id);
		if (_sucursalDto.isPresent()) {
			model.addAttribute("_sucursalDto", _sucursalDto);
		} else {
			return "redirect:/sucursal";
		}
		return "update";
	}
	@PostMapping("/sucursal/update")
	public String update(@ModelAttribute SucursalDTO _sucursalDTO, Errors errors) {
		if(errors.hasErrors()){
			return "add";
		}
		try {
			sucursalService.add(_sucursalDTO);
		} catch (Exception e) {
			return "add";
		}
		return "redirect:/sucursal";
	}
	@GetMapping("/sucursal/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		sucursalService.delete(id);
		return "redirect:/sucursal";
	}
}
