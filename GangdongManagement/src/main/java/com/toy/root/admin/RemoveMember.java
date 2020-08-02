package com.toy.root.admin;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.toy.root.admin.GetMember;
import com.toy.root.admin.MemberInfo;

@Service
public class RemoveMember {
	public String process(String nickname)
	{
		MemberInfo memberInfo = new MemberInfo();
		GetMember getMember = new GetMember();
		
		memberInfo = getMember.ByNickName(nickname);
		if (null == memberInfo)
		{
			return ErrorList.ERROR_NOT_EXIST_NICKNAME;
		}
		
		memberInfo.set_nickname(nickname + "_dead");
		memberInfo.set_quitDate(new Date(System.currentTimeMillis()));
		memberInfo.set_alive(false);
		
		return getMember.Set(memberInfo);
	}
}
