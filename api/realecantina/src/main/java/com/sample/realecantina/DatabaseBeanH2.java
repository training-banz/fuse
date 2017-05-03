/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sample.realecantina;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBeanH2 {

	private DataSource dataSource;
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseBeanH2.class);

	public DatabaseBeanH2() {
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create() throws SQLException {
		LOGGER.info("start creating database");
		Statement sta = dataSource.getConnection().createStatement();
		try {
			sta.executeUpdate(
					"DROP TABLE winery;");
		} catch (SQLException e) {
			LOGGER.info("Table winery does not exist");
		}
		try {
			sta.executeUpdate(
					"CREATE TABLE winery ( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(15), state VARCHAR(15), taste VARCHAR(30));");
			sta.executeUpdate(
					"INSERT INTO winery ( name , state, taste ) VALUES ('リウッツィ',      'ピエモンテ州', 'フルボディ');");
			sta.executeUpdate(
					"INSERT INTO winery ( name , state, taste ) VALUES ('オットヴェンティ','シチリア州',   '果実味があり力強い');");
			sta.executeUpdate(
					"INSERT INTO winery ( name , state, taste ) VALUES ('デリボリ',        'ヴェネト州',   '辛口でミネラル感あり');");
			sta.executeUpdate(
					"INSERT INTO winery ( name , state, taste ) VALUES ('ヴィラベッラ',    'ヴェネト州',   '軽快');");
		} catch (SQLException e) {
			LOGGER.info("Insert Table winery failed");
		}
		LOGGER.info("end   creating database");
	}

	public void destroy() throws SQLException {
		dataSource.getConnection().close();
	}

}
