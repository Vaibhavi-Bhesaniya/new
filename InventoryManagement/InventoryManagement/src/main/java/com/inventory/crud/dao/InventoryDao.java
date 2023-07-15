package com.inventory.crud.dao;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.inventory.crud.model.Inventory;


public class InventoryDao {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			try {
				Configuration configuration = new Configuration();

				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/inventorycrud?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Inventory.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate java configuration serviceRegistrery created");
				sessionFactory = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);

				return sessionFactory;

			} catch (Exception e) {
				System.err.println(e);
			}

		}
		return sessionFactory;
	}
	
	public static void saveInventory(Inventory inventory) {
		Transaction transaction = null;
		int status = 0;
		try (Session session = getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			status = (int) session.save(inventory);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		System.out.println("Status is >>>"+status);
	}
}
