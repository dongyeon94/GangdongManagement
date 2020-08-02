package com.toy.root.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toy.root.db.DbUser;
import com.toy.root.repository.UserRepository;
import com.toy.root.admin.MemberInfo;

import com.toy.root.admin.ErrorList;
@Service
public class GetMember {

	private UserRepository _userrepo;
	
	public MemberInfo ByNickName(String nickname)
	{			
		MemberInfo memberInfo = new MemberInfo();
		
		try
		{
			List<DbUser> userList = _userrepo.findAllByNickname(nickname);
		
			if (userList.size() != 1)
			{
				return null;
			}
			
			DbUser userInfo = userList.get(0);
			
			memberInfo.set_age(userInfo.getAge());
			memberInfo.set_alive(userInfo.isAlive());
			memberInfo.set_joinDate(userInfo.getJoinDate());
			memberInfo.set_memo(userInfo.getMemo());
			memberInfo.set_nickname(userInfo.getNickName());
			memberInfo.set_quitDate(userInfo.getQuitDate());
			memberInfo.set_sex(userInfo.isMan());
			
		} catch (Exception e) {
			
		}
		
		return memberInfo;
	}

	public String Set(MemberInfo memberInfo) {
		try
		{
			DbUser userInfo = new DbUser();
			
			userInfo.setAge(memberInfo.get_age());
			userInfo.setAlive(memberInfo.is_alive());
			userInfo.setJoinDate(memberInfo.get_joinDate());
			userInfo.setMemo(memberInfo.get_memo());
			userInfo.setNickName(memberInfo.get_nickname());
			userInfo.setQuitDate(memberInfo.get_quitDate());
			userInfo.setSex(memberInfo.is_man());
			
			_userrepo.save(userInfo);
			
		} catch (Exception e) {
			// TODO: handle exception
			return ErrorList.ERROR_DB_PERMISSION;
		}
		
		return ErrorList.ERROR_SUCCESS;
	}
	
	
}
