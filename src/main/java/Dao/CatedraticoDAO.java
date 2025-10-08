/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import jakarta.persistence.TypedQuery;
import java.util.Optional;



/**
 * DAO para gestionar Catedráticos
 * @author vieri
 */
public class CatedraticoDAO extends BaseDao<Catedratico, Long> {
    
    public CatedraticoDAO() {
        super(Catedratico.class);
    }
    
    /**
     * @param codigo Código del catedrático
     * @param pin PIN de seguridad
     * @return Optional con el catedrático si existe
     */
    public Optional<Catedratico> findByCodigoAndPin(String codigo, String pin) {
        TypedQuery<Catedratico> query = em.createQuery(
            "SELECT c FROM Catedratico c WHERE c.codigoCatedratico = :codigo AND c.pinSeguridad = :pin", 
            Catedratico.class);
        query.setParameter("codigo", codigo);
        query.setParameter("pin", pin);
        return query.getResultStream().findFirst();
    }
}