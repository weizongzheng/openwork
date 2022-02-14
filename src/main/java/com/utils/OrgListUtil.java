package com.utils;
import com.pojo.IntoOrg;
import com.pojo.Org;
import com.service.IntoOrgService;
import java.util.*;
public class OrgListUtil {
    public static List<String> getOrgListAllUser(List<String> orgIds, IntoOrgService intoOrgService){
        List<String> lists=new ArrayList<>();
        for(String orgId:orgIds)
        {
            List<IntoOrg> into_user_list = intoOrgService.getInto_User_List(orgId);
            for(IntoOrg intoOrg:into_user_list)
            {
                lists.add(intoOrg.getUsername());
            }
        }
        return lists;
    }
}
