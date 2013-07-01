/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.demo.webapps.safety;
import org.more.util.StringUtils;
import org.moreframework.context.AppContext;
import org.moreframework.security.SecAuth;
import org.moreframework.security.SecurityAuth;
import org.moreframework.security.UserInfo;
import org.platform.webapps.safety.AdminUser;
/**
 * 
 * @version : 2013-4-28
 * @author ������ (zyc@byshell.org)
 */
@SecAuth(authSystem = "AdminAuth")
public class AdminSecurityAuth implements SecurityAuth {
    //
    @Override
    public void initAuth(AppContext appContext) {}
    @Override
    public UserInfo getUserInfo(String userCode) {
        AdminUser guestUser = new AdminUser();
        guestUser.setAccount(userCode.split("@")[0]);
        guestUser.setPassword(userCode.split("@")[1]);
        return guestUser;
    }
    @Override
    public UserInfo getUserInfo(String account, String password) {
        // 
        if (StringUtils.eqUnCaseSensitive(account, password)) {
            AdminUser adminUser = new AdminUser();
            adminUser.setAccount(account);
            adminUser.setPassword(password);
            return adminUser;
        }
        return null;
    }
    @Override
    public void destroyAuth(AppContext appContext) {}
}