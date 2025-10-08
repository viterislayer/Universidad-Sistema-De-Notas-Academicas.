/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 * @param <T> Tipo de entidad
 * @param <ID> Tipo de identificador
 */
public abstract class BaseDao<T, ID> {
    
    @PersistenceContext(unitName = "universidadPU")
    protected EntityManager em;
    
    private final Class<T> entityClass;
    
    public BaseDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    /**
     * @param entity Entidad a guardar
     * @return Entidad guardada
     */
    public T save(T entity) {
        em.persist(entity);
        return entity;
    }
    
    /**
     * @param entity Entidad a actualizar
     * @return Entidad actualizada
     */
    public T update(T entity) {
        return em.merge(entity);
    }
    
    /**
     * @param id Identificador de la entidad
     */
    public void delete(ID id) {
        T entity = findById(id);
        if (entity != null) {
            em.remove(entity);
        }
    }
    
    /**
     * @param id Identificador de la entidad
     * @return Entidad encontrada o null
     */
    public T findById(ID id) {
        return em.find(entityClass, id);
    }
    
    /**
     * @return Lista de todas las entidades
     */
    public List<T> findAll() {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return em.createQuery(jpql, entityClass).getResultList();
    }
}