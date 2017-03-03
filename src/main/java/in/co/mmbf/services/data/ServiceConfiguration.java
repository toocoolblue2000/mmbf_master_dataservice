package in.co.mmbf.services.data;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class ServiceConfiguration {

	@Bean(name="postalCodeCsvDataSource")
	public DataSource postalCodeCsvDataSource() {
		BasicDataSource postalCodeCsvDataSource = new BasicDataSource();
        postalCodeCsvDataSource.setUrl("jdbc:relique:csv:all_india_pin_code.csv");
        postalCodeCsvDataSource.setConnectionProperties("columnTypes=string,int,string,string,string,string,string,string,string,string");
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
        postalCodeCsvDataSource.setUrl("jdbc:relique:csv:https://data.gov.in/resources/all-india-pincode-directory/download");
        postalCodeCsvDataSource.setConnectionProperties("columnTypes=string,int,string,string,string,string,string,string,string,string");
        return postalCodeCsvDataSource;
	}
}
