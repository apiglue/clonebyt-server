package io.apiglue.clonebyt.clonebytserver.message;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {
    @Query("SELECT m FROM Message m WHERE m.expirationDate >= CURRENT_TIMESTAMP")
    @NonNull List<Message> findAllValid();
}
