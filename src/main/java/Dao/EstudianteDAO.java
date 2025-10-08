/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import com.umg.universidadproyecto.model.Estudiante;
import jakarta.persistence.TypedQuery;
import java.util.Optional;

/**
 * DAO para gestionar Estudiantes
 * @author vieri
 */
public class EstudianteDAO extends BaseDao<Estudiante, Long> {
    
    public EstudianteDAO() {
        super(Estudiante.class);
    }
    
    /**
     * @param carnet Carnet del estudiante
     * @return Optional con el estudiante si existe
     */
    public Optional<Estudiante> findByCarnet(String carnet) {
        TypedQuery<Estudiante> query = em.createQuery(
            "SELECT e FROM Estudiante e WHERE e.carnet = :carnet", 
            Estudiante.class);
        query.setParameter("carnet", carnet);
        return query.getResultStream().findFirst();
    }
}