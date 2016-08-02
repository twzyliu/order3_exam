package com.thoughtworks.ketsu.domain.User;

import java.util.Map;

public interface UserIntreface {
    void createUser(Map<String ,Object>userinfo);

    User find_user_by_id(int userid);
}
