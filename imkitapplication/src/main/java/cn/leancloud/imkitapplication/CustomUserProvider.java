package cn.leancloud.imkitapplication;

import java.util.ArrayList;
import java.util.List;

import cn.leancloud.imkit.LCIMKitUser;
import cn.leancloud.imkit.LCIMProfileProvider;
import cn.leancloud.imkit.LCIMProfilesCallBack;

/**
 * Created by wli on 15/12/4.
 * 实现自定义用户体系
 */
public class CustomUserProvider implements LCIMProfileProvider {

  private static List<LCIMKitUser> partUsers = new ArrayList<LCIMKitUser>();

  // 此数据均为 fake，仅供参考
  private static String[] avatarList = new String[] {
    "http://ac-x3o016bx.clouddn.com/CsaX0GuXL7gXWBkaBFXfBWZPlcanClEESzHxSq2T.jpg",
    "http://ac-x3o016bx.clouddn.com/jUOhrGh3CkIaFwvf4ofNfl7YaBjWlmzSs6q8h4cQ.jpg",
    "http://ac-x3o016bx.clouddn.com/FKnGDRxoy5UcZJWCrd1Tf51XkY4dfv6BvXR3TVOP.jpg",
    "http://ac-x3o016bx.clouddn.com/7d6FwrxPGn1Xoym5QE6EU8PLay1FXyHQmO6cQiBw.jpg",
    "http://ac-x3o016bx.clouddn.com/EHVl1ElC7JGmHQOrcDKaMKQDdeVZVzBJqHBDjqjZ.png",
    "http://ac-x3o016bx.clouddn.com/wYerGOiBrWznlFMjp98UyVm1prS8DV1zand1rjLC.jpg",
    "http://ac-x3o016bx.clouddn.com/PhNmVC496BirXdqH0uNfD9rgbp74eT4qBdX7diIl.jpg",
    "http://ac-x3o016bx.clouddn.com/dqfZn3HVCwrNmnCnY4DZQ4ypvdsJN6iMeQHOuKZ2.png",
    "http://ac-x3o016bx.clouddn.com/A907sNcLmnFECwqL7piOZjuhzah9IsYirreUfH8f.png",
    "http://ac-x3o016bx.clouddn.com/gyYyrsnLdwaC7LHTZ538U51jKqKsZpbrteafNew9.png"
  };
  static {
    for (int i = 0; i < 36; i++) {
      partUsers.add(new LCIMKitUser(i + 100 + "", "user_" + i, avatarList[i%10]));
    }
  }

  @Override
  public void fetchProfiles(List<String> list, LCIMProfilesCallBack callBack) {
    List<LCIMKitUser> userList = new ArrayList<LCIMKitUser>();
    for (String userId : list) {
      for (LCIMKitUser user : partUsers) {
        if (user.getUserId().equals(userId)) {
          userList.add(user);
          break;
        }
      }
    }
    callBack.done(userList, null);
  }
}
