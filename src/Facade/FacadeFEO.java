/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Labing
 */
public class FacadeFEO implements iFacade {

    @Override
    public void insert(Object o) {
        try {
            FEO.Student student = (FEO.Student) o;
            FEO.StudentDAO cd = new FEO.StudentDAO("fjhiergreg");
            cd.createStudent(student);
                    
        } catch (SQLException | URISyntaxException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(FacadeFEO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void read() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
