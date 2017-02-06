package pl.lodz.uni.math.daofactory;


public class DaoFactory {
    
    private Source dataSource;
    
    public DaoFactory(){}
    
    public void setDataSource(SourceOfData source){
        switch(source){
            case DB:
                dataSource = DbSource.getInstance();
                break;
            case XML:
                dataSource = XmlSource.getInstance();
                break;
            case WS:
                dataSource = WsSource.getInstance();
                break;
        }

	}
      public Source getSourceOfData() {
		return dataSource;
        
    }
    
    
    
}
