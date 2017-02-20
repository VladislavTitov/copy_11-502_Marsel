package ru.itis.dao;

import ru.itis.model.Auto;

import java.util.List;

/**
 * 20.02.2017
 * AutoDao
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AutoDao extends BaseDao<Auto> {
    List<Auto> findAllByUserId(Long userId);
}
