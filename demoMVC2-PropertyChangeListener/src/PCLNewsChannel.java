import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//https://www.baeldung.com/java-observer-pattern

public class PCLNewsChannel implements PropertyChangeListener {
 
    private String news;
 
    public void propertyChange(PropertyChangeEvent evt) {
        this.setNews((String) evt.getNewValue());
    }

	private void setNews(String newValue) {
		this.news=newValue;
		
	}
	
	public static void main(String[] args) {
		PCLNewsAgency observable = new PCLNewsAgency();
		PCLNewsChannel observer = new PCLNewsChannel();

		System.out.println("news antes: "+observer.getNews());
 

		observable.addPropertyChangeListener(observer);
		observable.setNews("news");
		 
		//assertEquals(observer.getNews(), "news");
		System.out.println("news depois: "+observer.getNews());
	}

	private Object getNews() {
		// TODO Auto-generated method stub
		return news;
	}
}