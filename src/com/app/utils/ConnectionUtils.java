package com.app.utils;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.entity.UserDetails;

public class ConnectionUtils {

	private static final SessionFactory SESSION_FACTORY;

	/*
	 * static { SESSION_FACTORY = (SessionFactory) new AnnotationConfiguration()
	 * .addPackage("com.app.entity") .addProperties(getDataSourcePropety())
	 * .buildSessionFactory(); }
	 */

	static {
		//.addPackage("com.app.entity")
		SESSION_FACTORY = (SessionFactory) new Configuration()
		.addAnnotatedClass(UserDetails.class)
				.addProperties(getDataSourcePropety()).buildSessionFactory();
	}

	public static Session getInstance() {
		return SESSION_FACTORY.openSession();
	}

	private static Properties getDataSourcePropety() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
		prop.setProperty("hibernate.connection.username", "root");
		prop.setProperty("hibernate.connection.password", "root");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.hbm2ddl.auto", "create");
		prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

		return prop;

	}

}
