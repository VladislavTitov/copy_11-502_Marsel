package ru.itis.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.dao.UsersDao;
import ru.itis.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UsersDaoJdbcImpl implements UsersDao {

    private JdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM group_member WHERE  id=?";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM group_member";

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getLong("id"),
                    rs.getInt("age"),
                    rs.getString("name"));
        }
    };

    @Autowired
    public UsersDaoJdbcImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    public List<User> findByAge(int age) {
        return null;
    }

    // TODO: get id from jdbc after insert query - GOOGLE IT
    public Long save(User user) {
        return null;
    }

    public void update(User user) {

    }

    public User find(Long id) {
        return template.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, userRowMapper);
    }

    public void delete(Long id) {

    }

    public List<User> findAll() {
        return template.query(SQL_SELECT_ALL, userRowMapper);
    }
}
