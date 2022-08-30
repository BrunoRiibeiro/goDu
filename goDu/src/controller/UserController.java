package controller;

import javax.swing.DefaultListModel;

import model.User;
import model.database.DatabaseProvider;
import view.EditUser;
import view.Home;
import view.RegisterUser;
import view.ShowUser;

public class UserController {
	private ShowUser view;
	public static User pickedUserEdit;
	private User pickedUserDelete;

	public UserController() {

	}

	public UserController(ShowUser view) {
		super();
		this.view = view;
	}

	public void sendAction(Object source) {
		if (source == view.getButtonBack()) {
			new Home();
		} else if (source == view.getButtonEdit()) {
			String pickedName = view.getFieldUser().getSelectedValue();

			if (pickedName != null) {
				pickedUserEdit = searchForPickedUser(pickedName);
			}
		} else if (source == view.getButtonNewUser()) {
			new RegisterUser();
		} else if (source == view.getButtonDelete()) {
			deletePickedUser();
		}
	}

	public User getPickedUserDelete() {
		return pickedUserDelete;
	}

	public User getPickedUserEdit() {
		return pickedUserEdit;
	}

	public User searchForPickedUser(String nome) {
		for (User currentUser : DatabaseProvider.getUsers()) {
			if (nome.equals(currentUser.getName())) {
				return currentUser;
			}
		}
		return null;
	}
	
	public void deletePickedUser() {
		String pickedName = view.getFieldUser().getSelectedValue();

		if (pickedName != null) {
			pickedUser = searchForPickedUser(pickedName);
			DatabaseProvider.getUsers().remove(pickedUser);
		}

		System.out.println(DatabaseProvider.getUsers());
		new ShowUser();
	}

	/**
	 * Gera um Model com o nome de todos os atores cadastrados.
	 * 
	 * @return DefaultListModel
	 */
	public DefaultListModel<String> updateList() {
		DefaultListModel<String> names = new DefaultListModel<>();

		for (User currentUser : DatabaseProvider.getUsers()) {
			names.addElement(currentUser.getName());
		}

		return names;
	}

}