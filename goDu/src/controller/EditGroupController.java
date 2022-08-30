package controller;

import view.EditGroup;
import view.RegisterAccomodation;
import view.RegisterTransportation;
import view.ShowGroup;

public class EditGroupController {

	private final EditGroup view;

	public EditGroupController(EditGroup view) {
		super();
		this.view = view;
	}

	public void sendAction(Object source) {
		if (source == view.getButtonAccomodation()) {
			new RegisterAccomodation();
		} else if (source == view.getButtonRestaurant()) {
			// new RegisterGroup();
		} else if (source == view.getButtonTransportation()) {
			new RegisterTransportation();
		} else if (source == view.getButtonEditProfile()) {
			// new ShowUser();
		} else if (source == view.getButtonBackGroup()) {
			new ShowGroup();
		}
	}

}
