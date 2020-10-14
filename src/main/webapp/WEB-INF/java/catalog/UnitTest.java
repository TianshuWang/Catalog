package catalog;

import org.junit.Test;

import com.certant.entities.Film;
import com.certant.entities.FilmType;
import com.certant.entities.Item;
import com.certant.entities.ItemType;
import com.certant.persistent.FactoryRepository;
import com.certant.persistent.Repository;

public class UnitTest {
	Repository<Item> repoItem = FactoryRepository.get(Item.class);
	
	@Test
	public void addItems() {
		FilmType action = new FilmType();
		action.setName("Action");
		ItemType film = new Film("Film",action,2019);
		
		Item jumanji = new Item();
		jumanji.setName("jumanji");
		jumanji.setItemType(film);
		jumanji.setScore(5);
		
		repoItem.add(jumanji);
	}
}
