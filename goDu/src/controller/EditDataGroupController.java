package controller;

import java.util.List;

import model.Accommodation;
import model.Group;
import model.Restaurant;
import model.Transportation;
import model.User;
import model.database.DatabaseProvider;
import view.EditDataGroup;
import view.EditGroup;
import view.Home;

public class EditDataGroupController {

	private final EditDataGroup view;

	public EditDataGroupController(EditDataGroup view) {
		super();
		this.view = view;
	}

	public void sendAction(Object source) {
		if (source == view.getButtonConfirm()) {
			String pickedNameSplitted = GroupController.nameGroupEdit.substring(0,
					GroupController.nameGroupEdit.lastIndexOf(" -"));
			editDataGroup((pickedNameSplitted));
			System.out.println(DatabaseProvider.getGroups());
			new Home();
		} else if (source == view.getButtonCancel()) {
			new EditGroup();
		}
	}

	private void editDataGroup(String name) {
		for (Group currentGroup : DatabaseProvider.getGroups()) {
			if (name.equals(currentGroup.getNameGroup())) {

				String names;
				String motivation;
				String expectedDate;
				Integer numberOfMembers;

				if (view.getFieldName().getText().isEmpty()) {
					names = currentGroup.getNameGroup();
				} else {
					names = view.getFieldName().getText();
				}

				if (view.getFieldMotivation().getText().isEmpty()) {
					motivation = currentGroup.getMotivation();
				} else {
					motivation = view.getFieldMotivation().getText();
				}

				if (view.getFieldData().getText() == "__/__/____") {
					expectedDate = currentGroup.getExpectedDate();
				} else {
					expectedDate = view.getFieldData().getText();
				}

				if (view.getFieldMembers().getText().length() == 0) {
					numberOfMembers = currentGroup.getNumberOfMembers();
				} else {
					numberOfMembers = Integer.parseInt(view.getFieldMembers().getText());
				}

				User creator = currentGroup.getCreator();
				List<User> members = currentGroup.getMembers();
				List<Transportation> tRANSPORTATION = currentGroup.getTRANSPORTATION();
				List<Restaurant> rESTAURANT = currentGroup.getRESTAURANT();
				List<Accommodation> aCCOMMODATION = currentGroup.getACCOMMODATION();
				double totalPrice = currentGroup.getTotalPrice();

				Group group = new Group(names, creator, motivation, expectedDate, members, tRANSPORTATION,
						numberOfMembers, rESTAURANT, aCCOMMODATION, totalPrice);

				DatabaseProvider.getGroups().add(group);

				DatabaseProvider.getGroups().remove(currentGroup);
			}
		}

	}

}
