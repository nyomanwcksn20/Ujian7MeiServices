package com.juaracoding.ujian7mei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.ujian7mei.entity.DataUser;
import com.juaracoding.ujian7mei.repository.DataUserRepository;

@RestController
@RequestMapping("/dataUser")
public class DataUserController {

	@Autowired
	DataUserRepository dataUserRepo;
	
	@GetMapping("/")
	public List<DataUser> getAll() {
		return (List<DataUser>) dataUserRepo.findAll();
	}
	
	@GetMapping("/{name}")
	public List<DataUser> getAll(@PathVariable String name){
		return (List<DataUser>)dataUserRepo.getDataByName(name);
		
	}
	
	@PostMapping("/add")
	public String addDataUser(@RequestBody DataUser dataUser) {
		dataUserRepo.save(dataUser);
		return "Insert Berhasil";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDataUser(@PathVariable String id) {
		dataUserRepo.deleteById(Long.parseLong(id));
		return "Delete Berhasil";
	}
	
	@PutMapping("/update/{id}")
	public String updateDataUser(@PathVariable String id, @RequestBody DataUser dataUser){
		dataUser.setId(Long.parseLong(id));
		dataUserRepo.save(dataUser);
		return "Update Berhasil";
	}
	
//	@GetMapping("/sortName")
//	public List<DataUser> getByName(@PathVariable String name){
//		return (List<DataUser>)dataUserRepo.findByNama(name);
//	}
//	
//	@GetMapping("/sortPhone")
//	public List<DataUser> getByPhone(@PathVariable String phone){
//		return (List<DataUser>)dataUserRepo.findByPhone(phone);
//	}
}
