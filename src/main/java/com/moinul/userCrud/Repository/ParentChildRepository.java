package com.moinul.userCrud.Repository;

import com.moinul.userCrud.Model.ParentChild;
import com.moinul.userCrud.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParentChildRepository extends JpaRepository<ParentChild,Long> {

    List<ParentChild> findAllByParent(User user);

    Optional<ParentChild> findOneByUser(User user);
}
