package ru.itis.dao.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.dao.AutoDao;
import ru.itis.model.Auto;
import ru.itis.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 20.02.2017
 * AutoDaoJdbcImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component("jdbc.auto.dao")
public class AutoDaoJdbcImpl implements AutoDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //language=SQL
    private final String SQL_SELECT_ALL_BY_USER_ID =
            "SELECT * FROM auto a,group_member member WHERE member_id = :userId AND member.id = a.member_id";

    private User currentUser;

    @Autowired
    public AutoDaoJdbcImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.currentUser = null;
    }

    private RowMapper<Auto> autoRowMapper = (rs, rowNum) -> {
        Auto auto = new Auto(rs.getLong("id"), rs.getString("model"), null);

        if (currentUser == null) {
            currentUser = new User(rs.getLong(4), rs.getInt("age"), rs.getString("name"), new ArrayList<>());
        }

        currentUser.getAutos().add(auto);
        auto.setUser(currentUser);
        return auto;
    };

    public Long save(Auto auto) {
        return null;
    }

    public void update(Auto auto) {

    }

    public Auto find(Long id) {
        return null;
    }

    public void delete(Long id) {

    }

    public List<Auto> findAll() {
        return null;
    }

    public List<Auto> findAllByUserId(Long userId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        List<Auto> autos = namedParameterJdbcTemplate.query(SQL_SELECT_ALL_BY_USER_ID, paramMap, autoRowMapper);
        currentUser = null;
        return autos;
    }
}
