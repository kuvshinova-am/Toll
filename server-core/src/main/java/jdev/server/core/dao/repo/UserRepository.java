package jdev.server.core.dao.repo;

import jdev.server.core.dao.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
