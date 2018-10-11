/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import FEO.Student;
import quizjpa.Dao;
/**
 * @author Labing
 */
public class FacadeJPA implements iFacade {

    @Override
    public void insert(Object o) {
        FEO.Student student = (FEO.Student) o;
        quizjpa.Student std= new quizjpa.Student();
        std.setName(student.getName());
        std.setLastName(student.getLast_name());
        Dao d=new Dao();
        d.prueba(std);
        
    }

    @Override
    public void read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
