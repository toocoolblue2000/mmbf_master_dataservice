package in.co.mmbf.services.data;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import ch.qos.logback.core.db.dialect.H2Dialect;

@Configuration
public class ServiceConfiguration {

	@Bean(name="postalCodeCsvDataSource")
	public DataSource postalCodeCsvDataSource() {
		BasicDataSource postalCodeCsvDataSource = new BasicDataSource();
        postalCodeCsvDataSource.setUrl("jdbc:relique:csv:all_india_pin_code.csv");
        postalCodeCsvDataSource.setConnectionProperties("columnTypes=string,int,string,string,string,string,string,string,string,string; hibernate.dialect=org.hibernate.dialect.H2Dialect ");
        return postalCodeCsvDataSource;


	}

	@Bean
	@Primary
	@Profile("mock")
	public DataSource h2DataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2)
			.addScript("import.sql")
			.build();
		return db;
	}

	@Bean
	@Primary
	@Profile("!mock")
	public DataSource dbDataSource() {
		BasicDataSource postalCodeCsvDataSource = new BasicDataSource();
        /*postalCodeCsvDataSource.setUrl("jdbc:relique:csv:all_india_pin_code.csv");
        postalCodeCsvDataSource.setConnectionProperties("columnTypes=string,int,string,string,string,string,string,string,string,string");*/
        return postalCodeCsvDataSource;
	}

	@Bean
	public HibernateJpaVendorAdapter getJpaAdapter() {
		HibernateJpaVendorAdapter mysqlAdapter = new HibernateJpaVendorAdapter();
		mysqlAdapter.setDatabase(Database.H2);
		mysqlAdapter.setDatabasePlatform(H2Dialect.class.getName());
		mysqlAdapter.setShowSql(true);
		return mysqlAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(postalCodeCsvDataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(getJpaAdapter());
		return entityManagerFactoryBean;
	}

	@Bean
    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
         HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
         factory.setEntityManagerFactory(emf);
         Properties props = new Properties();
         props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
         factory.setJpaProperties(props);
         return factory;
    }

	/*@Bean
	public TomcatEmbeddedServletContainerFactory tomcatFactory() {
	    return new TomcatEmbeddedServletContainerFactory() {

	    	@Override
	    	protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) {
	    		tomcat.enableNaming();
	    		return super.getTomcatEmbeddedServletContainer(tomcat);
	    	}

	    	@Override
	    	protected void postProcessContext(Context context) {
	    		ContextResource resource = new ContextResource();
	            resource.setName("jdbc/myDataSource");
	            resource.setType(DataSource.class.getName());
	            resource.setProperty("driverClassName", "your.db.Driver");
	            resource.setProperty("url", "jdbc:yourDb");
	            context.getNamingResources().addResource(resource);
	    	}

	    };
	}*/
}
