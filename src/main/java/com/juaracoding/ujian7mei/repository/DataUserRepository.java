package com.juaracoding.ujian7mei.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.juaracoding.ujian7mei.entity.DataUser;

public interface DataUserRepository extends CrudRepository<DataUser, Long>{
	@Query(value = "select * from data_user where name Like %?1%",nativeQuery = true)
	List<DataUser> getDataByName(String name);
	
//	@Query(value = "SELECT * FROM data_user ORDER BY name",nativeQuery = false)
//	List<DataUser> findByNama(String name);
//	
//	@Query(value = "SELECT * FROM data_user ORDER BY email",nativeQuery = false)
//	List<DataUser> findByEmail(String email);
//	
//	@Query(value = "SELECT * FROM data_user ORDER BY phone",nativeQuery = false)
//	List<DataUser> findByPhone(String phone);
//	
//	@Query(value = "SELECT * FROM data_user ORDER BY address",nativeQuery = false)
//	List<DataUser> findByAddress(String address);
}
