package com.suraj.spring.test;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.suraj.spring.beans.Employee;

public class EmployeeTest {

	public static void main(String[] args) throws IOException {
		
		ApplicationContext context = null;
		try {
			// if spring.xml file is not in classpath location then use complete path i.e FileSystemXmlApplicationContext.
			context = new FileSystemXmlApplicationContext("F:/ssjavalearning_workspace/spring_core/SpringCore_ApplicationContext_6.2/src/spring.xml");
			Employee employee = context.getBean("employee", Employee.class);
			System.out.println(employee.getEmpId()+"\t"+employee.getEmpName());
		} catch (BeansException e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				((AbstractApplicationContext) context).close();
			}
		}
	}
}
