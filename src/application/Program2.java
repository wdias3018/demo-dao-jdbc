package application;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);

		System.out.println("=== TEST 1: department findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);

			
		System.out.println("\n=== TEST 3: department findAll ====");	
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: department insert ====");
		Department newDepartment = new Department(null, "DP_NOVO");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 5: department update ====");
		department = departmentDao.findById(1);
		department.setName("DEP_NEW");
		departmentDao.update(department);
		System.out.println("Update complete!");
		
		System.out.println("\n=== TEST 6: department delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		sc.close();
		
	}

}
