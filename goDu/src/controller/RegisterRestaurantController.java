package controller;

import java.util.List;

import model.Accommodation;
import model.Group;
import model.Restaurant;
import model.Transportation;
import model.User;
import model.database.DatabaseProvider;
import view.EditGroup;
import view.Home;
import view.RegisterRestaurant;

public class RegisterRestaurantController {

	private final RegisterRestaurant view;

	public RegisterRestaurantController(RegisterRestaurant view) {
		super();
		this.view = view;
	}

	public void sendAction(Object source) {
		if (source == view.getButtonConfirm()) {
			String pickedNameSplitted = GroupController.nameGroupEdit.substring(0,
					GroupController.nameGroupEdit.lastIndexOf(" -"));
			registerNewRestaurant((pickedNameSplitted));
			System.out.println(DatabaseProvider.getGroups());
			new Home();
		} else if (source == view.getButtonCancel()) {
			new EditGroup();
		}
	}

	public void registerNewRestaurant(String name) {
		for (Group currentGroup : DatabaseProvider.getGroups()) {
			if (name.equals(currentGroup.getNameGroup())) {

				String nameRestaurant = view.getTextFieldRestaurant().getText();
				Integer stars = Integer.parseInt(view.getFieldStars().getText());
				String meal = view.getFieldMeal().getText();
				double MealCost = Double.parseDouble(view.getTextFieldCost().getText());

				String names = currentGroup.getNameGroup();
				User creator = currentGroup.getCreator();
				String motivation = currentGroup.getMotivation();
				String expectedDate = currentGroup.getExpectedDate();
				List<User> members = currentGroup.getMembers();
				List<Transportation> tRANSPORTATION = currentGroup.getTRANSPORTATION();
				int numberOfMembers = currentGroup.getNumberOfMembers();
				List<Restaurant> rESTAURANT = currentGroup.getRESTAURANT();
				List<Accommodation> aCCOMMODATION = currentGroup.getACCOMMODATION();
				double totalPrice = currentGroup.getTotalPrice();
				Restaurant restaurant = new Restaurant(nameRestaurant, stars, meal, MealCost);
				rESTAURANT.add(restaurant);

				Group group = new Group(names, creator, motivation, expectedDate, members, tRANSPORTATION,
						numberOfMembers, rESTAURANT, aCCOMMODATION, totalPrice);

				DatabaseProvider.getGroups().add(group);

				DatabaseProvider.getGroups().remove(currentGroup);
			}
		}
	}

}