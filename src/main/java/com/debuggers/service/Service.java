package com.debuggers.service;

public interface Service <T ,ID>{
    T create(T t);
    T update(T t);
    void delete(ID id);
}
