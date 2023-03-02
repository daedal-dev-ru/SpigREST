package ru.daedal_dev.spigrestbukkit.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.daedal_dev.spigrestbukkit.database.model.dao.ApiTokenDAO;

import java.util.Date;

@NoArgsConstructor
@DatabaseTable(tableName = "tokens", daoClass = ApiTokenDAO.class)
public class ApiToken {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TOKEN = "token";
    public static final String COLUMN_ADMIN = "admin";
    public static final String COLUMN_SERVER = "server";
    public static final String COLUMN_DEVELOPER = "developer";
    public static final String COLUMN_PLAYER = "player";
    public static final String COLUMN_BAN = "ban";
    public static final String COLUMN_CREATED_AT = "created_at";

    @Getter
    @DatabaseField(generatedId = true, columnName = COLUMN_ID)
    private int id;
    @Getter
    @DatabaseField(unique = true, columnName = COLUMN_TOKEN)
    private String token;
    @Getter @Setter
    @DatabaseField(defaultValue = "false", columnName = COLUMN_ADMIN)
    private boolean admin;
    @Getter @Setter
    @DatabaseField(defaultValue = "false", columnName = COLUMN_SERVER)
    private boolean server;
    @Getter @Setter
    @DatabaseField(defaultValue = "true", columnName = COLUMN_PLAYER)
    private boolean player;
    @Getter @Setter
    @DatabaseField(defaultValue = "false", columnName = COLUMN_DEVELOPER)
    private boolean developer;
    @Getter @Setter
    @DatabaseField(defaultValue = "true", columnName = COLUMN_BAN)
    private boolean ban;
    @Getter
    @DatabaseField(columnName = COLUMN_CREATED_AT)
    private Date created_at;
}
