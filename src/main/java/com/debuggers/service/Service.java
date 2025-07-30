package com.debuggers.service;
/*

     Author: Bonga Velem (220052379)

    */
public interface Service <T ,ID>{
    T create(T t);
    T update(T t);
    void delete(ID id);
}
