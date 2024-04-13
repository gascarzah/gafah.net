package com.gafahtec.controller;

import java.io.File;
import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gafahtec.dto.MascotaDto;
import com.gafahtec.exception.ModeloNotFoundException;
import com.gafahtec.model.Cliente;
import com.gafahtec.model.Mascota;
import com.gafahtec.model.Raza;
import com.gafahtec.service.CloudinaryService;
import com.gafahtec.service.FilesStorageService;
import com.gafahtec.service.IMascotaService;
import com.gafahtec.util.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/mascotas")
@AllArgsConstructor
@Slf4j
public class MascotaController {

	private IMascotaService iMascotaService;
	
	private FilesStorageService storageService;
	private CloudinaryService cloudinaryService;
	
	@GetMapping
	public ResponseEntity<List<Mascota>> listar() throws Exception{
		List<Mascota> lista = iMascotaService.listar();
		
		return new ResponseEntity<List<Mascota>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mascota> listarPorId(@PathVariable("id") Integer id, Authentication authentication) throws Exception{
		Mascota obj = iMascotaService.listarPorId(id);
		System.out.println(obj);
		if(obj.getIdMascota() == null) {
			throw new ModeloNotFoundException("Id no encontrado " + id );
		}
		
		return new ResponseEntity<Mascota>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Mascota> registrar(@Valid @RequestBody MascotaDto dto, Authentication authentication) throws Exception{
		System.out.println("==> "+dto);
		

		System.out.println("registrar mascota");
		
		File file = new File(dto.getImage());
		Map<String, String> map = cloudinaryService.upload(file);
		System.out.println("map ===> "+map);
		
		var p = Mascota.builder()
		.nombre(dto.getNombre())
		.sexo(dto.getSexo())
		.peso(dto.getPeso())
		.image(map.get("secure_url"))
		.cliente(Cliente.builder().idCliente(dto.getIdCliente()).build())
		.raza(Raza.builder().idRaza(dto.getIdRaza()).build()).build();
		System.out.println(p);
		Mascota obj = iMascotaService.registrar(p);
		System.out.println(obj);
		//borrar archivo
		
		FileUtils.forceDeleteOnExit(file);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMascota()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Mascota> modificar(@Valid @RequestBody MascotaDto dto, Authentication authentication) throws Exception{
		System.out.println("==> "+dto);
		var p = Mascota.builder()
				.idMascota(dto.getIdMascota())
		.nombre(dto.getNombre())
		.sexo(dto.getSexo())
		.peso(dto.getPeso())
		.cliente(Cliente.builder().idCliente(dto.getIdCliente()).build())
		.raza(Raza.builder().idRaza(dto.getIdRaza()).build()).build();
		
		Mascota obj = iMascotaService.modificar(p);
		return new ResponseEntity<Mascota>(obj, HttpStatus.OK);
	}
	
	@PostMapping(consumes = { "multipart/form-data" }, value = "/post-image" )
	public ResponseEntity<ResponseMessage> uploadFile(@Valid @RequestBody MultipartFile  image) throws Exception{
		 String message = "";
		 ResponseMessage obj = new ResponseMessage();   
		 try {
//		      List<String> fileNames = new ArrayList<>();
//		      Arrays.asList(image).stream().forEach(file -> {
//		        storageService.save(file);
//		        fileNames.add(file.getOriginalFilename());
//		        
//		      });
		      
//		      System.out.println("+++>>>"+storageService.load(image.getOriginalFilename()));
		      
		      String ruta = storageService.save(image);
		      
		      message = "Uploaded the files successfully: " + image.getOriginalFilename();
//		      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		      
		      obj.setMessage(message);
		      obj.setRuta(ruta);
		      System.out.println(">>>>>>>ruta >>>> "+ruta);
		      System.out.println(">>>>>>>message >>>> "+message);
		      return new ResponseEntity<ResponseMessage>(obj, HttpStatus.OK);
		    } catch (Exception e) {
		      e.printStackTrace();
		      message = "Fail to upload files!";
		      obj.setMessage(message);
//		      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		      return new ResponseEntity<ResponseMessage>(obj, HttpStatus.EXPECTATION_FAILED);
		    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id, Authentication authentication) throws Exception{
		Mascota obj = iMascotaService.listarPorId(id);
		
		if(obj.getIdMascota() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
			
		iMascotaService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Mascota>> listarPageable(@PageableDefault(sort = "nombre")Pageable pageable) throws Exception{			
		Page<Mascota> Mascotas = iMascotaService.listarPageable(pageable);
		return new ResponseEntity<Page<Mascota>>(Mascotas, HttpStatus.OK);
	}
	
//	@GetMapping
//	public ResponseEntity<List<Mascota>> listarOrdenadoPorId() throws Exception{
//		List<Mascota> lista = iMascotaService.listarOrderById();
//		return new ResponseEntity<List<Mascota>>(lista, HttpStatus.OK);
//	}
	
}
