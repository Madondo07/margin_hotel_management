package za.ac.cput.marginhotelmanagement.service;
/*
   Author: Katlego Malaka (230443370)
   Date: 09 July 2026
*/

public interface IService<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
