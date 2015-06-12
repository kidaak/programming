package viewmodel.component;

import java.util.ArrayList;
import java.util.List;

import model.User;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.event.InputEvent;

public class SearchboxVM {
	private List<User> searchResult;
	private User selectedResult;

	public User getSelectedResult() {
		return selectedResult;
	}

	public void setSelectedResult(User selectedResult) {
		this.selectedResult = selectedResult;
	}

	private String searchText;

	@Init(superclass = true)
	public void init() {
		searchResult = new ArrayList<User>();
		searchResult
				.add(new User("hoangnv28", "Master", "/Share/img/hulk.png"));
		searchResult.add(new User("Bill Gates", "employee",
				"/Share/img/frog.png"));
		searchResult
				.add(new User("Steve Jobs", "Tester", "/Share/img/man.png"));
	}

	@Command
	public void onChangingSearchText(
			@ContextParam(ContextType.TRIGGER_EVENT) InputEvent event) {
		System.out.println(event.getValue());
	}

	public List<User> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<User> searchResult) {
		this.searchResult = searchResult;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
}
