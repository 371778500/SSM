package com.yonyou.component.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.yonyou.entity.shiro.MemberModel;
import com.yonyou.entity.shiro.PermissionModel;
import com.yonyou.entity.shiro.RoleModel;
import com.yonyou.service.shiro.MemberService;

/**
 * �Զ����ָ��Shiro��֤�û���¼����
 * @author abel.lin
 */
public class SystemAuthorizingRealm extends AuthorizingRealm {
	@Autowired
	private MemberService memberService;
	/**
	 * ��Ȩ��ѯ�ص�����, ���м�Ȩ�����������û�����Ȩ��Ϣʱ����
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
		//��ȡ��ǰ��¼���û���,�ȼ���(String)principals.fromRealm(this.getName()).iterator().next()
		String currentUsername = (String)super.getAvailablePrincipal(principals);
		MemberModel member = memberService.getMemberByName(currentUsername);
		if(member == null){
			throw new AuthenticationException("msg:�û������ڡ�");
		}
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		
		List<RoleModel> roleList = memberService.selectRoleByMemberId(member.getId());
		List<PermissionModel> permList = memberService.selectPermissionByMemberId(member.getId());
		
		if(roleList != null && roleList.size() > 0){
			for(RoleModel role : roleList){
				if(role.getRoleCode() != null){
					simpleAuthorInfo.addRole(role.getRoleCode());
				}
			}
		}
		
		if(permList != null && permList.size() > 0){
			for(PermissionModel perm : permList){
				if(perm.getCode() != null){
					simpleAuthorInfo.addStringPermission(perm.getCode());
				}
			}
		}
		return simpleAuthorInfo;
		
	}

	
	/**
	 * ��֤�ص�����, ��¼ʱ����
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		//��ȡ�����û��������������
		//ʵ�������authcToken�Ǵ�LoginController����currentUser.login(token)��������
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
		
		Session session = getSession();
		String code = (String)session.getAttribute(Constants.VALIDATE_CODE);
		if (token.getCaptcha() == null || !token.getCaptcha().toUpperCase().equals(code)){
			throw new AuthenticationException("msg:��֤�����, ������.");
		}
		MemberModel member = memberService.getMemberByName(token.getUsername());
		if(member != null){
			if(member.getIslock() !=null && member.getIslock() == 1){
				throw new AuthenticationException("msg:�����ʺŽ�ֹ��¼.");
			}
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(member.getLoginName(), member.getPwd(), this.getName());
			this.setSession("currentUser", member.getLoginName());
			
			return authcInfo;
		}
		return null;
		
	}
	
	/**
	 * �����¼��
	 */
	private void setSession(Object key, Object value){
		Session session = getSession();
		System.out.println("SessionĬ�ϳ�ʱʱ��Ϊ[" + session.getTimeout() + "]����");
		if(null != session){
			session.setAttribute(key, value);
		}
	}
	
	private Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
}