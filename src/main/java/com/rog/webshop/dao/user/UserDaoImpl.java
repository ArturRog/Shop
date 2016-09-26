package com.rog.webshop.dao.user;

import com.rog.webshop.dao.AbstractDao;
import com.rog.webshop.exception.CustomerNotFoundException;
import com.rog.webshop.model.user.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    public List<User> getAllUsers() {
        return super.findAll();
    }

    public void save(User user) {
        persist(user);
    }

    public User findById(int id) {
        return getByKey(id);
    }

    public User findByEmail(String email) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("email", email));
        return (User) crit.uniqueResult();
    }

    public User findBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        return (User) crit.uniqueResult();
    }

    public void updateUser(User user) {

        User newUser = findBySSO(user.getSsoId());
        if (newUser == null) {
            throw new CustomerNotFoundException(user.getEmail());
        }

        newUser.setLastName(user.getLastName());
        newUser.setFirstName(user.getFirstName());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setStreetName(user.getStreetName());
        newUser.setDoorNo(user.getDoorNo());
        newUser.setAreaName(user.getAreaName());
        newUser.setStateName(user.getStateName());
        newUser.setCountry(user.getCountry());
        newUser.setZipCode(user.getZipCode());

        update(user);

    }
}
