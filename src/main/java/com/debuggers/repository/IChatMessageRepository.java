package com.debuggers.repository;

import com.debuggers.domain.Chatmessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChatMessageRepository extends JpaRepository<Chatmessage,Long> {
}
