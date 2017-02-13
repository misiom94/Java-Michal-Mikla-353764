package pl.lodz.uni.math.daofactory;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;


public class Factory {
    
    private Source dataSource;
    public static final Logger logger = Logger.getLogger(Factory.class.getName());
    Map<SourceOfData,Source> sourceMap = new HashMap<SourceOfData,Source>();
    
    public Factory()
    {
        sourceMap.put(SourceOfData.DB, DbSource.getInstance());
        sourceMap.put(SourceOfData.XML, XmlSource.getInstance());
        sourceMap.put(SourceOfData.WS, WsSource.getInstance());
    }
    
    public void setDataSource(SourceOfData source){
        dataSource = sourceMap.get(source);
        logger.info("Source of data changed");
        
	}
    
      public Source getSourceOfData() {
		return dataSource;  
                
    }
    
    
    
}
