package ru.daedal_dev.spigrestbukkit.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.daedal_dev.spigrestbukkit.database.model.dao.ApiUserDAO;

@NoArgsConstructor
@DatabaseTable(tableName = "users", daoClass = ApiUserDAO.class)
public class ApiUser {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER = "user";
    public static final String COLUMN_TOKEN = "token";

    @Getter
    @DatabaseField(generatedId = true, columnName = COLUMN_ID)
    private int id;
    @Getter
    @DatabaseField(canBeNull = false, unique = true, columnName = COLUMN_USER)
    private String user;
    @Getter
    @DatabaseField(canBeNull = false, foreign = true, columnName = COLUMN_TOKEN)
    private ApiToken token;

    public ApiUser(String user) {
        this.user = user;
    }
}
