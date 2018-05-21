package it.polito.ai.lab4.business.services.images;

import it.polito.ai.lab4.repo.entities.Image;
import it.polito.ai.lab4.repo.entities.UserProfile;

public interface ImagesService {
	
	public Image getImage(long id);
	
	public Image saveUserImage(UserProfile userProfile, byte[] imageBytes);
}
