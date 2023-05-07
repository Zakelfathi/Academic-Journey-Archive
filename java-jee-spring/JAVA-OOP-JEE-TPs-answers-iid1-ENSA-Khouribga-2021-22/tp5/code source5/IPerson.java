package tp5;

import java.util.List;

//Q5
public interface IPerson {
		
	public void save(Personne P);
	
	public void delete(int code);
	
	public void update(Personne P);
	
	public Personne findById(int code);
	
	public List <Personne> findAll() ;
	}
