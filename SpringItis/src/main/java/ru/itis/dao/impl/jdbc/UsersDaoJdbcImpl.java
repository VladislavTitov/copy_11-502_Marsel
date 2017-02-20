package ru.itis.dao.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.dao.UsersDao;
import ru.itis.model.Auto;
import ru.itis.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class UsersDaoJdbcImpl implements UsersDao {

    private JdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM group_member WHERE  id=?";

    //language=SQL
    private final String SQL_SELECT_ALL_USERS = "SELECT * FROM group_member";

    //language=SQL
    private final String SQL_SELECT_ALL_AUTOS = "SELECT * FROM auto";

    //language=SQL
    private final String SQL_SELECT_AUTOS_USERS_JOIN = "SELECT * FROM group_member " +
            "JOIN auto ON group_member.id = auto.member_id";

    //language=SQL
    private final String SQL_SELECT_USERS_BY_AGE = "SELECT * FROM group_member WHERE age = ?";

    private Map<Long, User> usersMap;

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getLong("id"), rs.getInt("age"),
                    rs.getString("name"), new ArrayList<Auto>());

            usersMap.put(user.getId(), user);
            return user;
        }
    };

    private RowMapper<Auto> autoRowMapper = new RowMapper<Auto>() {
        public Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Auto auto = new Auto(rs.getLong("id"), rs.getString("model"), null);
            auto.setUser(usersMap.get(rs.getLong("member_id")));
            usersMap.get(auto.getUser().getId()).getAutos().add(auto);
            return auto;
        }
    };

    @Autowired
    public UsersDaoJdbcImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
        usersMap = new HashMap<Long, User>();
    }

    public List<User> findByAge(int age) {
        return template.query(SQL_SELECT_USERS_BY_AGE, new Object[]{age}, userRowMapper);
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
        template.query(SQL_SELECT_ALL_USERS, userRowMapper);
        template.query(SQL_SELECT_ALL_AUTOS, autoRowMapper);
        return new ArrayList<User>(usersMap.values());
    }
}
