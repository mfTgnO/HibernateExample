package com.ch1.hibernate.ch05.main;

import com.ch1.hibernate.ch01.model.Employee1;
import com.ch1.hibernate.ch03.util.HibernateAnnotationUtil;
import com.ch1.hibernate.ch05.model.Address;
import com.ch1.hibernate.ch05.model.EmployeeBenefits;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

public class HQLExamples {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //Prep work
        SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

//        test1(session);
//        test2(session);
//        test3(session);
        test4(session);
//        test5(session);
//        test6(session);
//        test7(session);
//        test8(session);
//        test9(session);
//        test10(session);

        //rolling back to save the test data
        tx.rollback();
        //closing hibernate resources
        sessionFactory.close();
    }

    //HQL example - Get All Employees
    private static void test1(Session session) {
        Query query = session.createQuery("from EmployeeBenefits");
        List<EmployeeBenefits> empList = query.list();
        for (EmployeeBenefits emp : empList) {
            System.out.println("List of Employees::" + emp.getId() + "," + emp.getAddress().getCity());
        }
    }

    //HQL example - Get Employee with id
    private static void test2(Session session) {
        Query query = session.createQuery("from EmployeeBenefits where id=:id");
        query.setLong("id", 3);
        EmployeeBenefits emp = (EmployeeBenefits) query.uniqueResult();
        System.out.println("Employee Name=" + emp.getName() + ", City=" + emp.getAddress().getCity());
    }

    //HQL pagination example
    private static void test3(Session session) {
//        Query query = session.createQuery("from EmployeeBenefits");
        Query query = session.createQuery("from Address");
        query.setFirstResult(0);//starts with 0
//        query.setFetchSize(2);
        query.setMaxResults(2);
        List<Address> empList = query.list();
        for (Address emp : empList) {
            System.out.println(emp);
        }
    }

    //HQL Update Employee
    private static void test4(Session session) {
        /*Query query = session.createQuery("update EmployeeBenefits set emp_name = :name where emp_id = :id");
        query.setParameter("name", "aaaa");
        query.setParameter("id", 1);*/
        Query query = session.createQuery("update EmployeeBenefits set name= :emp_name WHERE id= :emp_id");
        query.setParameter("emp_name", "Pankaj Kumar");
        query.setLong("emp_id", 1);
        int result = query.executeUpdate();
        System.out.println("EmployeeBenefits Update Status=" + result);
    }

    //HQL Delete Employee, we need to take care of foreign key constraints too
    private static void test5(Session session) {
        Query query = session.createQuery("delete from Address where emp_id = :id");
        query.setLong("id", 3);
        int result = query.executeUpdate();
        System.out.println("Address Delete Status=" + result);

        query = session.createQuery("delete from EmployeeBenefits where emp_id = :id");
        query.setLong("id", 3);
        result = query.executeUpdate();
        System.out.println("EmployeeBenefits Delete Status=" + result);
    }

    //HQL Aggregate function examples
    private static void test6(Session session) {
        Query query = session.createQuery("select sum(salary) from EmployeeBenefits");
        Double sumSalary = (Double) query.uniqueResult();
        System.out.println("Sum of all Salaries= " + sumSalary);
    }

    //HQL join examples
    private static void test7(Session session) {
        Query query = session.createQuery("select e.name,a.city from EmployeeBenefits AS e INNER JOIN e.address a");
        List<Object[]> list = query.list();
        for (Object[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //HQL group by and like example
    private static void test8(Session session) {
        Query query = session.createQuery("select e.name,sum(e.salary),count(e) from EmployeeBenefits e where e.name like '%i%' group by e.name");
        List<Object[]> list = query.list();
        for (Object[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //HQL order by example
    private static void test9(Session session) {
        Query query = session.createQuery("from EmployeeBenefits e order by e.id asc");
//        Query query = session.createQuery("from EmployeeBenefits order by id desc");
        List<EmployeeBenefits> list = query.list();
        for (EmployeeBenefits emp : list) {
            System.out.println("ID Desc Order Employee::" + emp.getId() + "," + emp.getAddress().getCity());
        }
    }

    private static void test10(Session session) {
        Query query = session.createQuery("from Employee1 order by id desc");
        List<Employee1> list = query.list();
        for (Employee1 emp : list) {
            System.out.println(emp);
        }
    }
}
