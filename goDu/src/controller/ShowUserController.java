package controller;

import javax.swing.DefaultListModel;

import model.Group;
import model.User;
import model.database.DatabaseProvider;
import view.Home;
import view.RegisterEditUser;
import view.RegisterUser;
import view.ShowUser;

/**
 * Classe controller da view.ShowUser, tem como função gerenciar e linkar os
 * botões clicados com suas respectivas páginas.
 * 
 * @see javax.swing.DefaultListModel
 * @see model.User
 * @see model.database.DatabaseProvider
 * @see view.Home
 * @see view.RegisterEditUser
 * @see view.RegisterUser
 * @see view.ShowUser
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class ShowUserController {
	private ShowUser view;
	private User pickedUserEdit;
	private User pickedUserDelete;

	public ShowUserController() {

	}

	/**
	 * Construtor recebe a view a qual irá gerenciar.
	 * 
	 * @param view
	 */
	public ShowUserController(ShowUser view) {
		super();
		this.view = view;
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Caso buttonBack: volte à Home. Caso buttonEdit: verifique se algum
	 * usuário foi selecionado, então encaminha a página RegisterEditUser. Caso
	 * buttonNewUser: redireciona para a página RegisterUser. Caso buttonDelete:
	 * verifica se algum usuário foi selecionado, então deleta o mesmo.
	 * 
	 * @param source Um botao da tela
	 */
	public void sendAction(Object source) {
		if (source == view.getButtonBack()) {
			new Home();
		} else if (source == view.getButtonEdit()) {
			String pickedName = view.getFieldUser().getSelectedValue();

			if (pickedName != null) {
				pickedUserEdit = model.database.DatabaseProvider.searchForPickedUser(pickedName);
				new RegisterEditUser(pickedUserEdit);
			}
		} else if (source == view.getButtonNewUser()) {
			new RegisterUser();
		} else if (source == view.getButtonDelete()) {
			String pickedName = view.getFieldUser().getSelectedValue();

			if (pickedName != null) {
				pickedUserDelete = model.database.DatabaseProvider.searchForPickedUser(pickedName);
				DatabaseProvider.getUsers().remove(pickedUserDelete);
			}
			new ShowUser();
		}

		view.dispose();
	}

	public User getPickedUserDelete() {
		return pickedUserDelete;
	}

	public User getPickedUserEdit() {
		return pickedUserEdit;
	}

	public void deletePickedUser() {
		String pickedName = view.getFieldUser().getSelectedValue();

		if (pickedName != null) {
			User pickedUser = model.database.DatabaseProvider.searchForPickedUser(pickedName);
			DatabaseProvider.getUsers().remove(pickedUser);
		}
		new ShowUser();
	}

	/**
	 * Gera um Model com o nome de todos os usuarios cadastrados.
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