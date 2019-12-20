package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program246 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1 : department findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		
		System.out.println("=== TEST 2 : department findAll ===");
		List <Department>list = departmentDao.findAll();
		for(Department d:list) {
			System.out.println(d);
		}
		
		System.out.println("=== TEST 3 : department insert ===");
		Department newDepartment = new Department (null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserido! Novo id = " + newDepartment.getId());
		
		System.out.println("=== TEST 4 : department update ===");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Alteracao completa");

		System.out.println("=== TEST 5 : department delete ====");
		System.out.println("Digite o id para deletar: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Departamento deletado");
		
		sc.close();
	}
}

