package com.universe.tasks.config;


import com.universe.tasks.model.Universe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UniverseRowMapper implements RowMapper<Universe> {

    @Override
    public Universe mapRow(ResultSet rs, int rowNum) throws SQLException {
        Universe universe = new Universe();
        universe.setUniverseId(rs.getInt("universe_id"));
        universe.setUniverseName(rs.getString("universe_name"));
        return universe;
    }

}