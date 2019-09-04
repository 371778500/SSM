package com.yonyou.service.shiro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.entity.shiro.MemberModel;
import com.yonyou.entity.shiro.MemberModelCriteria;
import com.yonyou.entity.shiro.MemberRoleModel;
import com.yonyou.entity.shiro.MemberRoleModelCriteria;
import com.yonyou.entity.shiro.PermissionModel;
import com.yonyou.entity.shiro.PermissionModelCriteria;
import com.yonyou.entity.shiro.RoleModel;
import com.yonyou.entity.shiro.RoleModelCriteria;
import com.yonyou.entity.shiro.RolePermModel;
import com.yonyou.entity.shiro.RolePermModelCriteria;
import com.yonyou.repository.shiro.MemberModelMapper;
import com.yonyou.repository.shiro.MemberRoleModelMapper;
import com.yonyou.repository.shiro.PermissionModelMapper;
import com.yonyou.repository.shiro.RoleModelMapper;
import com.yonyou.repository.shiro.RolePermModelMapper;

/**
 * @author Abel.lin
 */
@Service
public class MemberService {
	@Autowired
	private MemberModelMapper memberMapper;
	@Autowired
	private RoleModelMapper roleMapper;
	@Autowired
	private PermissionModelMapper permMapper;
	@Autowired
	private RolePermModelMapper rolePermMapper;
	@Autowired
	private MemberRoleModelMapper mebRoleMapper;
	
	/**
	 * 根据登录名获取用户
	 * @param loginname
	 * @return
	 */
	public MemberModel getMemberByName(String loginname){
		MemberModelCriteria example = new MemberModelCriteria();
		example.createCriteria().andLoginNameEqualTo(loginname);
		List<MemberModel> memberList = memberMapper.selectByExample(example);
		if(memberList != null && memberList.size() > 0){
			return memberList.get(0);
		}
		
		return null;
	}
	
	public List<RoleModel> selectRoleByMemberId(Integer memberId){
		List<Integer> roleIds = selectRoleIdByMemberId(memberId);
		if(roleIds.size() > 0){
			RoleModelCriteria roleExample = new RoleModelCriteria();
			roleExample.createCriteria().andIdIn(roleIds);
			List<RoleModel> roleList = roleMapper.selectByExample(roleExample);
			return roleList;
		}
		
		return null;
	}
	
	public List<PermissionModel> selectPermissionByMemberId(Integer memberId){
		List<Integer> roleIds = selectRoleIdByMemberId(memberId);
		List<Integer> permIds = selectPermIdByMemberId(roleIds);
		if(permIds.size() > 0){
			PermissionModelCriteria example = new PermissionModelCriteria();
			example.createCriteria().andIdIn(permIds);
			List<PermissionModel> permList = permMapper.selectByExample(example);
			return permList;
		}
		
		return null;
	}
	
	public List<Integer> selectRoleIdByMemberId(Integer memberId){
		MemberRoleModelCriteria example = new MemberRoleModelCriteria();
		example.createCriteria().andMemberIdEqualTo(memberId);
		List<MemberRoleModel> list = mebRoleMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			List<Integer> roleIds = new ArrayList<Integer>();
			for(MemberRoleModel model : list){
				roleIds.add(model.getRoleId());
			}
			return roleIds;
		}
		
		return null;
	}
	
	public List<Integer> selectPermIdByMemberId(List<Integer> roleIds){
		RolePermModelCriteria example = new RolePermModelCriteria();
		example.createCriteria().andRoleIdIn(roleIds);
		List<RolePermModel> list = rolePermMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			List<Integer> permIds = new ArrayList<Integer>();
			for(RolePermModel model : list){
				permIds.add(model.getPermId());
			}
			return permIds;
		}
		
		return null;
	}
}
