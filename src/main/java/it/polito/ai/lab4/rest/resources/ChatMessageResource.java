package it.polito.ai.lab4.rest.resources;

import java.util.Calendar;

import org.springframework.hateoas.ResourceSupport;

import it.polito.ai.lab4.business.services.chat.ChatMessage;

public class ChatMessageResource extends ResourceSupport{

	public String text;
	public Calendar sendingTime;
	public String image;
	
	public ChatMessageResource(ChatMessage chatMessage) {
		this.text = chatMessage.getText();
		this.sendingTime = chatMessage.getSendingTime();
		this.image = chatMessage.getImageUrl();
	}

}
