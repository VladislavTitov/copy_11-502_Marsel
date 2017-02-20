package ru.itis.dao;

import java.util.List;

public interface BaseDao<Model> {
    /**
     * Сохраняет модель в хранилище данных
     * @param model сохраняемая модель
     * @return ID модели
     */
    Long save(Model model);

    void update(Model model);

    Model find(Long id);

    void delete(Long id);

    List<Model> findAll();
}
