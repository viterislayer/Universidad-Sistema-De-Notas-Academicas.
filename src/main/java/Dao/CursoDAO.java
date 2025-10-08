/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import com.umg.universidadproyecto.model.Curso;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * DAO para gestionar Cursos
 * @author vieri
 */
public class CursoDAO extends BaseDao<Curso, Long> {
    
    public CursoDAO() {
        super(Curso.class);
    }
    
    /**
     * @param catedraticoId ID del catedrático
     * @return Lista de cursos
     */
    public List<Curso> findByCatedratico(Long catedraticoId) {
        TypedQuery<Curso> query = em.createQuery(
            "SELECT c FROM Curso c WHERE c.catedratico.catedraticoId = :catedraticoId", 
            Curso.class);
        query.setParameter("catedraticoId", catedraticoId);
        return query.getResultList();
    }
}