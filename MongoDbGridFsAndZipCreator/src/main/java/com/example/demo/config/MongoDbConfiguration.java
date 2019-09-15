//package com.example.demo.config;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import com.example.demo.Dao.CarRepo;
//import com.example.demo.dao.EmployeeRepo;
//import com.example.demo.model.Car;
//import com.example.demo.model.Employee;
//
//@EnableMongoRepositories(basePackageClasses = {CarRepo.class,EmployeeRepo.class})
//@Configuration
//public class MongoDbConfiguration {
//
////	@Bean
////	CommandLineRunner commandLineRunner(CarRepo carRepo) {
////		return strings->
////			carRepo.save(new Car(1,"a","b","c"));
////	};
//	
////	@Bean
////	CommandLineRunner commandLineRunner(EmployeeRepo employeeRepo) {
////		return strings->
////			employeeRepo.save(new Employee().setEmpId(1).setName("Koushal"));
////	};
//	
//}
// 