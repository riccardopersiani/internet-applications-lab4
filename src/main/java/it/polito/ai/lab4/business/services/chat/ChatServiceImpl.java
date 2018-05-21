package it.polito.ai.lab4.business.services.chat;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import it.polito.ai.lab4.repo.MessagesRepository;
import it.polito.ai.lab4.repo.TopicsRepository;
import it.polito.ai.lab4.repo.entities.Message;
import it.polito.ai.lab4.repo.entities.Topic;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {

	@Autowired
	MessagesRepository messagesRepository;
	@Autowired
	TopicsRepository topicsRepository;

	@Override
	public List<ChatMessage> getLastMessages(Topic topic, Integer lastMessages) {
		List<Message> lastMessagesNewestFirst = messagesRepository.findByTopicOrderBySendingTimeDesc(topic, new PageRequest(0, 10));
		return lastMessagesNewestFirst.stream().sorted(Comparator.comparing(Message::getSendingTime))
				.map(message -> new ChatMessageImpl(message)).collect(Collectors.toList());
	}

	@Override
	public Set<Topic> getTopics() {
		return topicsRepository.findAll();
	}

	@Override
	public Topic getTopicByName(String name) {
		return topicsRepository.findByValue(name);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_USER')")
	public void saveMessage(Message message) {
		messagesRepository.save(message);
	}

	@Override
	public Page<ChatMessage> findByTopic(Topic topic, Pageable pageable) {
		 Page<Message> MessagesByTopic = messagesRepository.findByTopic(topic, pageable);
		 return MessagesByTopic.map(message -> new ChatMessageImpl(message));
	}
}
