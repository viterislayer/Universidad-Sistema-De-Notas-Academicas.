/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umg.universidadproyecto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author vieri
 */
public class UniversidadProyecto {

    public static void main(String[] args) {
        System.out.println("Hello World mi viteri proyecto!");
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("universidadPU");
            EntityManager em = emf.createEntityManager();
            System.out.println(" Pueva de mi conexión de la base de datos UniversidadProyecto.");
            em.close();
            emf.close();
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

    
