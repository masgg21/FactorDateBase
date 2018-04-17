package com.xatu.Statement;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @author Administrator
 *
 */
public interface CreateStatement {
    public Statement createStatement(Connection con);
}
