package com.topq.testteamwork;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SingletonFileConfiguration {
	private static SingletonFileConfiguration instance = null;
	private Properties  m_prop;
	
	public SingletonFileConfiguration(){
		m_prop = new Properties();
		FileInputStream fts = null;
		try{
			fts = new FileInputStream("config.properties");
			m_prop.load(fts);	
		}
		catch(Exception e){	
		}finally{
			try{
				fts.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}	
	}
	
	public synchronized static SingletonFileConfiguration getInstance(){
		if(instance == null){
			instance = new SingletonFileConfiguration();
		}
		return instance;
	}
	
	public String getMyProperties(String key){
		return m_prop.getProperty(key);	
	}
}	
	
	
	
	

















	
	
	
	
	
	/*public static SingletonFileConfiguration getInstance(String propFileName) throws IOException {
		m_singleton.getFileInformation(propFileName);
		return m_singleton;
    }
	
	public void getFileInformation(String propFileName) throws IOException{	
		Properties prop = new Properties();
		m_inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		if (m_inputStream != null) {
			prop.load(m_inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		} 
	}
	
	public String getUrl(){
		return  m_prop.getProperty("url");
	}
		
	public String getUserName(){
		return  m_prop.getProperty("username");
	}
	
	public String getUserPassword(){
		return  m_prop.getProperty("password");
	}*/	
/*}*/