package com.section03.hibernatecrud.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.section03.hibernatecrud.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class studentDaoImplementation implements studentDao {

        // define field for entitty manager
        private EntityManager entityManager;

        // inject entity manager using constructor injection
        @Autowired
        public studentDaoImplementation(EntityManager entityManager) {
                this.entityManager = entityManager;
        }

        // implement save method
        @Override
        @Transactional
        public void save(student theStudent) {
                entityManager.persist(theStudent);
        }

        //Function for reading student details from database
        @Override
        public student findStudentbyId(int id) {
                return entityManager.find(student.class,id);
        }

        @Override
        public List<student> findAllStudent() {
                //defining query to be performed. No need to write Select clause as we are using TypedQuery
                TypedQuery<student> myQuery= entityManager.createQuery("from student order by lastName", student.class);

                return myQuery.getResultList();
        }
}
