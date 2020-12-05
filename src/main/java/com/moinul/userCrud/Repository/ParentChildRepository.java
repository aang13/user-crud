package com.moinul.userCrud.Repository;

import com.moinul.userCrud.Model.ParentChild;
import com.moinul.userCrud.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentChildRepository extends JpaRepository<ParentChild,Long> {

    Optional<ParentChild> findById(Long aLong);

    Optional<ParentChild> findOneByUser(User user);
}
