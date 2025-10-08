/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * DAO 
 * @author vieri
 */
public class InscripcionDAO extends BaseDao<Inscripcion, Long> {
    
    public InscripcionDAO() {
        super(Inscripcion.class);
    }
    
    /**
     * @param cursoId ID del curso
     * @return Lista de inscripciones
     */
    public List<Inscripcion> findByCurso(Long cursoId) {
        TypedQuery<Inscripcion> query = em.createQuery(
            "SELECT i FROM Inscripcion i WHERE i.curso.cursoId = :cursoId", 
            Inscripcion.class);
        query.setParameter("cursoId", cursoId);
        return query.getResultList();
    }
}
