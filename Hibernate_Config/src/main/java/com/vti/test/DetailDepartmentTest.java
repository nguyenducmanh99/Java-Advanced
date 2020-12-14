package com.vti.test;

import java.util.List;
import com.vti.entity.DetailDepartment;
import com.vti.repository.DetailDepartmentRepository;

public class DetailDepartmentTest {
	public static void main(String[] arg) {
		DetailDepartmentRepository repository = new DetailDepartmentRepository();

		System.out.println("***********GET ALL DetailDepartment***********");

		List<DetailDepartment> DetailDepartments = repository.getAllDetailDepartments();
		for (DetailDepartment detailDepartment : DetailDepartments) {
			System.out.println(detailDepartment);
			 
		System.out.println("Tao thanh cong");
		}
 }
}