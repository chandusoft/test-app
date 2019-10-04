package com.scp.spring.hbb1;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {

	static SessionFactory sfactory =null;
	public static SessionFactory getSessionFactory() {
		if(sfactory==null) {
			sfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return sfactory;
	}
	
	static public void addProduct(Product prod) {
		SessionFactory sfactory = getSessionFactory();
		Session session = sfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(prod);
		cleanUpResources(session,tr);
		System.out.println("Product Saved Successfully....!");
	}

	private static void cleanUpResources(Session session, Transaction tr) {
			if(session!=null) {
				if(tr!=null) {
					session.flush();
					tr.commit();
				}
				session.close();
			}
	}

	static public Product getProduct(int pid) {
		SessionFactory sfactory = getSessionFactory();
		Session session = sfactory.openSession();
		Product product = (Product) session.get(Product.class, pid);
		cleanUpResources(session,null);
		System.out.println(product);
		return product;
}

	static public void getAllProducts() {
		SessionFactory sfactory = getSessionFactory();
		Session session = sfactory.openSession();
		Query query = session.createQuery("from product21");
		List<Product> products = query.list();
		cleanUpResources(session,null);
		System.out.println(products);
		
	}
	static public void updateProduct(Product prod) {
		Product dbProduct = getProduct(prod.getProductId());
		if(dbProduct!=null) {
			SessionFactory sfactory = getSessionFactory();
			Session session = sfactory.openSession();
			Transaction tr = session.beginTransaction();
			//dbProduct.setProductLabel(prod.getProductLabel());
			//dbProduct.setProductName(prod.getProductName());
		//	dbProduct.setProductPrice(prod.getProductPrice());
		//	dbProduct.setProductQty(prod.getProductQty());
			session.update(prod);
			System.out.println("Product Updated Successfully...!");
			cleanUpResources(session,tr);
		}else {
			System.out.println("Product not found so cannot update");
		}
	}
	static public void deleteProduct(int pid) {
		Product dbProduct = getProduct(pid);
		if(dbProduct!=null) {
			SessionFactory sfactory = getSessionFactory();
			Session session = sfactory.openSession();
			Transaction tr = session.beginTransaction();
			//dbProduct.setProductLabel(prod.getProductLabel());
			//dbProduct.setProductName(prod.getProductName());
		//	dbProduct.setProductPrice(prod.getProductPrice());
		//	dbProduct.setProductQty(prod.getProductQty());
			session.delete(dbProduct);
			System.out.println("Product deleted Successfully...!");
			cleanUpResources(session,tr);
		}else {
			System.out.println("Product not found so cannot delete");
		}
	}

	public static void main(String[] args) {

		Product p1 = new Product(11,"TYAAA","XXXX",23, 833);
		Product p2 = new Product(1,"ABBA","cXX",223, 2853);
		Product p3 = new Product(311,"AAxx","gXXX",3, 28853);
		Product p4 = new Product(133,"YYAAA","XtXXX",33, 2833);
		Product p5 = new Product(1114,"XXXXX","XXXXX",44, 8888);
		getProduct(1114);
		
	}
}
