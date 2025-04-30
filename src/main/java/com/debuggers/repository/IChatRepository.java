package com.debuggers.repository;

import com.debuggers.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChatRepository extends JpaRepository<Chat,Long>{

}
