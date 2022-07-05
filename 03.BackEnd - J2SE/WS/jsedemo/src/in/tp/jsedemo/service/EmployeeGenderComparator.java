package in.tp.jsedemo.service;

import java.util.Comparator;

import in.tp.jsedemo.model.Employee;

public class EmployeeGenderComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getGender().compareTo(o2.getGender());
	}

}
