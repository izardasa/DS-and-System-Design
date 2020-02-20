package systemdesign.facebook.impl;

public class Profile extends Account {
	private String profileId;
	private String registrationDate;

	private boolean addEducation(Education education) {
		return true;
	}

	private boolean addWork(Work work) {
		return true;
	}

	private boolean addProfilePic(ProfilePic profilePic) {
		return true;
	}

	private boolean addPlace(Place place) {
		return true;
	}
}
