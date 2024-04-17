// PCRepository.java
package com.group9.internetcafe.Repository;

import com.group9.internetcafe.Entity.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PCRepository extends JpaRepository<PC, Integer> {
    // Define custom query methods here if needed
}
