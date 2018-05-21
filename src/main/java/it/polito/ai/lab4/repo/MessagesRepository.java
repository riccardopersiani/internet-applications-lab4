package it.polito.ai.lab4.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.polito.ai.lab4.repo.entities.Message;
import it.polito.ai.lab4.repo.entities.Topic;

public interface MessagesRepository extends PagingAndSortingRepository<Message, Long>{
	public Page<Message> findByTopic(Topic topic, Pageable pageable);
	public List<Message> findByTopicOrderBySendingTimeDesc(Topic topic, Pageable pageable);
}
