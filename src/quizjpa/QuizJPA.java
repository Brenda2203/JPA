/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizjpa;

import Facade.FacadeFactory;
/**
 *
 * @author Labing
 */
public class QuizJPA {

    public static void main(String[] args) {
        FEO.Student std=new FEO.Student();
        std.setName("Juan");
        std.setLast_name("Perez");
        FacadeFactory.getFacade("jpa").insert(std);
    }
    
}
