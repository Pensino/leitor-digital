/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import java.util.Collection;

/**
 *
 * @author emiliowl
 */
public interface DataAccessObject<T> {

    public  boolean save(T t);

    public Collection<T> all();

    public T find(Integer id);
}
